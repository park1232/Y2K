package com.world.Y2K.service.mypage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.world.Y2K.dao.mypage.MypageDAO;
import com.world.Y2K.service.login.auth.UserDetailsImpl;

@Service
public class OnloadEntityServiceImpl implements OnloadEntityService{

	@Autowired
	private MypageDAO mypageDAO;
	
	@Override
	public ModelAndView getOnloadEntity(Long userNo, Authentication authentication) {
		
		ModelAndView mv = new ModelAndView();
		
		UserDetailsImpl userDetails = (UserDetailsImpl)authentication.getPrincipal();
		Long checkUserNo = userDetails.getMember().getUserNo();
		
		if(userNo != checkUserNo) {
			mv.addObject("visit_rayout", mypageDAO.getOnloadEntity(userNo));
			mv.addObject("my_rayout", "null");
		} else {
			mv.addObject("visit_rayout", "null");
			mv.addObject("my_rayout", mypageDAO.getOnloadEntity(checkUserNo));
		}
		
		return mv;
	}



	
	
}
