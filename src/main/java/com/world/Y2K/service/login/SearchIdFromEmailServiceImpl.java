package com.world.Y2K.service.login;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.world.Y2K.dao.login.LoginDAO;

@Service
public class SearchIdFromEmailServiceImpl implements SearchIdFromEmailService{

	@Autowired
	private LoginDAO loginDAO;
	
	
	@Override
	public Map<String, Object> searchIdFromEamil(String email) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		String username = loginDAO.searchIdFormEmail(email);
		System.out.println(username);
		map.put("searchIdResult", username);
		return map;
	}

}
