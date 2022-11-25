package com.world.Y2K.controller.test;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service("rService")
public class ReplyServiceImpl implements ReplyService{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private ReplyDAO rDAO;

	@Override
	public Map<String, Object> insertReply(String content, Long boardNo, String nickName, Long userNo) {
		
//		Photo photo = new Photo();
//		photo.setBoardNo(boardNo);
		
//		System.out.println("서비스 : " + content);
//		System.out.println("서비스 : " + boardNo);
//		System.out.println("서비스 : " + rNickName);
//		System.out.println("서비스 : " + userNo);
		
		
		HashMap<String, Object> map = new HashMap<String,Object>();
		map.put("content", content);
		map.put("nickname", nickName);
		map.put("boardNo", boardNo);
		map.put("userNo", userNo);
		rDAO.insertReply(sqlSession, map);
//		Reply reply = new Reply();
//		reply.setReplyContent(content);
//		reply.setRboardNo(boardNo);
//		reply.setReplyWriter(userNo);
//		reply.setRNickName(rNickName);
	
		
		
		
		return map;
	}
	
	
	
}
