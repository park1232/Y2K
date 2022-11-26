package com.world.Y2K.service.friend;

import java.util.ArrayList;
import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.world.Y2K.dao.friend.FriendDAO;
import com.world.Y2K.model.dto.Member;
import com.world.Y2K.model.vo.FriendAdd;
import com.world.Y2K.model.vo.FriendPageInfo;
import com.world.Y2K.model.vo.Friends;

@Service("friendService")
public class FriendImpl implements FriendService{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private FriendDAO friendDAO;
	
	@Override
	public int getFriendListCount() {
		return friendDAO.getFriendListCount(sqlSession);
	}
	
	@Override
	public ArrayList<Member> selectFriendList(FriendPageInfo pi, Long userNo) {
		return friendDAO.selectFriendList(sqlSession, pi, userNo);
	}
	
	@Override
	public ArrayList<Member> selectMember(Long userNo) {
		return friendDAO.selectMember(sqlSession, userNo);
	}
	
	@Override
	public int checkNickName(String nickName) {
		return friendDAO.checkNickName(sqlSession, nickName);
	}
	
	@Override
	public int friendAdd2(FriendAdd fa) {
		return friendDAO.friendAdd2(sqlSession, fa);
	}
	
	@Override
	public Member searchAddUser(Long userNo) {
		return friendDAO.searchAddUser(sqlSession, userNo);
	}
	
	@Override
	public Member searchRequestUser(String nickName) {
		return friendDAO.searchRequestUser(sqlSession, nickName);
	}
	
	@Override
	public int friendAdd(HashMap<String, Long> list) {
		return friendDAO.friendAdd(sqlSession, list);
	}
	
	@Override
	public int checkFriendList(HashMap<String, Long> list) {
		return friendDAO.checkFriendList(sqlSession, list);
	}
	
	@Override
	public int checkFriendList2(HashMap<String, Long> list) {
		return friendDAO.checkFriendList2(sqlSession, list);
	}
	
	@Override
	public ArrayList<Member> selectFriendAcceptList(FriendPageInfo pi, Long userNo) {
		return friendDAO.selectFriendAcceptList(sqlSession, pi, userNo);
	}
	
	@Override
	public int checkFriendAdd(FriendAdd fa) {
		return friendDAO.checkFrindAdd(sqlSession, fa);
	}
	
	@Override
	public ArrayList<Member> requestList(String nickName, FriendPageInfo pi) {
		return friendDAO.requestList(sqlSession, pi, nickName);
	}
	
	@Override
	public int checkFriendAddSelf(FriendAdd fa) {
		return friendDAO.checkFriendAddSelf(sqlSession, fa);
	}
}
