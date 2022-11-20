package com.world.Y2K.service.login;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.world.Y2K.dao.login.LoginDAO;
import com.world.Y2K.model.dto.Member;
import com.world.Y2K.model.vo.User;

@Service
public class RegisterServiceImpl implements RegisterService{

	@Autowired
	private LoginDAO loginDAO;	
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public int registerMember(User user) {
		System.out.println(user.getUsername());
		System.out.println(user.getNickName());
		System.out.println(user.getPassword()); 
		return loginDAO.registerMember(sqlSession,setMember(user));	
	}

	
	private Member setMember(User user) {
		return Member.builder()
				.username(user.getUsername())
				.password(bCryptPasswordEncoder.encode(user.getPassword()))
				.nickName(user.getNickName())
				.status("Y")
				.orange(0L)
				.role("ROLE_USER")
				.provider("LOCAL")
				.providerId("NULL")
				.build();
	}



}
