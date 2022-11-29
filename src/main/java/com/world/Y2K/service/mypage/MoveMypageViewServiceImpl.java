package com.world.Y2K.service.mypage;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.world.Y2K.dao.skin.SkinDAO;
import com.world.Y2K.model.dto.Skin;
import com.world.Y2K.service.login.auth.UserDetailsImpl;

@Service
public class MoveMypageViewServiceImpl implements MoveMypageViewSerivce{

	@Autowired
	private SkinDAO skinDAO;
	
	@Override
	public ModelAndView moveMypageView(Authentication authentication) {
		UserDetailsImpl userDetails = (UserDetailsImpl)authentication.getPrincipal();
		
		ArrayList<Skin> skinList = skinDAO.getList(userDetails.getMember().getUserNo());
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("skinList", skinList);
		mv.setViewName("mypage/mypage");
		
		return mv;
	}

}
