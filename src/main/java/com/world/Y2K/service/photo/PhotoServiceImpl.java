package com.world.Y2K.service.photo;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.world.Y2K.dao.photo.PhotoDAO;
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
	public List<Photo> photoList(Long userNo) {
		return pDAO.photoList(sqlSession, userNo);
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


//	@Override
//	public int insertPreply(Reply r) {
//		return pDAO.insertPreply(sqlSession, r);
//	}
	
	@Override
	public ArrayList<Reply> selectReply(Long boardNo) {
		
		System.out.println(boardNo);
		
		return pDAO.selectReply(sqlSession, boardNo);
	}

	




	

	





}
