package com.world.Y2K.controller.friend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FriendController {
	
	@GetMapping("/friendAdd.fr")
	public String test() {
		return "friendAdd";
	}
	
	@GetMapping("/friendList.fr")
	public String test2() {
		return "friendList";
	}
	
}
