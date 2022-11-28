package com.world.Y2K.controller.main;


import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.world.Y2K.model.dto.MainRe;
import com.world.Y2K.model.dto.Member;
import com.world.Y2K.model.vo.Reply;
import com.world.Y2K.service.login.auth.UserDetailsImpl;
import com.world.Y2K.service.main.MainService;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RestController
public class MainController {
	
	@Autowired
	private MainService mService;
	
	
	
	@RequestMapping("/mainPage.ma")
	public ModelAndView mainPage(
			ModelAndView mv, 
			@RequestParam("userNo") Long userNo,
			Authentication authentication
			) {
		UserDetailsImpl userDetails = (UserDetailsImpl)authentication.getPrincipal();
		System.out.println("123");
		
		//System.out.println("controller값"+userNo);
		
			Member member = userDetails.getMember();

			
		
			ArrayList<Reply> list = mService.replyList(userNo);
			mv.addObject("list", list);
			System.out.println("리플리스트"+ list);
			mv.addObject("member", member);
			mv.setViewName("main/mainPage");
			
			return mv;

		

	
			
	}
		
	@ResponseBody	
	@RequestMapping("/insertReply.ma")
	public Map<String,Object> insertReply(
			MainRe mainRe, HttpServletResponse response,
			Authentication authentication
			) {
		response.setContentType("application/json; charset=UTF-8");
		
		UserDetailsImpl userDetails = (UserDetailsImpl)authentication.getPrincipal();
		
		System.out.println("Controller mainRe : "  + mainRe);
		
		
		return mService.insertReply(mainRe.getContent(), mainRe.getNickName(), userDetails.getMember().getUserNo());
		
		
//		ArrayList<Reply> list = bService.selectReply(r.getRboardNo());
//		
//		response.setContentType("application/json; charset=UTF-8");
//		GsonBuilder gb = new GsonBuilder();
//		GsonBuilder gb2 = gb.setDateFormat("yyyy-MM-dd");
//		Gson gson = gb2.create();
//		
//		try {
//			gson.toJson(list, response.getWriter());
//		} catch (JsonIOException | IOException e) {
//			e.printStackTrace();
//		}
//		
//		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}