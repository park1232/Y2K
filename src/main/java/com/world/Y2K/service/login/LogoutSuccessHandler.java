package com.world.Y2K.service.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;


@Service
public class LogoutSuccessHandler implements org.springframework.security.web.authentication.logout.LogoutSuccessHandler{

	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		
		HttpSession session = request.getSession();
		session.removeAttribute("loginUser");

	}
}
