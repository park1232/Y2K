package com.world.Y2K.service.board;

import java.util.ArrayList;
import java.util.HashMap;

import com.world.Y2K.model.vo.Board;
import com.world.Y2K.model.vo.PageInfo;
import com.world.Y2K.model.vo.Reply;


public interface BoardService {

	int getBoardListCount();

	ArrayList<Board> selectBoardList(PageInfo pi);
	
	int insertBoard(Board b);
	
	Board selectBoard(Long bNo);

	ArrayList<Reply> selectReply(Long bNo);

	int getSearchListCount(HashMap<String, String> map);

	ArrayList<Board> selectSearchList(HashMap<String, String> map, PageInfo pi);

	int updateBoard(Board b);

	int deletBoard(Long bNo);

	int insertReply(Reply r);


}
