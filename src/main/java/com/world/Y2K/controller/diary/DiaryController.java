package com.world.Y2K.controller.diary;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DiaryController {

	@GetMapping("/diary.di")
	public String test1() {
		System.out.println("test");
		System.out.println("test2");
		return "diary";
	}
	
	@GetMapping("/diary2.di")
	public String test2() {
		return "diary2";
	}
	
	@RequestMapping("/diary3.di")
	public String test3() {
		return "diary3";
	}
}
