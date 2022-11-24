package com.world.Y2K.service.board;

import java.util.ArrayList;


import com.world.Y2K.model.vo.Board;
import com.world.Y2K.model.vo.PageInfo;
import com.world.Y2K.model.vo.Reply;


public interface BoardService {

	int getBoardListCount();

	ArrayList<Board> selectBoardList(PageInfo pi);
	
	int insertBoard(Board b);
	
	Board selectBoard(int bNo);

	ArrayList<Reply> selectReply(int bNo);

}
