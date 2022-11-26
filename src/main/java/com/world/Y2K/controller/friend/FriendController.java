package com.world.Y2K.controller.friend;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.world.Y2K.exception.FriendException;
import com.world.Y2K.model.dto.Member;
import com.world.Y2K.model.vo.FriendAdd;
import com.world.Y2K.model.vo.FriendPageInfo;
import com.world.Y2K.pagination.FriendPagination;
import com.world.Y2K.service.friend.FriendService;
import com.world.Y2K.service.login.auth.UserDetailsImpl;

@Controller
public class FriendController {
	
	@Autowired
	private FriendService fService;
	
	@RequestMapping("/friendList.fr")
	public String friendList(@RequestParam(value="page", required=false) Integer page, Model model, Authentication authentication) throws FriendException {
		UserDetailsImpl userdetails = (UserDetailsImpl)authentication.getPrincipal();
		Long userNo = userdetails.getMember().getUserNo();
		
		int friendCurrentPage = 1;

		if(page != null) {
			friendCurrentPage = page;
		}
		
		int friendListCount = fService.getFriendListCount();
		FriendPageInfo pi = FriendPagination.getPageInfo(friendCurrentPage, friendListCount, 5);
		ArrayList<Member> fList = fService.selectFriendList(pi, userNo); // 친구 신청 보낸 사람의 친구 목록
		
		if(fList != null) {
			model.addAttribute("pi", pi);
			model.addAttribute("fList", fList);
			model.addAttribute("userNo", userNo);
			return "friend/friendList";
		} else {
			throw new FriendException("친구 목록 조회 실패");
		}
	}
	
	@RequestMapping("/friendAdd.fr")
	public String friendAdd(Authentication authentication, Model model) throws FriendException {
		UserDetailsImpl userdetails = (UserDetailsImpl)authentication.getPrincipal();
		Long userNo = userdetails.getMember().getUserNo();
		
		ArrayList<Member> mList = fService.selectMember(userNo);

		LocalDate now = LocalDate.now();	
		
		if(mList != null) {
			model.addAttribute("mList", mList);
			model.addAttribute("now", now);
			
			return "friend/friendAdd";
		} else {
			throw new FriendException("친구 추가 페이지 조회 실패");
		}
	}
	
	@RequestMapping("/checkNickName.fr")
	@ResponseBody // return값을 페이지로 이동이 아닌 컨트롤러에서 뷰에다 데이터를 보내는걸로 인식함
	public String checkNickName(@RequestParam("nickName") String nickName) {
//		UserDetailsImpl userdetails = (UserDetailsImpl)authentication.getPrincipal();
//		Long userNo = userdetails.getMember().getUserNo();
		System.out.println("나오냐?");
		
		int count = fService.checkNickName(nickName);
		
		System.out.println(count);
		
		String result = count == 1 ? "O" : "X";
		
		System.out.println(result);
		
		return result;
	}
	
