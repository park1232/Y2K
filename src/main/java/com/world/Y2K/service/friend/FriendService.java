package com.world.Y2K.service.friend;

import java.util.ArrayList;
import java.util.HashMap;

import com.world.Y2K.model.dto.Member;
import com.world.Y2K.model.entity.FriendAddEntity;
import com.world.Y2K.model.vo.FriendAdd;
import com.world.Y2K.model.vo.FriendPageInfo;

public interface FriendService {

	int getFriendListCount();

	ArrayList<Member> selectFriendList(FriendPageInfo pi, Long userNo);

	ArrayList<FriendAddEntity> selectMember(Long userNo);

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

	ArrayList<FriendAdd> selectFriendAddList(HashMap<String, Object> map);

	int accpetFriendResult(Long loginuserNo);

	int hideAccept(String loginuserNickName);

	int deleteFriend(HashMap<String, Long> map);

}