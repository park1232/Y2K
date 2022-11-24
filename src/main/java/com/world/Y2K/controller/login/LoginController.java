package com.world.Y2K.controller.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.world.Y2K.exception.MemberException;
import com.world.Y2K.model.vo.User;
import com.world.Y2K.service.login.CheckIdService;
import com.world.Y2K.service.login.EditNicknameService;
import com.world.Y2K.service.login.RegisterService;
import com.world.Y2K.service.login.auth.UserDetailsImpl;
import com.world.Y2K.service.login.oauth.KakaoLoginService;
import com.world.Y2K.service.login.oauth.NaverLoginService;

@Controller
public class LoginController {
	
	@Autowired
	private RegisterService registerService;
	
	@Autowired
	private KakaoLoginService kakaoLoginService;
	
//	@Autowired
//	private GoogleLoginService googleLoginService;
	
	@Autowired
	private NaverLoginService naverLoginService;
	
//	@Autowired
//	private FacebookLoginService facebookLoginService;
	
	@Autowired 
	private EditNicknameService editNicknameService;
	
	@Autowired
	private CheckIdService checkIdService;

	
	
	@GetMapping("/loginpage.lo")
	public String moveLoginView() {
		return "login/loginPage";
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
		return "login/loginSuccess";
	}
	
	@GetMapping("/kakao.lo")
	public ModelAndView kakaoLogin(String code)  {
		return  kakaoLoginService.socialLogin(code);
	}
	
//	@GetMapping("/google.lo")
//	public void googleLogin(String code)  {
//		googleLoginService.socialLogin(code);
//	}
	
	@GetMapping("/naver.lo")
	public ModelAndView naverLogin(String code) {
		return naverLoginService.socialLogin(code);
	}
	
	
//	@GetMapping("/facebook.lo")
//	public void facebookLogin(String code) throws IOException {	
//		facebookLoginService.socialLogin(code);
//	}
	
	
	@PostMapping("/editpage.lo")
	public String editNicknameView() {
		return "/login/EditNickName";
	}
	
	@PostMapping("/edit-nickname.lo")
	public ModelAndView editNickname(Authentication authentication, String nickname) throws MemberException {
		UserDetailsImpl userDetails = (UserDetailsImpl)authentication.getPrincipal();
		return editNicknameService.editNickname(userDetails.getMember(), nickname);
	}
	
	@ResponseBody
	@PostMapping("/check-id.lo")
	public int checkId(@RequestBody String inputId) {
		return checkIdService.checkId(inputId);
	}

	

	
	
}
