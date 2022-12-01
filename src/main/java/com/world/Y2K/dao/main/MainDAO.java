package com.world.Y2K.dao.main;

import java.util.ArrayList;
import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.world.Y2K.model.dto.Member;
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
		return sqlSession.selectOne("mainReplyMapper.selectVisit", userNo);
	
	}

	public int diaryListCount(SqlSessionTemplate sqlSession, Long userNo) {
		// TODO Auto-generated method stub
			return sqlSession.selectOne("mainReplyMapper.selectDiary", userNo);
		
	}

	public void deleteReply(SqlSessionTemplate sqlSession, Long replyNo) {
		
		sqlSession.update("mainReplyMapper.deleteReply", replyNo);
	}


	public Member owner(SqlSessionTemplate sqlSession, Long userNo) {
		
		return sqlSession.selectOne("mainReplyMapper.owner", userNo);
	}

	public ArrayList<HashMap<String, Object>> photoList(SqlSessionTemplate sqlSession, Long userNo) {
		
		ArrayList<HashMap<String, Object>> pList =(ArrayList)sqlSession.selectList("mainReplyMapper.photoList", userNo);
		
		return pList;
	}

	public ArrayList<HashMap<String, Object>> boardList(SqlSessionTemplate sqlSession, Long userNo) {
		
		ArrayList<HashMap<String, Object>> bList =(ArrayList)sqlSession.selectList("mainReplyMapper.boardList", userNo);
		
		return bList;
	}

	public ArrayList<HashMap<String, Object>> diaryList(SqlSessionTemplate sqlSession, Long userNo) {
		
		ArrayList<HashMap<String, Object>> dList =(ArrayList)sqlSession.selectList("mainReplyMapper.diaryList", userNo);
		
		return dList;
	}

	public ArrayList<HashMap<String, Object>> visitList(SqlSessionTemplate sqlSession, Long userNo) {
		
		ArrayList<HashMap<String, Object>> vList =(ArrayList)sqlSession.selectList("mainReplyMapper.visitList", userNo);
		
		return vList;
	}

	
	
}
