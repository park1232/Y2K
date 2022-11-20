package com.world.Y2K.controller.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.world.Y2K.exception.MemberException;
import com.world.Y2K.model.vo.User;
import com.world.Y2K.service.login.RegisterService;

@Controller
public class LoginController {
	
	@Autowired
	private RegisterService registerService;
	
	
	@GetMapping("/loginpage.lo")
	public String moveLoginView() {
		return "loginPage";
	}
	
	@PostMapping("/register.lo")
	public String joinMember(@ModelAttribute User user) throws MemberException {
		
		if(registerService.registerMember(user)==0) {
			throw new MemberException("회원가입을 실패하였습니다.");
		}
		
		return "redirect:";
	}
	
}
