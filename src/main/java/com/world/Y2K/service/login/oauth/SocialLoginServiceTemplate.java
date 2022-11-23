package com.world.Y2K.service.login.oauth;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.world.Y2K.dao.login.LoginDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class SocialLoginServiceTemplate {
	
	@Autowired
	protected BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	protected LoginDAO loginDAO;
	
	public ModelAndView socialLogin(String code) {			
		String accessToken = getAccessToken(code);
		HashMap<String, String>userInfo = getUserInfoFromKakaoResource(accessToken);
		
		return setLogin(userInfo);
	}
	
	protected abstract String getAccessToken(String code);
	
	protected abstract HashMap<String, String> getUserInfoFromKakaoResource(String accessToken);
	
	protected abstract HashMap<String, String> setUserInfo(JsonElement userInfoJson); 
	
	protected abstract ModelAndView setLogin(HashMap<String, String> userInfo);
	
	
	protected String asString(String data,String dataname) {
        try{
            JsonParser parser = new JsonParser();
            JsonElement element = parser.parse(data);
            return element.getAsJsonObject().get(dataname).getAsString();
        } catch(Exception e) {
            log.error("not JsonObject");
        }
        return "not JsonObject";
    }
}
