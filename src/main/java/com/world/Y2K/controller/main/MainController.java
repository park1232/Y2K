package com.world.Y2K.controller.main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.world.Y2K.model.dto.Member;
import com.world.Y2K.model.dto.ReplyDto;
import com.world.Y2K.model.vo.MainReply;
import com.world.Y2K.model.vo.Reply;
import com.world.Y2K.service.login.auth.UserDetailsImpl;
import com.world.Y2K.service.main.MainService;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Controller
public class MainController {
	
	private MainService mService;
	
	
	
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

