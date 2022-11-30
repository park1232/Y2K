package com.world.Y2K.dao.reply;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.world.Y2K.model.vo.Reply;

@Repository("rDAO")
public class ReplyDAO {

	public int insertReply(SqlSessionTemplate sqlSession, HashMap<String,Object> map) {
		
		return sqlSession.insert("replyMapper.insertReply", map);
	}

	public void deleteReply(SqlSessionTemplate sqlSession, Long replyNo) {
		
		sqlSession.update("replyMapper.deleteReply", replyNo);
	}

}
