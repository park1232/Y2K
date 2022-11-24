package com.world.Y2K.service.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.world.Y2K.dao.login.LoginDAO;

@Service
public class CheckIdServiceImpl  implements CheckIdService {

	@Autowired
	private LoginDAO loginDAO;
	
	@Override
	public int checkId(String inputId) {	
		if(loginDAO.checkUser(inputId.substring(8))==1) {
			return 1;
		}
		return 0;
	}

}
