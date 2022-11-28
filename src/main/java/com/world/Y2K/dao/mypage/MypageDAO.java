package com.world.Y2K.dao.mypage;

import java.util.ArrayList;

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
	
	public int checkFirst(Long userNo) {
		return sqlSession.selectOne("mypageMapper.checkFirst", userNo);
	}
	

	
	
}
