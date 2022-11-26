package com.world.Y2K.service.login;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.world.Y2K.dao.login.LoginDAO;

@Service
public class ChangePasswordServiceImpl implements ChangePasswordService{

	@Autowired
	private LoginDAO loginDAO;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public void changePassword(String username, String password) {
		System.out.println("½ÇÇàµÊ?");
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("username", username);
		map.put("password", bCryptPasswordEncoder.encode(password));
		
		System.out.println(loginDAO.updatePassword(map));
		
	}
}
