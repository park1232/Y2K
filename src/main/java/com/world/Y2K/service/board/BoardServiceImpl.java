package com.world.Y2K.service.board;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.world.Y2K.dao.board.BoardDAO;
import com.world.Y2K.exception.BoardException;
import com.world.Y2K.model.vo.Board;
import com.world.Y2K.model.vo.Like;
import com.world.Y2K.model.vo.PageInfo;
import com.world.Y2K.model.vo.Reply;
import com.world.Y2K.service.login.auth.UserDetailsImpl;

@Service("bService")
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Autowired
	private BoardDAO bDAO;

	@Override
	public int getBoardListCount(Long userNo) {
		return bDAO.getBoardListCount(sqlSession, userNo);
	}

	@Override
	public ArrayList<Board> selectBoardList(PageInfo pi, Long userNo) {
		
		return bDAO.selectBoardList(sqlSession, pi, userNo);
	}
	
	
	@Override
	public String insertBoard(String cateStr, Board b, HttpSession session, Authentication authentication, Long userNo, Model model) {
		UserDetailsImpl userDetails = (UserDetailsImpl)authentication.getPrincipal();	
		model.addAttribute("userNo", userNo);
		Long boardWriter = (userDetails.getMember()).getUserNo();
		System.out.println("insertBoard : " + userNo);
		String category = getCategory(cateStr);
		b.setOwn(userNo);
		if(bDAO.insertBoard(sqlSession, getBoard(b, boardWriter, category))>0) {
			return "redirect:/boardList.bo";
		}else {
			throw new BoardException("寃뚯떆湲� �벑濡� �떎�뙣");
		}
	}
	
	private Board getBoard(Board b,Long boardWriter, String cateStr) {
		b.setBoardWriter(boardWriter);
		b.setBoardCateId(cateStr);
		return b;
	}
	
	private String getCategory(String cateStr) {
			switch(cateStr) {
			case "잡담" : return "A";
			case "유머" : return "B"; 
			case "정보" : return "C"; 
			case "기타" : return "D"; 
		}
			
			System.out.println("cateStr : " + cateStr);
		return null;
	}

	@Override
	public Board selectBoard(Long bNo) {

		int result = bDAO.boardCount(sqlSession, bNo);	
		
		Board b = bDAO.selectBoard(sqlSession, bNo);
		
		return b;

	}

	@Override
	public int getSearchListCount(HashMap<String, Object> map) {

		return bDAO.getSearchListCount(sqlSession, map);
	}

	@Override
	public ArrayList<Board> selectSearchList(HashMap<String, Object> map, PageInfo pi) {
		System.out.println("dao : " + map);
		return bDAO.getSearchList(sqlSession, map, pi);
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

	@Override
	public int deleteReply(Long rNo) {
		return bDAO.deleteReply(sqlSession, rNo);
	}

	@Override
	public int likeCheck(Like like) {
		return bDAO.likeCheck(sqlSession, like);
	}

	@Override
	public void likeInsert(Like like) {
		bDAO.likeInsert(sqlSession, like);
		
	}

	@Override
	public void likeDelete(Like like) {
		bDAO.likeDelete(sqlSession, like);
		
	}

	@Override
	public int likeCount(Long bNo) {
		return bDAO.likeCount(sqlSession, bNo);
	}


	
}

