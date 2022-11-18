package com.world.Y2K.controller.visit;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class VisitController {
	
	@GetMapping("/visitBoard.vi")
	public String test() {
		return "visitBoard";
	}
}
