package com.world.Y2K.controller.friend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FriendController {
	
	@GetMapping("/friendAdd.fr")
	public String test() {
		return "friend/friendAdd";
	}
	
	@GetMapping("/friendList.fr")
	public String test2() {
		return "friend/friendList";
	}
	
}
