package com.world.Y2K.service.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.world.Y2K.dao.login.LoginDAO;
import com.world.Y2K.model.dto.Member;
import com.world.Y2K.model.vo.User;

import lombok.RequiredArgsConstructor;


@Service("registerService")
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private LoginDAO loginDAO;
	
	
	@Override
	public int registerMember(User user) {
		return loginDAO.registerMember(setMember(user));	

	}
	
	private Member setMember(User user) {
		return Member.builder()
				.username(user.getUsername())
				.password(bCryptPasswordEncoder.encode(user.getPassword()))
				.nickName(user.getNickName())
				.email(user.getEmail())
				.status("Y")
				.orange(0L)
				.role("ROLE_USER")
				.provider("LOCAL")
				.providerId("NULL")
				.build();
	}

	
	
}
