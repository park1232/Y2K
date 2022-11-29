package com.world.Y2K.dao.main;

import java.util.ArrayList;
import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.world.Y2K.model.vo.Reply;

@Repository("mDAO")
public class MainDAO {

	public ArrayList<Reply> replyList(SqlSessionTemplate sqlSession, Long userNo) {
		
		return (ArrayList)sqlSession.selectList("mainReplyMapper.selectReply", userNo);
	}

	public int  insertReply(SqlSessionTemplate sqlSession, HashMap<String, Object> map) {
		
		return sqlSession.insert("mainReplyMapper.insertReply", map);
	}

	public int bListCount(SqlSessionTemplate sqlSession, Long userNo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("mainReplyMapper.selectBoard", userNo);
	}

	public int pListCount(SqlSessionTemplate sqlSession, Long userNo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("mainReplyMapper.selectPhoto", userNo);
	}

	public int vListCount(SqlSessionTemplate sqlSession, Long userNo) {
		// TODO Auto-generated method stub
		//return sqlSession.selectOne("mainReplyMapper.selectVisit", userNo);
		return 0;
	}

	public int diaryListCount(SqlSessionTemplate sqlSession, Long userNo) {
		// TODO Auto-generated method stub
		//return sqlSession.selectOne("mainReplyMapper.selectDiary", userNo);
		return 0;
	}

	public void deleteReply(SqlSessionTemplate sqlSession, Long replyNo) {
		
		sqlSession.update("mainReplyMapper.deleteReply", replyNo);
	}

	
	
}
