package com.world.Y2K.service.login;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.world.Y2K.dao.login.LoginDAO;
import com.world.Y2K.dao.mypage.MypageDAO;
import com.world.Y2K.exception.MemberException;
import com.world.Y2K.model.dto.Member;

@Service
public class EditNicknameServiceImpl implements EditNicknameService{

	@Autowired
	private LoginDAO loginDAO;
	
	@Autowired
	private MypageDAO mypageDAO;
	
	@Override
	public ModelAndView editNickname(Member member, String nickname) throws MemberException {
		
		if(member.getNickName().equals("null")) {		
			mypageDAO.insertDefault(setMap(member.getUserNo(), nickname));
		}
		
		ModelAndView mv = new ModelAndView();
		HashMap<String, Object> map = new HashMap<String,Object>();
		
		map.put("userNo", member.getUserNo());
		map.put("nickname", nickname);
		if(loginDAO.updateNickname(map)==0) {
			throw new MemberException("닉네임 수정에 실패하였습니다.");
		}
		mypageDAO.updateOwnerNickname(map);
		Member loginUser = loginDAO.findUser(member.getUsername());
		mv.addObject("userNo", loginUser.getUserNo());
		mv.addObject("loginUser", loginUser);
		mv.setViewName("/login/loginSuccess");
		return mv;
		
		
	}

	private HashMap<String, Object> setMap(Long userNo, String nickname) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("userNo", userNo);
		map.put("nickName", nickname);
		return map;
	}

}
