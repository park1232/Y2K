//package com.world.Y2K.service.login.filter;
//
//import java.io.IOException;
//import java.util.UUID;
//
//import javax.servlet.Filter;
//import javax.servlet.FilterChain;
//import javax.servlet.FilterConfig;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServlet;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpEntity;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpMethod;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.util.LinkedMultiValueMap;
//import org.springframework.util.MultiValueMap;
//import org.springframework.web.client.RestTemplate;
//
//import com.fasterxml.jackson.core.JsonProcessingException;
//import com.fasterxml.jackson.databind.JsonMappingException;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.google.gson.JsonElement;
//import com.google.gson.JsonParser;
//import com.world.Y2K.service.login.oauth.token.KakaoOAuthToken;
//
//import lombok.extern.slf4j.Slf4j;
//
//@Slf4j
//@WebFilter(urlPatterns = "/kakao.lo")
//public class OAuthLoginFilter implements Filter{
//
//	@Autowired
//	private BCryptPasswordEncoder bCryptPasswordEncoder;
//	
//	@Override
//	public void init(FilterConfig filterConfig) throws ServletException {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
//			throws IOException, ServletException {
//		String code = request.getParameter("code");
//		System.out.println("Kakao½ÇÇàµÊ");
//		
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("Content-type","application/x-www-form-urlencoded;charset=utf-8");
//		
//		MultiValueMap<String, String> accessTokenBodyInfo = new LinkedMultiValueMap<String, String>();
//		accessTokenBodyInfo.add("grant_type", "authorization_code");
//		accessTokenBodyInfo.add("client_id", "505e36c739260bba34b117ded3d8b963");
//		accessTokenBodyInfo.add("redirect_uri", "http://localhost:8080/kakao.lo");
//		accessTokenBodyInfo.add("code", code);
//		
//		
//		
//		HttpEntity<MultiValueMap<String,String>> kakaoTokenRequest = 
//				new HttpEntity<MultiValueMap<String, String>>(accessTokenBodyInfo, headers);
//		
//		ResponseEntity<String> response3 = new RestTemplate().exchange(
//				"https://kauth.kakao.com/oauth/token",
//				HttpMethod.POST, 
//				kakaoTokenRequest,
//				String.class
//				);
//		
//		System.out.println(response3.getBody());
//		
//		ObjectMapper objectMapper = new ObjectMapper();
//		KakaoOAuthToken kakaoOAuthToken = null;
//		try {
//			kakaoOAuthToken = objectMapper.readValue(response3.getBody(),KakaoOAuthToken.class);
//		} catch (JsonMappingException e) {
//			log.error(e.getMessage());
//		} catch (JsonProcessingException e) {
//			log.error(e.getMessage());
//		}
//		
//		HttpHeaders headers2 = new HttpHeaders();
//		headers2.add("Authorization", "Bearer "+kakaoOAuthToken.getAccess_token());
//		headers2.add("Content-type","application/x-www-form-urlencoded;charset=utf-8");
//		
//		HttpEntity<String> kakaoUserInfoRequest = 
//				new HttpEntity<String>(headers2);
//		
//		ResponseEntity<String> response2 = new RestTemplate().exchange(
//				"https://kapi.kakao.com/v2/user/me",
//				HttpMethod.POST, 
//				kakaoUserInfoRequest,
//				String.class
//				);
//		
//		JsonParser parser = new JsonParser();
//		JsonElement element = parser.parse(response2.getBody());
//		
//		String provider = "KAKAO";
//		String providerId = element.getAsJsonObject().get("id").getAsString();
//		String username = provider+"_"+providerId;
//		String password = UUID.randomUUID().toString();
//	
//		System.out.println("1111111111111111111111111");
//		System.out.println(provider);
//		System.out.println(providerId);
//		System.out.println(username);
//		System.out.println(password);
//		System.out.println("2222222222222222222");
//		
//		request.setAttribute("username", username);
//		request.setAttribute("password", password);
//		request.setAttribute("provider", provider);
//		request.setAttribute("providerId", providerId);
//	
//		System.out.println("---------------------");
//		System.out.println(request.getParameter("username"));
//		System.out.println(request.getParameter("password"));
//		System.out.println(request.getParameter("provider"));
//		System.out.println(request.getParameter("providerId"));
//		System.out.println(request.getParameter("code"));
//		
//		chain.doFilter(request, response);
//		
//	}
//
//	@Override
//	public void destroy() {
//		// TODO Auto-generated method stub
//		
//	}
//
//	
//	
//}
//
//
////System.out.println(loginDAO);
////Member member = loginDAO.findUser(username);
////
////if(member==null) {
////
////	member = Member.builder()
////				.username(username)
////				.password(bCryptPasswordEncoder.encode(password))
////				.nickName("null")
////				.status("Y")
////				.orange(0L)
////				.role("ROLE_USER")
////				.provider(provider)
////				.providerId(providerId)
////				.build();
////	
////	System.out.println(member);
////	loginDAO.registerMember(member);
////}
