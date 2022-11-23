package com.world.Y2K.service.login;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.world.Y2K.model.dto.Member;
import com.world.Y2K.service.login.auth.UserDetailsImpl;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
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

		UsernamePasswordAuthenticationToken authenticationToken =
				new UsernamePasswordAuthenticationToken(username, password);

		Authentication authentication = authenticationManager.authenticate(authenticationToken);

		UserDetailsImpl userDetails = (UserDetailsImpl)authentication.getPrincipal();
		System.out.println("로그인완료됨"+userDetails.getMember().getUsername());
		return authentication;
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		
		
		UserDetailsImpl userDetails =  (UserDetailsImpl)authResult.getPrincipal();
		Member member = userDetails.getMember();
		
		if(member.getNickName().equals("null")) {
			request.getRequestDispatcher("/editpage.lo").forward(request, response);
			super.successfulAuthentication(request, response, chain, authResult);
		} else {
			request.setAttribute("userId", member.getUserNo());	
			request.getRequestDispatcher("/login-success.lo").forward(request, response);
			super.successfulAuthentication(request, response, chain, authResult);
		
		}
	}
}













