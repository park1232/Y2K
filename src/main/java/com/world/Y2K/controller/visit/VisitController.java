package com.world.Y2K.controller.visit;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.world.Y2K.exception.BoardException;
import com.world.Y2K.model.entity.VisitEntity;
import com.world.Y2K.model.vo.PageInfo;
import com.world.Y2K.model.vo.Visit;
import com.world.Y2K.pagination.VisitPagination;
import com.world.Y2K.service.visit.VisitService;

@Controller
public class VisitController {
	
	@Autowired
	private VisitService vService;
	
	@RequestMapping("visit.vi")
	public String visitBoard(@RequestParam(value="page", required=false) Integer page, Model model, @RequestParam(value="userNo", required=false) Long userNo, HttpServletRequest request) {
		if(userNo == null ) {
			
			userNo = (Long)request.getSession().getAttribute("userNo");
		}
		
		int currentPage = 1;
		if(page != null) {
			currentPage = page;
		}
		int visitListCount = vService.getVisitListCount();
		PageInfo pi = VisitPagination.getPageInfo(currentPage, visitListCount, 3);


		
		
		ArrayList<VisitEntity> list = vService.selectVisitList(userNo);
		
		System.out.println(list);
//		model.addAttribute("userNo", userNo);
		if(list != null) {
			model.addAttribute("userNo", userNo);
			model.addAttribute("pi", pi);
			model.addAttribute("list", list);
			
			return "visit/visitBoard";
		} else {
			throw new BoardException("諛⑸챸濡� 議고쉶 �떎�뙣");
		}
	}
	

	
	@RequestMapping("insertVisit.vi")
	public String insertVisit(@ModelAttribute Visit v, HttpSession session, Authentication authentication,@RequestParam(value="userNo", required=false) Long userNo) {
		
		v.setOwn(userNo);
	
		int result = vService.insertVisit(v);
		return null;
	}
	

	@RequestMapping("delete-visit.vi")
	public String deleteVisit(@RequestParam(value="userNo", required=false) Long userNo, Long visitNo, Model model, HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirect){
		System.out.println("visitNo : " + visitNo);
		System.out.println("딜리트 요청들어옴!");
		int result = vService.deleteVisit(visitNo);
		if(result > 0) {
//			HttpSession session = request.getSession();
//			session.setAttribute("userNo2", userNo);
//			redirect.addAttribute("userNo2", userNo);
			System.out.println("여기가 실행된요?");
			model.addAttribute("userNo2", userNo);

			return "redirect:/visit.vi";
		}
		return null;
	}
	

}
