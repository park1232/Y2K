package com.world.Y2K.dao.friend;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.world.Y2K.model.dto.Member;
import com.world.Y2K.model.vo.FriendAdd;
import com.world.Y2K.model.vo.FriendPageInfo;

@Repository("friendDAO")
public class FriendDAO {
	public int getFriendListCount(SqlSessionTemplate sqlSession) {
		return sqlSession.selectOne("friendMapper.getFriendListCount");
	}

	public ArrayList<Member> selectFriendList(SqlSessionTemplate sqlSession, FriendPageInfo pi, Long userNo) {
		int offset = (pi.getFriendCurrentPage() -1) * pi.getFriendBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getFriendBoardLimit());
		return (ArrayList)sqlSession.selectList("friendMapper.selectFriendList", userNo, rowBounds);
	}

	public ArrayList<Member> selectMember(SqlSessionTemplate sqlSession, Long userNo) {
		return (ArrayList)sqlSession.selectList("friendMapper.selectMember", userNo);
	}

	public int checkNickName(SqlSessionTemplate sqlSession, String nickName) {
		return sqlSession.selectOne("friendMapper.checkNickName", nickName);
	}

	public int friendAdd2(SqlSessionTemplate sqlSession, FriendAdd fa) {
		return sqlSession.insert("friendMapper.friendAdd2", fa);
	}

	public Member searchAddUser(SqlSessionTemplate sqlSession, Long userNo) {
		return sqlSession.selectOne("friendMapper.searchAddUser", userNo);
	}

	public Member searchRequestUser(SqlSessionTemplate sqlSession, String nickName) {
		return sqlSession.selectOne("friendMapper.searchRequestUser", nickName);
	}

	public int friendAdd(SqlSessionTemplate sqlSession, HashMap<String, Long> list) {
		return sqlSession.insert("friendMapper.friendAdd", list);
	}

	public int checkFriendList(SqlSessionTemplate sqlSession, HashMap<String, Long> list) {
		return sqlSession.selectOne("friendMapper.checkFriendList", list);
	}

	public int checkFriendList2(SqlSessionTemplate sqlSession, HashMap<String, Long> list) {
		return sqlSession.selectOne("friendMapper.checkFriendList2", list);
	}

	public ArrayList<Member> selectFriendAcceptList(SqlSessionTemplate sqlSession, FriendPageInfo pi, Long userNo) {
		int offset = (pi.getFriendCurrentPage() -1) * pi.getFriendBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getFriendBoardLimit());
		return (ArrayList)sqlSession.selectList("friendMapper.selectFriendAcceptList", userNo, rowBounds);
	}

	public int checkFrindAdd(SqlSessionTemplate sqlSession, FriendAdd fa) {
		return sqlSession.selectOne("friendMapper.checkFriendAdd", fa);
	}

	public ArrayList<Member> requestList(SqlSessionTemplate sqlSession, FriendPageInfo pi, String nickName) {
		int offset = (pi.getFriendCurrentPage() -1) * pi.getFriendBoardLimit();
		RowBounds rowBounds = new RowBounds(offset, pi.getFriendBoardLimit());
		return (ArrayList)sqlSession.selectList("friendMapper.requestList", nickName, rowBounds);
	}

	public int checkFriendAddSelf(SqlSessionTemplate sqlSession, FriendAdd fa) {
		return sqlSession.selectOne("friendMapper.checkFriendAddSelf", fa);
	}
}
