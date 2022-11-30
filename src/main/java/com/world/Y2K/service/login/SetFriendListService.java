package com.world.Y2K.service.login;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.world.Y2K.dao.login.LoginDAO;
import com.world.Y2K.model.dto.Member;
import com.world.Y2K.model.entity.FriendPath;

@Service
public class SetFriendListService {

	@Autowired
	private LoginDAO loginDAO;

	public void setFreindList(HttpSession session, Long userNo) {
		ArrayList<Member> list = loginDAO.getFriendsList(userNo);
		ArrayList<FriendPath> friendList = new ArrayList<FriendPath>();
		
		for(Member member : list) {
			FriendPath friendPath = FriendPath.builder()
					.friendPath("/mainPage.ma?userNo="+member.getUserNo())
					.friendNickname(member.getNickName())
					.build();
			friendList.add(friendPath);
		}
		
		session.setAttribute("friendPathList", friendList);
	}
}
