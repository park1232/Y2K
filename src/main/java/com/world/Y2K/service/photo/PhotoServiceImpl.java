package com.world.Y2K.service.photo;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
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

	@Override
	public void insertImage(Photo p, MultipartFile files, HttpServletRequest request) {
		
		String root = request.getSession().getServletContext().getRealPath("resources");
		
		String savePath = root+ "\\uploadFiles";
		
		File folder = new File(savePath);
		
		if(!folder.exists()) {
			folder.mkdirs();
		}
		
		UUID uuid = UUID.randomUUID();
		
		String originFileName = files.getOriginalFilename();

		String renameFileName = uuid+"_"+originFileName;
		
		String renamePath = folder + "||" + renameFileName;
		
		try {
			files.transferTo(new File(renamePath));
	
		} catch (Exception e) {
			
			System.out.println("파일 전송 에러 : " + e.getMessage() );
			
		}
		
		p.setPhotoName(originFileName);
		p.setPhotoPath(renamePath);
		p.setRenameName(renameFileName);
		
		
		System.out.println(originFileName);
		System.out.println(renamePath);
		System.out.println(renameFileName);
		
		
		 pDAO.insertImage(sqlSession,  p);
	
}
	
}
