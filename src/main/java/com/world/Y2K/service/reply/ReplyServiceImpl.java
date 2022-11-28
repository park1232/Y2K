package com.world.Y2K.service.reply;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.world.Y2K.dao.reply.ReplyDAO;
import com.world.Y2K.model.vo.Board;
import com.world.Y2K.model.vo.Reply;



@Service("rService")
public class ReplyServiceImpl implements ReplyService{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private ReplyDAO rDAO;

	@Override
	public Map<String, Object> insertReply(String content, Long boardNo, String nickName, Long userNo) {

		
		
		
		HashMap<String, Object> map = new HashMap<String,Object>();
		map.put("content", content);
		map.put("nickname", nickName);
		map.put("boardNo", boardNo);
		map.put("userNo", userNo);
		rDAO.insertReply(sqlSession, map);
		
		
		return map;
	}

	@Override
	public void deleteReply(Long userNo, Long replyNo) {


				
				rDAO.deleteReply(sqlSession, replyNo);
		
	}
	
}