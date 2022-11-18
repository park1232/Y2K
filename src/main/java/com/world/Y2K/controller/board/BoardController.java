package com.world.Y2K.controller.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BoardController {

	@GetMapping("/boardList.bo")
	public String test() {
		System.out.println(1);
		System.out.println(2);
		return "boardList";
	}
	
	@GetMapping("boardView.bo")
	public String test2() {
		return "boardView";
	}
	
	@GetMapping("boardWrite.bo")
	public String test3() {
		return "boardWrite";
	}
}
