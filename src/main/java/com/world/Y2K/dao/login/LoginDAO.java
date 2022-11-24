package com.world.Y2K.dao.login;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.world.Y2K.model.dto.Member;

@Repository("loginDAO")
public class LoginDAO {

	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public int registerMember(Member member) {
		System.out.println(member);
		return sqlSession.insert("memberMapper.registerMember", member);
	}

	public Member findUser(String username) {
		return sqlSession.selectOne("memberMapper.findUser", username);
		
	}
	
	public int checkUser(String username) {
		return sqlSession.selectOne("memberMapper.checkUser", username);
	}
	
	public int updateNickname(HashMap<String, Object> map) {
		return sqlSession.update("memberMapper.updateNickname", map);
	}
	

}
