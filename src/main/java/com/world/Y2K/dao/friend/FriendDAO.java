package com.world.Y2K.dao.friend;

import java.util.ArrayList;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.world.Y2K.model.dto.Member;
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
}
