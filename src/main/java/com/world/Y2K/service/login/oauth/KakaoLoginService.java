package com.world.Y2K.service.login.oauth;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.world.Y2K.dao.login.LoginDAO;
import com.world.Y2K.model.dto.Member;
import com.world.Y2K.service.login.oauth.token.KakaoOAuthToken;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KakaoLoginService{
	
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private LoginDAO loginDAO;
	
	
	public ModelAndView kakaoLogin(String code, HttpServletRequest request) {
	
		System.out.println("Kakao실행됨");
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-type","application/x-www-form-urlencoded;charset=utf-8");
		
		MultiValueMap<String, String> accessTokenBodyInfo = new LinkedMultiValueMap<String, String>();
		accessTokenBodyInfo.add("grant_type", "authorization_code");
		accessTokenBodyInfo.add("client_id", "505e36c739260bba34b117ded3d8b963");
		accessTokenBodyInfo.add("redirect_uri", "http://localhost:8080/kakao.lo");
		accessTokenBodyInfo.add("code", code);
		
		
		
		HttpEntity<MultiValueMap<String,String>> kakaoTokenRequest = 
				new HttpEntity<MultiValueMap<String, String>>(accessTokenBodyInfo, headers);
		
		ResponseEntity<String> response3 = new RestTemplate().exchange(
				"https://kauth.kakao.com/oauth/token",
				HttpMethod.POST, 
				kakaoTokenRequest,
				String.class
				);
		
		System.out.println(response3.getBody());
		
		ObjectMapper objectMapper = new ObjectMapper();
		KakaoOAuthToken kakaoOAuthToken = null;
		try {
			kakaoOAuthToken = objectMapper.readValue(response3.getBody(),KakaoOAuthToken.class);
		} catch (JsonMappingException e) {
			log.error(e.getMessage());
		} catch (JsonProcessingException e) {
			log.error(e.getMessage());
		}
		
		HttpHeaders headers2 = new HttpHeaders();
		headers2.add("Authorization", "Bearer "+kakaoOAuthToken.getAccess_token());
		headers2.add("Content-type","application/x-www-form-urlencoded;charset=utf-8");
		
		HttpEntity<String> kakaoUserInfoRequest = 
				new HttpEntity<String>(headers2);
		
		ResponseEntity<String> response2 = new RestTemplate().exchange(
				"https://kapi.kakao.com/v2/user/me",
				HttpMethod.POST, 
				kakaoUserInfoRequest,
				String.class
				);
		
		JsonParser parser = new JsonParser();
		JsonElement element = parser.parse(response2.getBody());
		
		String provider = "KAKAO";
		String providerId = element.getAsJsonObject().get("id").getAsString();
		String username = provider+providerId;
		String password = UUID.randomUUID().toString();
		
		 
		System.out.println("카카오로그인 실행됨");
		

		Member member = loginDAO.findUser(username);
		
		if(member==null) {
		
			member = Member.builder()
						.username(username)
						.password(bCryptPasswordEncoder.encode(password))
						.nickName("null")
						.status("Y")
						.orange(0L)
						.role("ROLE_USER")
						.provider(provider)
						.providerId(providerId)
						.build();
			
			System.out.println(member);
			loginDAO.registerMember(member);

		}
	
	
		System.out.println(member);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("username", member.getUsername());
		mv.addObject("password", member.getPassword());
		mv.setViewName("/login/social");
		return mv;
//		Map<String, Object> map = new HashMap<String, Object>();
//		map.put("username", username);
//		map.put("password", password);
		
//		
		
//		URL url = null;
//		try {
//			url = new URL("http://localhost:8080/login");
//		} catch (MalformedURLException e) {
//			
//			e.printStackTrace();
//		}
//		HttpURLConnection conn = null;
//		try {
//			conn = (HttpURLConnection)url.openConnection();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		try {
//			conn.setRequestMethod("POST");
//		} catch (ProtocolException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		conn.setRequestProperty("username", username);
//		conn.setRequestProperty("password", password);
//		conn.setDoOutput(true);
		
		
		
		
//		HttpHeaders headerss = new HttpHeaders();
//		headerss.add("username",username);
//		headerss.add("password", password);
//		
////		MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
////		params.add("username", username);
////		params.add("password", password);
//		
//		RestTemplate rt = new RestTemplate();
//		HttpEntity<MultiValueMap<String,String>> entity = new HttpEntity<>(headerss);
//	
//		HttpHeaders headersss = new HttpHeaders();
//		
//		headersss.add("username",username);
//		headersss.add("password", password);
//		headers.setLocation(URI.create("http://localhost:8080/login"));
//		return new ResponseEntity<>(headersss, HttpStatus.MOVED_PERMANENTLY);
		
		
//		return rt.exchange(
//				"http://localhost:8080/login",
//				HttpMethod.POST,
//				entity,
//				String.class
//				);
	}
	
}
		
		
//		UsernamePasswordAuthenticationToken authenticationToken =
//		new UsernamePasswordAuthenticationToken(username, password);
//
//Authentication authentication = authenticationManager().authenticate(authenticationToken);
//
//return authentication;
	
	



