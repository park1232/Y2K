package com.world.Y2K.controller.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.world.Y2K.model.service.login.RegisterService;
import com.world.Y2K.model.vo.Member;

@Controller
public class LoginController {
	
	@Autowired
	private RegisterService registerService;
	
	
	@GetMapping("/loginpage.lo")
	public String moveLoginView() {
		System.out.println("±κ Β₯Αυ³­΄Ω.");
		System.out.println(1);
		return "loginPage";
	}
	
	@PostMapping("/join.lo")
	public String joinMember(Member member) {
		return registerService.joinMember(member);
//		return "redirect:/loginpage.lo";
	}
	
}
