package com.world.Y2K.service.login;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.world.Y2K.dao.login.LoginDAO;
import com.world.Y2K.model.dto.Member;
import com.world.Y2K.service.login.auth.UserDetailsImpl;

@Service
public class SessionService {

	@Autowired
	private LoginDAO loginDAO;
	
	public ModelAndView editNicknameView(HttpServletRequest request, Authentication authentication) {
		ModelAndView mv = new ModelAndView();
		UserDetailsImpl userDetails = (UserDetailsImpl)authentication.getPrincipal();
		if(userDetails.getMember().getNickName().equals("null")) {
			Member member = loginDAO.findUser(userDetails.getMember().getUsername());
			mv.addObject("loginUser", member);
		}
		mv.setViewName("login/loginSuccess");
		return mv;
	}
	
	
}
