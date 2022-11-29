package com.world.Y2K.dao.skin;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.world.Y2K.model.dto.Skin;

@Repository("skinDAO")
public class SkinDAO {

	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public int insertDefault(Long userNo) {
		sqlSession.insert("skinMapper.insertDefault1", userNo);
		sqlSession.insert("skinMapper.insertDefault2", userNo);
		sqlSession.insert("skinMapper.insertDefault3", userNo);
		sqlSession.insert("skinMapper.insertDefault4", userNo);
		sqlSession.insert("skinMapper.insertDefault5", userNo);
		sqlSession.insert("skinMapper.insertDefault6", userNo);
		return sqlSession.insert("skinMapper.insertDefault7", userNo);
	}

	public ArrayList<Skin> getList(Long userNo) {
		return (ArrayList)sqlSession.selectList("skinMapper.getListSkin", userNo);
		
	}
}
