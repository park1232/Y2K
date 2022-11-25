package com.world.Y2K.service.login;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.world.Y2K.service.login.auth.UserDetailsImpl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class LoginService extends UsernamePasswordAuthenticationFilter{
	
	private final AuthenticationManager authenticationManager;
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(request.getParameter("type").equals("social")) {
			password = "null";
		}
		UsernamePasswordAuthenticationToken authenticationToken = null;
		
		try {
		authenticationToken =new UsernamePasswordAuthenticationToken(username, password);
		} catch(Exception e) {
			log.error("Id와 Password가 일치하지 않습니다.");
		}
		
		Authentication authentication = null;
		
		try {
		authentication = authenticationManager.authenticate(authenticationToken);
		} catch(Exception e) {
			log.error("401 Error (권한없음)");
		}
		
		return authentication;
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {		
		
		UserDetailsImpl userDetails =  (UserDetailsImpl)authResult.getPrincipal();
		
		if(userDetails.getMember().getNickName().equals("null")) {
			request.getRequestDispatcher("/editpage.lo").forward(request, response);
			super.successfulAuthentication(request, response, chain, authResult);
		} else {
			request.setAttribute("userNo", userDetails.getMember().getUserNo());	
			request.getRequestDispatcher("/login-success.lo").forward(request, response);
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", userDetails.getMember());
			super.successfulAuthentication(request, response, chain, authResult);
		}
	}
}













