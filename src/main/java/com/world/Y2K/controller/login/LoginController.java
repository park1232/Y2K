package com.world.Y2K.controller.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.world.Y2K.exception.MemberException;
import com.world.Y2K.model.vo.User;
import com.world.Y2K.service.login.RegisterService;
import com.world.Y2K.service.login.auth.UserDetailsImpl;
import com.world.Y2K.service.login.oauth.KakaoLoginService;

@Controller
public class LoginController {
	
	@Autowired
	private RegisterService registerService;
	
	@Autowired
	private KakaoLoginService kakaoLoginService;

	
	@GetMapping("/loginpage.lo")
	public String moveLoginView() {
		return "loginPage";
	}
	
	@PostMapping("/register.lo")
	public String joinMember(@ModelAttribute User user) throws MemberException {
		
		if(registerService.registerMember(user)==0) {
			throw new MemberException("회원가입을 실패하였습니다.");
		}
		
		return "redirect:loginpage.lo";
	}
	
	@GetMapping("/info")
	public void info(Authentication authentication) {
		UserDetailsImpl userDetails = (UserDetailsImpl)authentication.getPrincipal();
		System.out.println("user : " + userDetails.getMember());
	}
	
	@PostMapping("/login-success.lo")
	public String loginSuccessHandler() {
		return "loginSuccess";
	}
	
	@GetMapping("/kakao.lo")
	public void kakaoLogin(String code, HttpServletRequest request) {
		kakaoLoginService.kakaoLogin(code, request);
		
	}

	
	
}
