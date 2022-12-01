package com.world.Y2K.controller.board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.world.Y2K.exception.BoardException;
import com.world.Y2K.model.vo.Board;
import com.world.Y2K.model.vo.Like;
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
	
	//寃뚯떆�뙋 硫붿씤
	@RequestMapping("boardList.bo")
	public String boardList(@RequestParam(value="page", required=false) Integer page, Model model,@RequestParam("userNo")Long userNo) {
		System.out.println("boardList 실행됨 : "+userNo);
		int currentPage = 1;
		if(page != null) {
			currentPage = page;
		}
		int boardListCount = bService.getBoardListCount(userNo);
		System.out.println(boardListCount);
		
		PageInfo pi = BoardPagination.getPageInfo(currentPage, boardListCount, 5);
		
		ArrayList<Board> list = bService.selectBoardList(pi, userNo);
//		model.addAttribute("userNo", userNo);
		if(list != null) {
			model.addAttribute("userNo", userNo);
			model.addAttribute("pi", pi);
			model.addAttribute("list", list);
			
			return "board/boardList";
		} else {
			throw new BoardException("寃뚯떆湲� 議고쉶 �떎�뙣");
		}
		
	}
	
	//寃뚯떆湲� �옉�꽦 View
	@RequestMapping("boardWrite.bo")
	public String boardWrite(Model model ,@RequestParam("userNo") Long userNo) {
//		System.out.println("boardWrite : " + userNo);
		model.addAttribute("userNo", userNo);
		return "board/boardWrite";
	}
	
	//寃뚯떆湲� �옉�꽦
	@RequestMapping(value="insertBoard.bo",method=RequestMethod.POST)
	public String insertBoard(Model model,@RequestParam("category") String cateStr ,@ModelAttribute Board b, HttpSession session, Authentication authentication, @RequestParam(value="userNo", required=false)Long userNo) {		
		return bService.insertBoard(cateStr, b,session,authentication, userNo,model);

	}
	
	//寃뚯떆湲� �긽�꽭
	@RequestMapping("selectBoard.bo")
	public ModelAndView boardView(@RequestParam("bNo") Long bNo, @RequestParam("writer") String writer,
									@RequestParam("page") int page, ModelAndView mv, Authentication authentication, @RequestParam("userNo") Long userNo) {

		Board b = bService.selectBoard(bNo);
		ArrayList<Reply> list = bService.selectReply(bNo);
		int likeCount = bService.likeCount(bNo);
		
		if(b != null) {
			
			mv.addObject("userNo", userNo);
			mv.addObject("b", b);
			mv.addObject("list", list);
			mv.addObject("page", page);
//			mv.addObject("like", bService.likeCheck(like));
			mv.addObject("likeCount", likeCount);
			mv.setViewName("board/boardView");
			return mv;	
		} else {
			throw new BoardException("寃뚯떆湲� �긽�꽭 議고쉶 �떎�뙣");
		}
	}
	
	//寃뚯떆湲� �닔�젙
	@RequestMapping("updateForm.bo")
	public String updateForm( @RequestParam("boardNo") Long bNo, @RequestParam("page") int page, Model model) {
//		HashMap<String, Object> map = new HashMap<>();
//		map.put("bNo", bNo);
//		map.put("own", userNo);
		
		Board b = bService.selectBoard(bNo);
//		model.addAttribute("userNo", userNo);
		model.addAttribute("b", b);
		model.addAttribute("page", page);
		return "board/boardEdit";
	}
	
	@RequestMapping("updateBoard.bo")
	public String updateBoard(@RequestParam("userNo") Long userNo,@ModelAttribute Board b,@RequestParam("page") int page, Model model, HttpSession session, Authentication authentication) {
		
		UserDetailsImpl userDetails = (UserDetailsImpl)authentication.getPrincipal();
		
		
		String boardWriter = (userDetails.getMember()).getNickName();
		
		int result = bService.updateBoard(b);
		
		if(result > 0) {
			model.addAttribute("userNo", userNo);
			model.addAttribute("bNo", b.getBoardNo());
			model.addAttribute("writer", boardWriter);
			model.addAttribute("page", page);
			return "redirect:/boardList.bo";
		} else {
			throw new BoardException("寃뚯떆湲� �닔�젙 �떎�뙣");
		}

	}
	
	//寃뚯떆湲� �궘�젣
	@RequestMapping("deleteForm.bo")
	public String deleteBoard(@RequestParam("boardNo") Long bNo, Model model,@RequestParam(value="userNo", required=false)Long userNo) {
		int result = bService.deletBoard(bNo);
		System.out.println("deleteBoard : " + result);

		if(result > 0) {
			System.out.println("여기가 실행된요?");
			model.addAttribute("userNo", userNo);
			String url = "redirect:/boardList.bo";
			return url;
		} else {
			throw new BoardException("寃뚯떆湲� �궘�젣 �떎�뙣");
		}
	}
	
	//議곌굔�떇 寃��깋
	@RequestMapping("search.bo")
	public String searchBoard(@RequestParam("searchCondition") String condition, Model model,
								@RequestParam("searchValue") String value, @RequestParam(value="page", required=false) Integer page,@RequestParam("userNo") Long userNo) {
		
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("condition", condition);
		map.put("value", value);
		
		int currentPage = 1;
		if(page != null) {
			currentPage = page;
		}
		
		int searchListCount = bService.getSearchListCount(map);
		
		System.out.println(map);
		PageInfo pi = BoardPagination.getPageInfo(currentPage, searchListCount, 5);
		map.put(condition, value);
		map.put("userNo", userNo);
		ArrayList<Board> list = bService.selectSearchList(map, pi);
		
		model.addAttribute("list", list);
		model.addAttribute("pi", pi);
		model.addAttribute("searchCondition", condition);
		model.addAttribute("searchValue", value);
		
		return "board/boardList";

	}
	
	//�뙎湲�
	@RequestMapping("insertReply.bo")
	public void insertReply(@ModelAttribute Reply r, HttpServletResponse response) {
		
		int result = bService.insertReply(r);
		ArrayList<Reply> list = bService.selectReply(r.getRboardNo());
		System.out.println(list);
		
		response.setContentType("application/json; charset=UTF-8");
		GsonBuilder gb = new GsonBuilder();
		GsonBuilder gb2 = gb.setDateFormat("yyyy-MM-dd");
		Gson gson = gb2.create();
		
		try {
			gson.toJson(list, response.getWriter());
		} catch (JsonIOException | IOException e) {
			e.printStackTrace();
		}
	
	
	}
	
	//�뙎湲� �궘�젣
	@RequestMapping("deleteReply.bo")
	public String deleteReply(@RequestParam("replyNo") Long rNo, Model model, @RequestParam("boardNo") Long bNo) {

		int result = bService.deleteReply(rNo);
		if(result > 0) {
			ArrayList<Reply> list = bService.selectReply(bNo); 
			model.addAttribute("list", list);
			return "board/boardView";
		} else {
			throw new BoardException("寃뚯떆湲� �궘�젣 �떎�뙣");
		}
	}
	
	//寃뚯떆湲� 異붿쿇
	@RequestMapping("likeCheck.bo")
	@ResponseBody
	public String likeCheck(@RequestParam("boardNo")Long bNo, HttpSession session, @ModelAttribute Like like, Authentication authentication) {

		UserDetailsImpl userDetails = (UserDetailsImpl)authentication.getPrincipal();
		Long currentUser = (userDetails.getMember()).getUserNo();

		like.setLikeBoardNo(bNo);
		like.setLikeUserNo(currentUser);

		
		int likeCheck = bService.likeCheck(like);
		
		
		if(likeCheck == 0) {
			bService.likeInsert(like);
		} else if(likeCheck == 1) {
			bService.likeDelete(like);
		}
		
		int likeCount = bService.likeCount(bNo);
	
		return likeCount+"";
	
	}
	
}
