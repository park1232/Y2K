package com.world.Y2K.service.photo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.world.Y2K.dao.photo.PhotoDAO;
import com.world.Y2K.model.entity.PhotoEntity;
import com.world.Y2K.model.vo.Photo;
import com.world.Y2K.model.vo.Reply;
import com.world.Y2K.service.PhotoStore;





@Service("pService")
public class PhotoServiceImpl extends PhotoStore implements PhotoService {
	
	
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private PhotoDAO pDAO;
	
	private String uploadFolder ="C:/Users/82107/Desktop/upload/";
	
	
	@Override
	public List<Photo> photoList() {
		return pDAO.photoList(sqlSession);
	}


	@Override
	public Photo selectImg(Long boardNo) {
		return pDAO.selectImg(sqlSession, boardNo);
	}

	@Override
	public int deletetImg(Long boardNo) {
		return pDAO.deleteImg(sqlSession, boardNo);
	}


	@Override
	public void updateComent(Photo p) {
		pDAO.updateComent(sqlSession, p);
	}


	@Override
	public int insertPreply(Reply r) {
		return pDAO.insertPreply(sqlSession, r);
	}
	
	@Override
	public ArrayList<Reply> selectReply(Long boardNo) {
		
		return pDAO.selectReply(sqlSession, boardNo);
	}

	




	

	





}
