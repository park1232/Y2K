package com.world.Y2K.dao.login;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.world.Y2K.model.dto.Member;

@Repository("loginDAO")
public class LoginDAO {

	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public int registerMember(Member member) {
		return sqlSession.insert("memberMapper.registerMember", member);
	}

	public Member findUser(String username) {
		return sqlSession.selectOne("memberMapper.findUser", username);
		
	}

}
