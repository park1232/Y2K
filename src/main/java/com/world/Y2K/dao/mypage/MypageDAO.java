package com.world.Y2K.dao.mypage;

import java.util.ArrayList;
import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.world.Y2K.model.dto.Mypage;

@Repository("mypageDAO")
public class MypageDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;

	public Mypage getOnloadEntity(Long myUserNo) {
		return sqlSession.selectOne("mypageMapper.getMypageEntity", myUserNo);
	}
	
	public int insertDefault(Long userNo) {
		return sqlSession.insert("mypageMapper.insertDefaulEntity", userNo);
	}
	
	public int checkFirst(Long myUserNo) {
		System.out.println(myUserNo);
		return sqlSession.selectOne("mypageMapper.checkFirst", myUserNo);
	}

	public void updateSkinPath(HashMap<String, Object> map) {
		sqlSession.update("mypageMapper.updateSkinPath", map);
		
	}

	public void updateTitle(HashMap<String, Object> map) {
		sqlSession.update("mypageMapper.updateTitle", map);
	}

	public void updateContent(HashMap<String, Object> map) {
		sqlSession.update("mypageMapper.updateContent", map);
		
	}


	

	
	
}
