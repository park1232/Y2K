package com.world.Y2K.service.mypage;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.world.Y2K.dao.login.LoginDAO;
import com.world.Y2K.dao.mypage.MypageDAO;
import com.world.Y2K.model.dto.Mypage;

@Service
public class OnloadEntityServiceImpl implements OnloadEntityService{

	@Autowired
	private MypageDAO mypageDAO;
	
	@Autowired
	private LoginDAO loginDAO;
	
	@Override
	public HashMap<String, Object> getOnloadEntity(Long userNo) {
		System.out.println("onload : " + userNo);
		String nickName = loginDAO.findNickname(userNo);
		 Mypage mypage = mypageDAO.getOnloadEntity(userNo);
		
		return setMap(mypage);
		
	}

	private HashMap<String, Object> setMap(Mypage mypage) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("skinPath", mypage.getSkinPath());
		map.put("mainTitle", mypage.getMainTitle());
		map.put("profilePath", mypage.getProfilePath());
		map.put("sideContent", mypage.getSideContent());
		map.put("ownerNickname", mypage.getOwnerNickname());
		return map;
	}



	
	
}
