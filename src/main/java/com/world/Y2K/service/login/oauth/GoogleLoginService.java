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
import com.google.gson.JsonParser;

@Service
public class GoogleLoginService extends SocialLoginServiceTemplate{

	@Override
	protected String getAccessToken(String code) {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type","application/x-www-form-urlencoded");
		
		MultiValueMap<String, String> accessTokenBodyInfo = new LinkedMultiValueMap<String, String>();
		accessTokenBodyInfo.add("code", code);
		accessTokenBodyInfo.add("client_id", "250224335070-67ol1mh21l40c1cq7pb8p471o7v9sg9s.apps.googleusercontent.com");
		accessTokenBodyInfo.add("client_secret", "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");
		accessTokenBodyInfo.add("redirect_uri", "http://localhost:8080/google.lo");
		accessTokenBodyInfo.add("grant_type", "authorization_code");
		
		ResponseEntity<String> response = new RestTemplate().exchange(
				"https://oauth2.googleapis.com/token",
				HttpMethod.POST, 
				new HttpEntity<MultiValueMap<String, String>>(accessTokenBodyInfo, headers),
				String.class
				);
		System.out.println(response.getBody());
		return asString(response.getBody(),"access_token");
	}

	@Override
	protected HashMap<String, String> getUserInfoFromKakaoResource(String accessToken) {
		System.out.println("½ÇÇàµÊ");
		System.out.println("getUserInfoFromGoogle : "+accessToken);
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization","Bearer "+accessToken);
		System.out.println("headers :" +headers);
		ResponseEntity<String> response = new RestTemplate().exchange(
				"https://www.googleapis.com/drive/v2/files/fileId",
				HttpMethod.GET, 
				new HttpEntity<String>(headers),
				String.class
				);
		System.out.println(response.getBody());
	//		System.out.println("google userInfo : "+response.getBody());
	//		System.out.println(new JsonParser().parse(response.getBody()).getAsJsonObject().get("id").getAsJsonObject().get("permissionId").getAsJsonObject().get("permissionId").getAsJsonObject().get("permissionId").getAsString());
		return setUserInfo(new JsonParser().parse(response.getBody()));
	}

	@Override
	protected HashMap<String, String> setUserInfo(JsonElement userInfoJson) {
		System.out.println(userInfoJson);
		return null;
	}

	@Override
	protected ModelAndView setLogin(HashMap<String, String> userInfo) {
		// TODO Auto-generated method stub
		return null;
	}

}
