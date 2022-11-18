package com.world.Y2K.controller.diary;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
		System.out.println("why??");
		System.out.println("why!!!!!!!!!!!!!!!!!");
		System.out.println("why..........");
		System.out.println("fuck!!");
		System.out.println("드디어 되나?");
		return "diary2";
	}
	
	@GetMapping("/diary3.di")
	public String test3() {
		return "diary3";
	}
}
