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

import com.world.Y2K.exception.DiaryException;
import com.world.Y2K.model.dto.Member;
import com.world.Y2K.model.vo.Diary;
import com.world.Y2K.service.diary.DiaryService;
import com.world.Y2K.service.login.auth.UserDetailsImpl;

@SessionAttributes("loginUser")
@Controller
public class DiaryController {
	
	@Autowired
	private DiaryService dService;
	
	@GetMapping("/diary.di")
	public String diary(HttpServletRequest request, Authentication authentication) {
		UserDetailsImpl userDetails = (UserDetailsImpl)authentication.getPrincipal();
		Member member = userDetails.getMember();
		HttpSession session = request.getSession();
		session.setAttribute("loginUser", member);
		
		
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
	public String insertDiary(@ModelAttribute Diary d, HttpServletRequest request, Model model) {
		System.out.println(d);
		
		
		HttpSession session = request.getSession();
		Member member = (Member)session.getAttribute("loginUser");
		System.out.println(member);
		Long diaryWriter = member.getUserNo();
		d.setDiaryWriter(diaryWriter);
		int result = dService.insertDiary(d);
		System.out.println(d);
		if(result > 0) {
			return "redirect:diary.di";
		}else {
			throw new DiaryException("다이어리글 작성 실패");
		}
	}
	
	@GetMapping("/diary2.di")
	public String test2() {
		return "diary/diary2";
	}
	
}
