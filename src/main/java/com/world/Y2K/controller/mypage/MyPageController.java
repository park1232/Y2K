package com.world.Y2K.controller.mypage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyPageController {

	
	@GetMapping("/mypage.my")
	public String moveMypageView() {
		return "mypage/mypage";
	}
	
//	@GetMapping("/onload.my")
//	public Mypage getOnloadEntity(Long userNo){
//		return onloadEntityService.getOnloadEntity(userNo);
//	}
	
}
