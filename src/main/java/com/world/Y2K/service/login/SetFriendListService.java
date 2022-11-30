package com.world.Y2K.service.login;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.world.Y2K.dao.login.LoginDAO;

@Service
public class SetFriendListService {

	@Autowired
	private LoginDAO loginDAO;

	public void setFreindList(HttpSession session, Authentication authentication) {
		
		
	}
}
