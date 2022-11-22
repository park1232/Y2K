package com.world.Y2K.controller.board;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.world.Y2K.exception.BoardException;
import com.world.Y2K.model.vo.Board;
import com.world.Y2K.model.vo.PageInfo;
import com.world.Y2K.pagination.BoardPagination;
import com.world.Y2K.service.board.BoardService;

@Controller
public class BoardController {

	@Autowired
	private BoardService bService;

	@RequestMapping("boardList.bo")
	public String boardList(@RequestParam(value="page", required=false) Integer page, Model model) {
		int currentPage = 1;
		if(page != null) {
			currentPage = page;
		}
		int boardListCount = bService.getBoardListCount();
		System.out.println(boardListCount);
		
		PageInfo pi = BoardPagination.getPageInfo(currentPage, boardListCount, 5);
		
		ArrayList<Board> list = bService.selectBoardList(pi);
		
		if(list != null) {
			model.addAttribute("pi", pi);
			model.addAttribute("list", list);
			
			return "boardList";
		} else {
			throw new BoardException("게시글 조회 실패");
		}
		
	}
	
	@RequestMapping("boardWrite.bo")
	public String boardWrite() {
		return "boardWrite";
	}
	
	@RequestMapping("insertBoard.bo")
	public String insertBoard(@ModelAttribute Board b) {
		return null;
	}
	
	@RequestMapping("boardView.bo")
	public String boardView() {
		return "boardView";
	}
}
