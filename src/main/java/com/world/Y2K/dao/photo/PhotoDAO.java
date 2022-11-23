package com.world.Y2K.dao.photo;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.world.Y2K.model.vo.Photo;




@Repository("pDAO")
public class PhotoDAO {

	public void insertImage(SqlSessionTemplate sqlSession, Photo p) {
		
		sqlSession.insert("photoMapper.insertPhoto", p);
	}

	public List<Photo> photoList(SqlSessionTemplate sqlSession) {
		
		return sqlSession.selectList("photoMapper.selectPhotoList");
	}

	public Photo selectImg(SqlSessionTemplate sqlSession, Long photoNo) {
		
		return sqlSession.selectOne("photoMapper.selectPhoto", photoNo);
	}

	public int deleteImg(SqlSessionTemplate sqlSession, Long photoNo) {
		
		return sqlSession.update("photoMapper.deletePhoto", photoNo);
	}
	
	public void updateAll(SqlSessionTemplate sqlSession, Photo p) {
		
		sqlSession.update("photoMapper.updateAll", p);
		
	}

	public void updateComent(SqlSessionTemplate sqlSession, Photo p) {
		
		System.out.println(p);
		
		sqlSession.update("photoMapper.updateComent", p);
	}


	
	
	
}
