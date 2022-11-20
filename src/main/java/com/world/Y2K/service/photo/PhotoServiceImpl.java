package com.world.Y2K.service.photo;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.world.Y2K.dao.photo.PhotoDAO;
import com.world.Y2K.model.vo.Photo;





@Service("pService")
public class PhotoServiceImpl implements PhotoService {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private PhotoDAO pDAO;


	
	private String uploadFolder ="C:/Users/82107/Desktop/upload/";
	
	@Override
	public void insertImage(Photo p, MultipartFile file, HttpServletRequest request) {
		
//		String root = request.getSession().getServletContext().getRealPath("resources");
//		
//		String savePath = root+ "\\uploadFiles";
		
//		String savePath = "C:\\Users\\82107\\Desktop\\upload/";
//		
//		File folder = new File(savePath);
//		if(!folder.exists()) {
//			folder.mkdirs();
//		}
		
		UUID uuid = UUID.randomUUID();
		
		String originFileName = file.getOriginalFilename();

		String renameFileName = uuid+"_"+originFileName;
		
//		String renamePath = folder + "\\" + renameFileName;
		
		Path imageFilePath = Paths.get(uploadFolder+renameFileName);

		try {
			//file.transferTo(new File(renamePath));
			Files.write(imageFilePath, file.getBytes());
		} catch (Exception e) {
			
			System.out.println("파일 전송 에러 : " + e.getMessage() );
			
		}
		
		p.setPhotoName(originFileName);
		p.setPhotoPath(uploadFolder);
		p.setRenameName(renameFileName);
		
		
		System.out.println(originFileName);
		System.out.println(imageFilePath);
		System.out.println(renameFileName);
		
		
		pDAO.insertImage(sqlSession, p);
	
	}

	
	
	
	
	@Override
	public List<Photo> photoList() {
		
		
		return pDAO.photoList(sqlSession);
	}







}
