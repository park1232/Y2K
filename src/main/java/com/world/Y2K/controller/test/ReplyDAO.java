package com.world.Y2K.controller.test;

import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository("rDAO")
public class ReplyDAO {

	public int insertReply(SqlSessionTemplate sqlSession, HashMap<String,Object> map) {
		
//		System.out.println(reply);
		
		return sqlSession.insert("replyMapper.insertReply", map);
	}

}
