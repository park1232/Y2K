package com.world.Y2K.service.login.oauth;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.JsonElement;
import com.world.Y2K.dao.login.LoginDAO;

public abstract class SocialLoginServiceTemplate {
	
	@Autowired
	protected BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	protected LoginDAO loginDAO;
	
	public ModelAndView kakaoLogin(String code) {			
		String accessToken = getAccessToken(code);
		HashMap<String, String>userInfo = getUserInfoFromKakaoResource(accessToken);
		
		return setLogin(userInfo);
	}
	
	protected abstract String getAccessToken(String code);
	
	protected abstract HashMap<String, String> getUserInfoFromKakaoResource(String accessToken);
	
	protected abstract HashMap<String, String> setUserInfo(JsonElement userInfoJson); 
	
	protected abstract ModelAndView setLogin(HashMap<String, String> userInfo);
}
