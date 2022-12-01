package com.world.Y2K.dao.board;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import com.world.Y2K.model.vo.Board;
import com.world.Y2K.model.vo.Like;
import com.world.Y2K.model.vo.PageInfo;
import com.world.Y2K.model.vo.Reply;

@Repository("bDAO")
public class BoardDAO {

	public int getBoardListCount(SqlSessionTemplate sqlSession, Long own) {
		return sqlSession.selectOne("boardMapper.getBoardListCount", own);
	}

	public ArrayList<Board> selectBoardList(SqlSessionTemplate sqlSession, PageInfo pi, Long own) {
		int offset = (pi.getCurrentPage() - 1)*pi.getBoardLimit();
		RowBounds row = new RowBounds(offset, pi.getBoardLimit());
		
		return (ArrayList)sqlSession.selectList("boardMapper.selectBoardList", own, row);
	}
	
	
	public int insertBoard(SqlSessionTemplate sqlSession, Board b) {
		System.out.println("boardDAO : " + b);
		return sqlSession.insert("boardMapper.insertBoard", b);
	}
	
	public int boardCount(SqlSessionTemplate sqlSession, Long bNo) {
		
		return sqlSession.update("boardMapper.boardCount", bNo);
	}

	public Board selectBoard(SqlSessionTemplate sqlSession,Long bNo) {
		return sqlSession.selectOne("boardMapper.selectBoard", bNo);
	}
	

	public int getSearchListCount(SqlSessionTemplate sqlSession, HashMap<String, Object> map) {

		return sqlSession.selectOne("boardMapper.getSearchListCount", map);
	}

	public ArrayList<Board> getSearchList(SqlSessionTemplate sqlSession, HashMap<String, Object> map,
			PageInfo pi) {
		int offset = (pi.getCurrentPage() - 1)*pi.getBoardLimit();
		RowBounds row = new RowBounds(offset, pi.getBoardLimit());
		
		return (ArrayList)sqlSession.selectList("boardMapper.selectSearchList", map, row);
	}

	public int updateBoard(SqlSessionTemplate sqlSession, Board b) {
		return sqlSession.update("boardMapper.updateBoard", b);
	}

	public int deleteBoard(SqlSessionTemplate sqlSession, Long bNo) {

		return sqlSession.update("boardMapper.deleteBoard", bNo);
	}
	
	public ArrayList<Reply> selectReply(SqlSessionTemplate sqlSession, Long bNo) {
		System.out.println("selectReply : " + bNo);
		ArrayList<Reply> list = new ArrayList<Reply>();
		list = (ArrayList)sqlSession.selectList("boardMapper.selectReply", bNo);
		System.out.println("list : " + list);
		return list;
	}

	public int insertReply(SqlSessionTemplate sqlSession, Reply r) {
		
		return sqlSession.insert("boardMapper.insertReply", r);
	}

	public int deleteReply(SqlSessionTemplate sqlSession, Long rNo) {
		
		return sqlSession.update("boardMapper.deleteReply", rNo);
	}

	public int likeCheck(SqlSessionTemplate sqlSession, Like like) {
		
		return sqlSession.selectOne("boardMapper.likeCheck", like);
	}

	public void likeInsert(SqlSessionTemplate sqlSession, Like like) {
		
		sqlSession.insert("boardMapper.likeInsert", like);
	}

	public void likeDelete(SqlSessionTemplate sqlSession, Like like) {
		
		sqlSession.delete("boardMapper.likeDelete", like);
		
	}

	public int likeCount(SqlSessionTemplate sqlSession, Long bNo) {

		return sqlSession.selectOne("boardMapper.likeCount", bNo);
	}

}
