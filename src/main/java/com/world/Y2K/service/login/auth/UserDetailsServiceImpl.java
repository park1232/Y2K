package com.world.Y2K.service.login.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


import com.world.Y2K.dao.login.LoginDAO;
import com.world.Y2K.model.dto.Member;

public class UserDetailsServiceImpl  implements UserDetailsService{

	@Autowired
	private LoginDAO loginDAO;
	

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Member member = loginDAO.findUser(username);
		if(member == null) {
			return (UserDetails) new UsernameNotFoundException(username);
		}
		return new UserDetailsImpl(member);


	}

}
