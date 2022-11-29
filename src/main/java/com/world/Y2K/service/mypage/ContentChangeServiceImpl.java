package com.world.Y2K.service.mypage;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.world.Y2K.dao.mypage.MypageDAO;
import com.world.Y2K.service.login.auth.UserDetailsImpl;

@Service
public class ContentChangeServiceImpl implements ContentChangeService{
	
	@Autowired
	private MypageDAO mypageDAO;
	
	@Override
	public String contentChange(String inputContent, UserDetailsImpl userDetails, Model model) {
		HashMap<String, Object> map = setUpdateContentMap(inputContent, userDetails.getMember().getUserNo());
		mypageDAO.updateContent(map);
		model.addAttribute("userNo",userDetails.getMember().getUserNo());
		return "redirect:/main.lo";
	}

	private HashMap<String, Object> setUpdateContentMap(String inputContent, Long userNo) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		map.put("sideContent", inputContent);
		map.put("userNo", userNo);
		
		return map;
	}

}
