package com.world.Y2K.service.mypage;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.world.Y2K.dao.mypage.MypageDAO;
import com.world.Y2K.service.login.auth.UserDetailsImpl;

@Service
public class TitleChangeServiceImpl implements TitleChangeService{

	@Autowired
	private MypageDAO mypageDAO;
	
	@Override
	public String titleChange(String inputTitle, UserDetailsImpl userDetails, Model model) {
		model.addAttribute("userNo",userDetails.getMember().getUserNo());
		HashMap<String, Object> map = setUpdateTitleMap(inputTitle, userDetails.getMember().getUserNo());
		mypageDAO.updateTitle(map);
		return "redirect:/main.lo";
	}

	private HashMap<String, Object> setUpdateTitleMap(String inputTitle, Long userNo) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("mainTitle", inputTitle);
		map.put("userNo", userNo);
		
		return map;
	}

}