	@RequestMapping("friendAdd2.fr")
	public String friendAdd2(Authentication authentication, Model model, @RequestParam("nickName") String nickName, @RequestParam("userNo") Long userNo, @RequestParam("friendContent") String friendContent) throws FriendException {
		UserDetailsImpl userdetails = (UserDetailsImpl)authentication.getPrincipal();
		Long userAddNo = userdetails.getMember().getUserNo();
		
		FriendAdd fa = new FriendAdd();
		fa.setFriendContent(friendContent);
		fa.setUserNo(userNo);
		fa.setNickName(nickName);
				
		Member addUser = fService.searchAddUser(userNo); // 신청자 정보 가져오기
		
		Member requestUser = fService.searchRequestUser(nickName); // 받는 사람 정보 가져오기
		
		Long addUser2 = addUser.getUserNo();
		Long requestUser2 = requestUser.getUserNo();
		
		HashMap<String, Long> list = new HashMap<>();
		list.put("addUser2", addUser2);
		list.put("requestUser2", requestUser2);
		
		int checkFriendAdd = fService.checkFriendAdd(fa); // 이미 요청을 보냈는지 확인
		int checkFriendList = fService.checkFriendList(list); // 이미 친구 인지 확인
		int checkFriendAddSelf = fService.checkFriendAddSelf(fa); // 자기 자신에게 보내는지 확인
		
		if(checkFriendAdd == 0) {
			if(checkFriendList == 0) {
				if(checkFriendAddSelf == 0) {
					int result = fService.friendAdd2(fa); // 친구 신청 테이블에 요청 데이터 넣기
					int resultFinal = fService.friendAdd(list); // 신청자와 받는 사람 정보 가져가서 친구 테이블에 데이터 넣기 status는 'n'으로
				
					if(resultFinal > 0) {			
						return "redirect:friendList.fr"; // 최종 db에 삽입 결과 확인
					} else {
						throw new FriendException("친구 신청 실패"); 
					}
				} else {
					throw new FriendException("자신한테는 친구 요청을 할 수 없습니다.");
				}
			} else {
				throw new FriendException("이미 등록된 친구입니다.");
			}	
		} else {
			throw new FriendException("이미 요청한 사람입니다.");
		}		
	}
	
	@RequestMapping("/friendRequestList.fr")
	public String friendRequestList(@RequestParam(value="page", required=false) Integer page, Model model, Authentication authentication) throws FriendException {
		UserDetailsImpl userdetails = (UserDetailsImpl)authentication.getPrincipal();
		String nickName = userdetails.getMember().getNickName();
		System.out.println("나오냐?");
		System.out.println(nickName);
		
		int friendCurrentPage = 1;
		
		if(page != null) {
			friendCurrentPage = page;
		}	
		
		int friendListCount = fService.getFriendListCount();
		FriendPageInfo pi = FriendPagination.getPageInfo(friendCurrentPage, friendListCount, 5);
		
		ArrayList<Member> requestList = fService.requestList(nickName, pi);	
		
		System.out.println(requestList);
		if(requestList != null) {
			model.addAttribute("pi", pi);
			model.addAttribute("requestList", requestList);
			return "friend/friendRequestList";
		} else {
			throw new FriendException("친구 요청 목록 조회 실패");
		}
	}
	
//	 친구 요청 한거 볼 수 있는 페이지
//	@RequestMapping("/friendRequestList.fr")
//	public String friendRequestList(@RequestParam(value="page", required=false) Integer page, Model model, Authentication authentication) throws FriendException {
//		UserDetailsImpl userdetails = (UserDetailsImpl)authentication.getPrincipal();
//		Long userNo = userdetails.getMember().getUserNo();
//		
//		int friendCurrentPage = 1;
//
//		if(page != null) {
//			friendCurrentPage = page;
//		}
//		
//		int friendListCount = fService.getFriendListCount();
//		FriendPageInfo pi = FriendPagination.getPageInfo(friendCurrentPage, friendListCount, 5);
//		ArrayList<Member> fAList = fService.selectFriendAcceptList(pi, userNo);
//		
//		if(fAList != null) {
//			model.addAttribute("pi", pi);
//			model.addAttribute("fList", fAList);
//			model.addAttribute("userNo", userNo);
//			return "friend/friendRequestList";
//		} else {
//			throw new FriendException("친구 목록 조회 실패");
//		}	
//	}
	
//	@RequestMapping("friendAccept.fr")
//	public String friendAccept(Authentication authentication, Model model) throws FriendException {
//		UserDetailsImpl userdetails = (UserDetailsImpl)authentication.getPrincipal();
//		Long userNo = userdetails.getMember().getUserNo();
//		
//		ArrayList<Member> mList = fService.selectMember(userNo);
//		
//		
//		if(mList != null) {
//			model.addAttribute("mList", mList);
//			return "friend/friendAccept";
//		} else {
//			throw new FriendException("친구 추가 페이지 조회 실패");
//		}
//	}
}
