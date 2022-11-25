package com.world.Y2K.controller.diary;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.world.Y2K.model.vo.Diary;
import com.world.Y2K.service.diary.DiaryService;
import com.world.Y2K.service.login.auth.UserDetailsImpl;

@SessionAttributes("loginUser")
@Controller
public class DiaryController {
	
	@Autowired
	private DiaryService dService;
	
	@GetMapping("/diary.di")
	public String diary() {
		return "diary/diary";
	}
	
	@RequestMapping("/diary3.di")
	public String diaryWrite(@RequestParam("datepicker") String datepicker, @RequestParam("mapValue") String mapValue, Model model) {
		model.addAttribute("datepicker", datepicker);
		model.addAttribute("mapValue", mapValue);
		return "diary/diary3";
	}
	
	@RequestMapping("/map.di")
	public String map() {
		return "diary/map";
	}
	
	@RequestMapping("/insertDiary.di")
	public String insertDiary(@ModelAttribute Diary d, Authentication authentication, HttpServletRequest request, Model model) {
		UserDetailsImpl userDetails = (UserDetailsImpl)authentication.getPrincipal();
		System.out.println("user:" + userDetails.getMember().getUsername());
//		String diaryWriter = ((Member)userDetails.getMember()).getUsername();
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("diary/diary");
//		mv.addObject("loginUser",userDetails.getMember());
		System.out.println("제발..");
		HttpSession session =  request.getSession();
		session.setAttribute("loginUser", userDetails.getMember());
		model.getAttribute("loginUser");
		return "diary/diary";
	}
	
	@GetMapping("/diary2.di")
	public String test2() {
		return "diary/diary2";
	}
	
}
