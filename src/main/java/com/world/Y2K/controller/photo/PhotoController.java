package com.world.Y2K.controller.photo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PhotoController {
	
	@GetMapping("/modal.ph")
	public String test() {
		return "modal";
	}
	
	@GetMapping("/photo.ph")
	public String test2() {
		return "photo";
	}
	
	@GetMapping("/show.ph")
	public String test3() {
		return "show";
	}
	
	@GetMapping("/upload.ph")
	public String test4() {
		return "upload";
	}
}

