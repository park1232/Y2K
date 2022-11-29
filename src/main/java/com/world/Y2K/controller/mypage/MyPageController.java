package com.world.Y2K.controller.mypage;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.world.Y2K.service.login.auth.UserDetailsImpl;
import com.world.Y2K.service.mypage.BackgroundChangeService;
import com.world.Y2K.service.mypage.ContentChangeService;
import com.world.Y2K.service.mypage.MoveMypageViewSerivce;
import com.world.Y2K.service.mypage.OnloadEntityService;
import com.world.Y2K.service.mypage.TitleChangeService;

@Controller
public class MyPageController {

	@Autowired
	private OnloadEntityService onloadEntityService;
	
	@Autowired
	private MoveMypageViewSerivce moveMypageViewService;
	
	@Autowired
	private BackgroundChangeService backgroundChangeService; 
	
	@Autowired
	private TitleChangeService titleChangeService;
	
	@Autowired
	private ContentChangeService contentChangeService;
	
	
	@GetMapping("/mypage.my")
	public ModelAndView moveMypageView(Authentication authentication) {
		return moveMypageViewService.moveMypageView(authentication);
//		return "mypage/mypage";
	}
	
	@ResponseBody
	@GetMapping("/onload.my")
	public HashMap<String, Object> getOnloadEntity(Long userNo){
		System.out.println("userNo : " + userNo);
	
		return onloadEntityService.getOnloadEntity(userNo);
	}
	
	@GetMapping("/background-change.my")
	public String backgroundChange(String skinName, Authentication authentication) {
		return backgroundChangeService.backgroundChange(skinName, getUserDetails(authentication) );
	}
	
	@GetMapping("/title-change.my")
	public String titleChange(String inputTitle,  Authentication authentication) {
		return titleChangeService.titleChange(inputTitle, getUserDetails(authentication));
	}
	
	@GetMapping("/content-change.my")
	public String contentChange(String inputContent,  Authentication authentication) {
		return contentChangeService.contentChange(inputContent, getUserDetails(authentication));
	}
	
	
	
	
	private UserDetailsImpl getUserDetails(Authentication authentication){
		return (UserDetailsImpl)authentication.getPrincipal();
	}
}
