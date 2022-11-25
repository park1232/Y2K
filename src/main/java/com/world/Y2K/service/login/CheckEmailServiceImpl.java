package com.world.Y2K.service.login;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.world.Y2K.dao.login.LoginDAO;
import com.world.Y2K.model.dto.Member;

@Service
public class CheckEmailServiceImpl implements CheckEmailService{

	@Autowired
	private LoginDAO loginDAO;
	
	@Autowired
	private MailAuthService mailAuthService;
	
	@Override
	public Map<String, Object> checkEmail(String username, String email) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		Member member = loginDAO.findUser(username);
		System.out.println(member);
		if(member == null) {
			System.out.println("멤버 널임");
			map.put("result", "Not User");
			map.put("authCode", "null");
			return map;
		}
		
		if(!member.getEmail().equals(email)) {
			System.out.println("이메일 일치하지않음");
			System.out.println(member.getEmail());
			System.out.println(email);
			map.put("result", "Not Matching Email");
			map.put("authCode", "null");
			return map;
		}
		System.out.println("성공");
		map.put("result", "success");
		map.put("authCode",mailAuthService.getEmailAuth(email).get("authCode"));
		
		return map;
	}

}
