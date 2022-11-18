package com.world.Y2K.controller.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	
	@GetMapping("/mainPage.ma")
	public String test() {
		return "mainPage";
	}
}
