package com.world.Y2K.service.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.world.Y2K.dao.main.MainDAO;
import com.world.Y2K.model.vo.Reply;







@Service("mService")
public class MainServiceImpl implements MainService{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private MainDAO mDAO;

	@Override
	public ArrayList<Reply> replyList(Long userNo) {
		
		System.out.println(userNo);
		
		return mDAO.replyList(sqlSession, userNo);
	}

	@Override
	public Map<String,Object> insertReply(String content, String nickName, Long replyWriter) {
		
		HashMap<String, Object> map = new HashMap<String,Object>();
		
		map.put("content", content);
		map.put("nickname", nickName);
		map.put("userNo", replyWriter);
		
		int result = mDAO.insertReply(sqlSession, map);
//		System.out.println(result);
//		
//		System.out.println("mapÀ§Ä¡"+ map);
//		System.out.println(map);
		
		return map;
	}
	
}
