package com.world.Y2K.service.board;

import java.util.ArrayList;
import java.util.HashMap;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.world.Y2K.dao.board.BoardDAO;
import com.world.Y2K.model.vo.Board;
import com.world.Y2K.model.vo.PageInfo;
import com.world.Y2K.model.vo.Reply;

@Service("bService")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private BoardDAO bDAO;

	@Override
	public int getBoardListCount() {
		return bDAO.getBoardListCount(sqlSession);
	}

	@Override
	public ArrayList<Board> selectBoardList(PageInfo pi) {
		
		return bDAO.selectBoardList(sqlSession, pi);
	}
	
	
	@Override
	public int insertBoard(Board b) {
		return bDAO.insertBoard(sqlSession, b);
	}

	@Override
	public Board selectBoard(Long bNo) {

		int result = bDAO.boardCount(sqlSession, bNo);	
		
		Board b = bDAO.selectBoard(sqlSession, bNo);
		
		return b;

	}

	@Override
	public int getSearchListCount(HashMap<String, String> map) {

		return bDAO.getSearchListCount(sqlSession, map);
	}

	@Override
	public ArrayList<Board> selectSearchList(HashMap<String, String> map, PageInfo pi) {
		
		return bDAO.getSearchListCount(sqlSession, map, pi);
	}

	@Override
	public int updateBoard(Board b) {
		
		return bDAO.updateBoard(sqlSession, b);
	}

	@Override
	public int deletBoard(Long bNo) {
		return bDAO.deleteBoard(sqlSession, bNo);
	}

	@Override
	public ArrayList<Reply> selectReply(Long bNo) {

		return bDAO.selectReply(sqlSession, bNo);
	}
	
	@Override
	public int insertReply(Reply r) {

		return bDAO.insertReply(sqlSession, r);
	}
	
}
