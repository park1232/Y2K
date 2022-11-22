package com.world.Y2K.controller.diary;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.world.Y2K.service.diary.DiaryService;

@Controller
public class DiaryController {
	
	@Autowired
	private DiaryService dService;
	
	@GetMapping("/diary.di")
	public String test1() {
		return "diary/diary";
	}
	
	@RequestMapping("/diary3.di")
	public String diaryWrite(@RequestParam("datepicker") String datepicker, Model model) {
		model.addAttribute("datepicker", datepicker);
		return "diary/diary3";
	}
	
	@GetMapping("/diary2.di")
	public String test2() {
		return "diary/diary2";
	}
}
