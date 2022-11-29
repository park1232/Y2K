package com.world.Y2K.service.mypage;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.world.Y2K.dao.mypage.MypageDAO;
import com.world.Y2K.service.login.auth.UserDetailsImpl;

@Service
public class BackgroundChangeServiceImpl implements BackgroundChangeService {

	@Autowired
	private MypageDAO mypageDAO;
	
	@Override
	public String backgroundChange(String skinName, UserDetailsImpl userDetails, Model model) {
	
		String changeSkinPath = setChangeSkinPath(skinName);
		HashMap<String, Object> map = setUpdateSkinPathMap(changeSkinPath, userDetails.getMember().getUserNo());
		mypageDAO.updateSkinPath(map);
		
		model.addAttribute("userNo",userDetails.getMember().getUserNo());
		System.out.println(userDetails.getMember().getUserNo());
		return "redirect:/main.lo";
	}

	private String setChangeSkinPath(String skinName) {
		
		switch(skinName) {
		
		case "red": return "../../../../../../../../../upload/mainSkin3.jpg"; 
		case "milkyWay": return "../../../../../../../../../upload/mainSkin1.jpg";
		case "green": return "../../../../../../../../../upload/mainSkin2.jpg"; 
		case "blue": return "../../../../../../../../../upload/mainSkin4.jpg"; 
		case "purple": return "../../../../../../../../../upload/mainSkin5.jpg"; 
		case "pink": return "../../../../../../../../../upload/mainSkin6.jpg"; 
		case "sky": return "../../../../../../../../../upload/mainSkin7.jpg"; 
		
		}
		return "null";
		
	}
	
	private HashMap<String, Object> setUpdateSkinPathMap(String changeSkinPath, Long userNo) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("skinPath", changeSkinPath);
		map.put("userNo", userNo);
		
		return map;
	}

}
