package com.world.Y2K.controller.visit;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.world.Y2K.model.vo.Reply;
import com.world.Y2K.service.visit.VisitService;

@Controller
public class VisitController {
	
	@Autowired
	private VisitService vService;
	
	@RequestMapping("visit.vi")
	public String visitBoard() {
		return "visitBoard";
	}
	
	@RequestMapping("insertVisit.vi")
	public String insertVisit(@ModelAttribute Reply r, HttpServletResponse response) {
		int result = vService.insertVisit(r);
		return null;
	}
}
