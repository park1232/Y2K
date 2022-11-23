package com.world.Y2K.service.login.oauth;

import java.util.HashMap;

import org.springframework.web.servlet.ModelAndView;

import com.google.gson.JsonElement;

public class GoogleLoginService extends SocialLoginServiceTemplate{

	@Override
	protected String getAccessToken(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected HashMap<String, String> getUserInfoFromKakaoResource(String accessToken) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected HashMap<String, String> setUserInfo(JsonElement userInfoJson) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected ModelAndView setLogin(HashMap<String, String> userInfo) {
		// TODO Auto-generated method stub
		return null;
	}

}
