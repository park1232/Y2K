package com.world.Y2K.controller.visit;

import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.world.Y2K.exception.BoardException;
import com.world.Y2K.exception.VisitException;
import com.world.Y2K.model.vo.PageInfo;
import com.world.Y2K.model.vo.Reply;
import com.world.Y2K.model.vo.Visit;
import com.world.Y2K.pagination.VisitPagination;
import com.world.Y2K.service.visit.VisitService;

@Controller
public class VisitController {
	
	@Autowired
	private VisitService vService;
	
	@RequestMapping("visit.vi")
	public String visitBoard(@RequestParam(value="page", required=false) Integer page, Model model, @RequestParam("userNo")Long userNo) {
		
		int currentPage = 1;
		if(page != null) {
			currentPage = page;
		}
		int visitListCount = vService.getVisitListCount();
		PageInfo pi = VisitPagination.getPageInfo(currentPage, visitListCount, 3);
		
		ArrayList<Visit> list = vService.selectVisitList();
		
		System.out.println(list);
		model.addAttribute("userNo", userNo);
		if(list != null) {
			model.addAttribute("pi", pi);
			model.addAttribute("list", list);
			
			return "visit/visitBoard";
		} else {
			throw new BoardException("諛⑸챸濡� 議고쉶 �떎�뙣");
		}
	}
	
	
	@RequestMapping("insertVisit.vi")
	public String insertVisit(@ModelAttribute Visit v, HttpSession session, Authentication authentication) {

	
		int result = vService.insertVisit(v);
		return null;
	}
}
