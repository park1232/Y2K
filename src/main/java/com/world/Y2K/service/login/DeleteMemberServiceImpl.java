package com.world.Y2K.service.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.world.Y2K.dao.login.LoginDAO;

@Service
public class DeleteMemberServiceImpl implements DeleteMemberService{

	@Autowired
	private LoginDAO loginDAO;
		
	@Override
	public String deleteMember(Long userNo) {
		loginDAO.deleteMember(userNo);
		return "login/loginPage";
	}

}
