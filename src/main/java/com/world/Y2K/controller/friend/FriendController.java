package com.world.Y2K.controller.friend;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.world.Y2K.exception.FriendException;
import com.world.Y2K.model.dto.Member;
import com.world.Y2K.model.vo.FriendPageInfo;
import com.world.Y2K.pagination.FriendPagination;
import com.world.Y2K.service.friend.FriendService;
import com.world.Y2K.service.login.auth.UserDetailsImpl;

@Controller
public class FriendController {
	
	@Autowired
	private FriendService fService;
	
	@RequestMapping("/friendList.fr")
	public String test2(@RequestParam(value="page", required=false) Integer page, Model model, Authentication authentication) throws FriendException {
		UserDetailsImpl userdetails = (UserDetailsImpl)authentication.getPrincipal();
		Long userNo = userdetails.getMember().getUserNo();
		
		int friendCurrentPage = 1;
		System.out.println(userNo);
		if(page != null) {
			friendCurrentPage = page;
		}
		
		int friendListCount = fService.getFriendListCount();
		FriendPageInfo pi = FriendPagination.getPageInfo(friendCurrentPage, friendListCount, 5);
		ArrayList<Member> fList = fService.selectFriendList(pi, userNo);
		
		System.out.println(fList);
		
		if(fList != null) {
			model.addAttribute("pi", pi);
			model.addAttribute("fList", fList);
			model.addAttribute("userNo", userNo);
			return "friend/friendList";
		} else {
			throw new FriendException("친구 목록 조회 실패");
		}
	}
	
	@GetMapping("/friendAdd.fr")
	public String test() {
		return "friend/friendAdd";
	}
	
	@GetMapping("/friendRequestList.fr")
	public String test5() {
		return "friend/friendRequestList";
	}
	
}
