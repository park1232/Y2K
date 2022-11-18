package com.world.Y2K.controller.chat;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChatController {
	
	@GetMapping("chat.ch")
	public String test() {
		return "chat";
	}
}
