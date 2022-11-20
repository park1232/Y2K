package com.world.Y2K.service.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.world.Y2K.dao.login.LoginDAO;
import com.world.Y2K.model.dto.Member;
import com.world.Y2K.model.vo.User;

<<<<<<< HEAD
@Service
public class RegisterServiceImpl implements RegisterService {

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private LoginDAO loginDAO;
	
//	
//	public RegisterServiceImpl() {
//		this.loginDAO = LoginDAO.getLoginDAO();
//		
=======
@Service("aservice")
public class RegisterServiceImpl implements RegisterService{

	@Override
	public String joinMember(User user) {
		

//		Member member  = setMember(user);

		//Member member  = setMember(user);

		
		return null;
	}
//
//	private Member setMember(User user) {
//
>>>>>>> 34af81e1153239d0cc90e725123dd6f745288eec
//	}
	
	
	@Override
	public int registerMember(User user) {
		return loginDAO.registerMember(setMember(user));	

	}
	
	private Member setMember(User user) {
		return Member.builder()
				.username(user.getUsername())
				.password("{bcrypt}"+bCryptPasswordEncoder.encode(user.getPassword()))
				.nickName(user.getNickName())
				.status("Y")
				.orange(0L)
				.role("ROLE_USER")
				.provider("LOCAL")
				.providerId("NULL")
				.build();
	}

	
	
}
