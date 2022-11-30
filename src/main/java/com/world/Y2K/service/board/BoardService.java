package com.world.Y2K.service.board;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;

import com.world.Y2K.model.vo.Board;
import com.world.Y2K.model.vo.Like;
import com.world.Y2K.model.vo.PageInfo;
import com.world.Y2K.model.vo.Reply;


public interface BoardService {

	int getBoardListCount();

	ArrayList<Board> selectBoardList(PageInfo pi);
	
	String insertBoard(String cateStr, Board b, HttpSession session, Authentication authentication,Long userNo,Model model);
	
	Board selectBoard(Long bNo);

	ArrayList<Reply> selectReply(Long bNo);

	int getSearchListCount(HashMap<String, String> map);

	ArrayList<Board> selectSearchList(HashMap<String, String> map, PageInfo pi);

	int updateBoard(Board b);

	int deletBoard(Long bNo);

	int insertReply(Reply r);

	int deleteReply(Long rNo);

	int likeCheck(Like like);

	void likeInsert(Like like);

	void likeDelete(Like like);

	int likeCount(Long bNo);

//	Object getLike(Long bNo);


}
