package com.world.Y2K.dao.main;

import java.util.ArrayList;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.world.Y2K.model.vo.Reply;

@Repository("mDAO")
public class MainDAO {

	public ArrayList<Reply> replyList(SqlSessionTemplate sqlSession, Long boardNo) {
		
		return (ArrayList)sqlSession.selectList("replyMapper.selectReply", boardNo);
	}

	
	
}
