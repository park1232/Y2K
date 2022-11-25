package com.world.Y2K.controller.board;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.world.Y2K.exception.BoardException;
import com.world.Y2K.model.dto.Member;
import com.world.Y2K.model.vo.Board;
import com.world.Y2K.model.vo.PageInfo;
import com.world.Y2K.model.vo.Reply;
import com.world.Y2K.pagination.BoardPagination;
import com.world.Y2K.service.board.BoardService;
import com.world.Y2K.service.login.auth.UserDetailsImpl;

@SessionAttributes("loginUser")
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
			
			return "board/boardList";
		} else {
			throw new BoardException("게시글 조회 실패");
		}
		
	}
	
	@RequestMapping("boardWrite.bo")
	public String boardWrite() {
		return "/board/boardWrite";
	}
	
	@RequestMapping("insertBoard.bo")
	public String insertBoard(@RequestParam("category") String cateStr ,@ModelAttribute Board b, HttpSession session, Authentication authentication) {
		
		UserDetailsImpl userDetails = (UserDetailsImpl)authentication.getPrincipal();
		
		Long boardWriter = (userDetails.getMember()).getUserNo();

		String category = null;
		switch(cateStr) {
			case "😳잡담" : category = "A"; break;
			case "😁유머" : category = "B"; break;
			case "📟정보" : category = "C"; break;
			case "💛기타" : category = "D"; break;
		}

		b.setBoardWriter(boardWriter);
		b.setBoardCateId(category);
		b.setBoardTypeId("B");
		
		int result = bService.insertBoard(b);
		
		System.out.println(b);
		
		if(result > 0) {
			return "redirect:boardList.bo";
		} else {
			throw new BoardException("게시글 등록 실패");
		}
	}
	
	@RequestMapping("selectBoard.bo")
	public ModelAndView boardView(@RequestParam("bNo") int bNo, @RequestParam("writer") String writer,
									@RequestParam("page") int page, HttpSession session, ModelAndView mv) {
		
		Board b = bService.selectBoard(bNo);
		ArrayList<Reply> list = bService.selectReply(bNo);
		
		if(b != null) {
			mv.addObject("b", b);
			mv.addObject("list", list);
			mv.addObject("page", page);
			mv.setViewName("board/boardView");
			return mv;	
		} else {
			throw new BoardException("게시글 상세 조회 실패");
		}

	}
	
	
	@RequestMapping("updateForm.bo")
	public String updateForm(@RequestParam("boardNo") int bNo, @RequestParam("page") int page, Model model) {
		Board b = bService.selectBoard(bNo);
		model.addAttribute("b", b);
		model.addAttribute("page", page);
		return "board/boardEdit";
	}

	

}
