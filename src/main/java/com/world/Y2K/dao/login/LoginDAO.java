package com.world.Y2K.dao.login;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.world.Y2K.model.dto.Member;

@Repository("loginDAO")
public class LoginDAO {

	
	
	public int registerMember(SqlSessionTemplate sqlSession, Member member) {
		return sqlSession.insert("memberMapper.registerMember", member);
	}

}
