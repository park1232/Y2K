package com.world.Y2K.service.login.oauth;

import java.util.HashMap;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.JsonElement;

@Service
public class FacebookLoginService extends SocialLoginServiceTemplate{

	@Override
	protected String getAccessToken(String code) {
		System.out.println("facebook code : " +code);
		HttpHeaders headers = new HttpHeaders();
			
		MultiValueMap<String, String> accessTokenBodyInfo = new LinkedMultiValueMap<String, String>();
		accessTokenBodyInfo.add("client_id", "641158651025103");
		accessTokenBodyInfo.add("redirect_uri", "http://localhost:8080/facebook.lo");
		accessTokenBodyInfo.add("client_secret", "f8238755e7af4ebe289a4d8a559b8df6");
		accessTokenBodyInfo.add("code", code);
		
		ResponseEntity<String> response = new RestTemplate().exchange(
				"https://graph.facebook.com/v15.0/oauth/access_token",
				HttpMethod.GET, 
				new HttpEntity<MultiValueMap<String, String>>(accessTokenBodyInfo, headers),
				String.class
				);
		System.out.println(response.getBody());
		
		return  asString(response.getBody(),"access_token");
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
