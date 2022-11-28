package com.world.Y2K.controller.main;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.world.Y2K.model.dto.Member;
import com.world.Y2K.model.vo.MainReply;
import com.world.Y2K.service.login.auth.UserDetailsImpl;
import com.world.Y2K.service.main.MainService;
import com.world.Y2K.service.mypage.OnloadEntityService;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Controller
public class MainController {
	
	private MainService mService;
	
	@Autowired
	private OnloadEntityService onloadEntityService;
	
	
	@RequestMapping("/mainPage.ma")
	public ModelAndView mainPage(
			ModelAndView mv, 
			@RequestParam("userNo") Long userNo,
			Authentication authentication
			) {
		UserDetailsImpl userDetails = (UserDetailsImpl)authentication.getPrincipal();
		
		
		System.out.println("controller값"+userNo);
		
		Member member = userDetails.getMember();
		
		//ArrayList<Reply> list = mService.replyList(boardNo);
		
		//System.out.println("리플리스트"+ list);
		
//		if(list !=null) {
//			mv.addObject("list", list);
//			mv.addObject("member", member);
//			mv.addObject("boardNo", boardNo);
//			mv.setViewName("main/mainPage");
//			
//			return mv;
//			
//		}else {
			mv = onloadEntityService.getOnloadEntity(userNo, authentication);
			mv.addObject("member", member);
		//	mv.addObject("boardNo", boardNo);
			mv.setViewName("main/mainPage");
			
			return mv;
			
		}
		
		
	@RequestMapping("/insertReply.ma")
	public void insertReply(MainReply mainReply, 
			BindingResult bindingResult,
			Authentication authentication, 
			HttpServletResponse response) {
		
		UserDetailsImpl userDetails = (UserDetailsImpl)authentication.getPrincipal();
		System.out.println(mainReply);
		
		//mService.insertReply(r);
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

