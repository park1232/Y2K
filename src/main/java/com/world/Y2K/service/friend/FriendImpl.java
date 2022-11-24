package com.world.Y2K.service.friend;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.world.Y2K.dao.friend.FriendDAO;
import com.world.Y2K.model.dto.Member;
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
}
