package com.world.Y2K.service.main;

import java.util.ArrayList;

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
	public ArrayList<Reply> replyList(Long boardNo) {
		
		System.out.println(boardNo);
		
		return mDAO.replyList(sqlSession, boardNo);
	}

	@Override
	public void insertReply(Reply r) {
		
		System.out.println(r);
		
		
	}
	
}
