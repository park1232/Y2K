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

	
	
}
