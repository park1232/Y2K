package com.world.Y2K.service.friend;

import java.util.ArrayList;
import java.util.HashMap;

import com.world.Y2K.model.dto.Member;
import com.world.Y2K.model.vo.FriendAdd;
import com.world.Y2K.model.vo.FriendPageInfo;
import com.world.Y2K.model.vo.Friends;

public interface FriendService {

	int getFriendListCount();

	ArrayList<Member> selectFriendList(FriendPageInfo pi, Long userNo);

	ArrayList<Member> selectMember(Long userNo);

	int checkNickName(String nickName);

	int friendAdd2(FriendAdd fa);

	Member searchAddUser(Long userNo);

	Member searchRequestUser(String nickName);

	int friendAdd(HashMap<String, Long> list);

	int checkFriendList(HashMap<String, Long> list);

	int checkFriendList2(HashMap<String, Long> list);

	ArrayList<Member> selectFriendAcceptList(FriendPageInfo pi, Long userNo);

	int checkFriendAdd(FriendAdd fa);

	ArrayList<Member> requestList(String nickName, FriendPageInfo pi);

	int checkFriendAddSelf(FriendAdd fa);

	FriendAdd selectFriendAddList(Long userNo);

	int accpetFriendResult(Long loginuserNo);

	int hideAccept(Long userNo);

	int deleteFriend(Long friendUsing);

}
