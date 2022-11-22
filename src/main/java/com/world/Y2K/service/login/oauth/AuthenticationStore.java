package com.world.Y2K.service.login.oauth;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.world.Y2K.service.login.auth.UserDetailsImpl;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AuthenticationStore extends UsernamePasswordAuthenticationFilter{
	
	private final AuthenticationManager authenticationManager;
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		System.out.println("½ÇÇàµÊ");
		
//		System.out.println(request.getAttribute("username"));
//		System.out.println(request.getHeader("username"));
//		System.out.println(request.getHeader("username"));
//		System.out.println(request.getHeader("password"));
//		
//		String username = request.getHeader("username");
//		String password = request.getHeader("password");
		System.out.println(request.getParameter("username"));
		System.out.println(request.getParameter("password"));
		System.out.println("00000000000000000");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
//		System.out.println(username);
//		System.out.println(password);
		UsernamePasswordAuthenticationToken authenticationToken =
				new UsernamePasswordAuthenticationToken(username, password);
		System.out.println("1111111111111111111111");
		System.out.println(authenticationToken);
		Authentication authentication = authenticationManager.authenticate(authenticationToken);
		System.out.println("2222222222222222222222");
		UserDetailsImpl userDetails = (UserDetailsImpl)authentication.getPrincipal();
		System.out.println("·Î±×ÀÎ¿Ï·áµÊ"+userDetails.getMember().getUsername());
		return authentication;
	}
}
