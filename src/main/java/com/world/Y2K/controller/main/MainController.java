package com.world.Y2K.controller.main;


import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.world.Y2K.model.dto.MainRe;
import com.world.Y2K.model.dto.Member;
import com.world.Y2K.model.vo.Board;
import com.world.Y2K.model.vo.Photo;
import com.world.Y2K.model.vo.Reply;
import com.world.Y2K.model.vo.Visit;
import com.world.Y2K.service.login.auth.UserDetailsImpl;
import com.world.Y2K.service.main.MainService;
import com.world.Y2K.service.mypage.OnloadEntityService;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RestController
public class MainController {
	
	@Autowired
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
		System.out.println("123");
		
		//System.out.println("controller값"+userNo);
		
		System.out.println(onloadEntityService);
		
			Member member = userDetails.getMember();
		//	Mypage mypage = null;
			//mypage = onloadEntityService.getOnloadEntity(member.getUserNo());
		//	System.out.println(mypage);
		//	if(userNo != member.getUserNo()) {
			//	mypage = onloadEntityService.getOnloadEntity(userNo);
			//	mv.addObject("visit_rayout", mypage);
			//	mv.addObject("my_rayout", "null");
			//}  else {
//				mypage = onloadEntityService.getOnloadEntity(member.getUserNo());
//				mv.addObject("my_rayout", mypage);
//				mv.addObject("visit_rayout", "null");
//			}
//			
			
			
			
			ArrayList<Reply> list = mService.replyList(userNo);
	
			int bList = mService.boardList(userNo);
			
			int pList = mService.photoList(userNo);
			
			int vList = mService.visitList(userNo);
			
			int dList = mService.dList(userNo);
			mv.addObject("bList", bList);
			mv.addObject("list", list);
			System.out.println("리플리스트"+ list);
			mv.addObject("member", member);
			mv.addObject("userNo", userNo);
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
	
	
	
	
	@ResponseBody	
	@RequestMapping("/deleteReply.ma")
	public void deleteReply(@RequestParam("replyNo") Long replyNo,
			HttpServletResponse response, Model model,
			Authentication authentication){
		
		response.setContentType("application/json; charset=UTF-8");
		UserDetailsImpl userDetails = (UserDetailsImpl)authentication.getPrincipal();
		
		System.out.println(replyNo);
		
		mService.deleteReply(userDetails.getMember().getUserNo(), replyNo);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}