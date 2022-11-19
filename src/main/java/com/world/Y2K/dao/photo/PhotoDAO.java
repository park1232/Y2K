package com.world.Y2K.dao.photo;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.world.Y2K.model.vo.Photo;




@Repository("pDAO")
public class PhotoDAO {

	public void insertImage(SqlSessionTemplate sqlSession, Photo p) {
		
		
		sqlSession.insert("photoMapper.insertPhoto", p);
	}

	
	
	
}
