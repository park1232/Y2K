package com.world.Y2K.service.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.world.Y2K.dao.login.LoginDAO;

@Service
public class CheckNicknameServiceImpl implements CheckNicknameService{

	@Autowired
	private LoginDAO loginDAO;
	
	@Override
	public int checkNickname(String inputNickname){	
		if(loginDAO.checkNickname(inputNickname.substring(14))==1) {
			return 1;
		}
		return 0;
	}

}
