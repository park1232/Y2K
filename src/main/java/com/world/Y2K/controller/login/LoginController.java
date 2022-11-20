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
	
//	@Autowired
//	private UserDetailsServiceImpl userDetailsService;
	
	@Autowired
	private RegisterService registerService;
	
	@GetMapping("/loginpage.lo")
	public String moveLoginView() {
<<<<<<< HEAD
=======
		System.out.println("ï¿½ï¿½ Â¥ï¿½ï¿½ï¿½ï¿½ï¿½ï¿½.");
		System.out.println(1);
>>>>>>> 34af81e1153239d0cc90e725123dd6f745288eec
		return "loginPage";
	}

//	@PostMapping("login.lo")
//	public UserDetails login(String username) {
//		System.out.println("½ÇÇàµÇ³ª¿ä?");
//		return userDetailsService.loadUserByUsername(username);
//	}
	
	@PostMapping("/register.lo")
	public String joinMember(@ModelAttribute User user) throws MemberException {
		
		if(registerService.registerMember(user)==0) {
			throw new MemberException("È¸¿ø°¡ÀÔÀ» ½ÇÆÐÇÏ¿´½À´Ï´Ù.");
		}
		
		return "redirect:loginpage.lo";
	}
	
}
