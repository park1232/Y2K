package com.world.Y2K.controller.pay;

import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.world.Y2K.exception.paymentException;
import com.world.Y2K.model.dto.Member;
import com.world.Y2K.model.vo.PayPageInfo;
import com.world.Y2K.model.vo.Product;
import com.world.Y2K.model.vo.ProductPhoto;
import com.world.Y2K.pagination.PayPagination;
import com.world.Y2K.service.payment.PaymentService;

@Controller
public class PayController {
	
	@Autowired
	private PaymentService pService;
	
	@RequestMapping("purchaes.pa")
	public String selectPayList(@RequestParam(value="page", required=false) Integer page, Model model) {
		
		int payCurrentPage = 1;
		
		if(page != null) {
			payCurrentPage = page;
		}
		
		int payListCount = pService.getPayListCount();
		PayPageInfo pi = PayPagination.getPageInfo(payCurrentPage, payListCount, 6);
		ArrayList<Product> pList = pService.selectProductList(pi);
		ArrayList<ProductPhoto> photoList = pService.selectPhotoList();
		
		if(pList != null) {
			model.addAttribute("pi", pi);
			model.addAttribute("pList", pList);
			model.addAttribute("photoList", photoList);
			return "purchaes";
		} else {
			throw new paymentException("구매 게시글 조회 실패");
		}

	}
	
	@GetMapping("writePurchaes.pa")
	public String test4() {
		return "writePurchaes";	
	}
	
	// 글 작성, 글 수정, 글 삭제는 관리자만 할 수 있음 게시판 권한 구현
	public String insertBoard(@ModelAttribute Product p, HttpServletRequest request) {
		String userRole = ((Member)request.getAttribute("loginUser")).getRole();
		
		if(userRole.equals("admin")) {
			Long userNo = ((Member)request.getAttribute("loginUser")).getUserNo();
			
			p.setUserNo(userNo);
			
			int result = pService.insertBoard(p);
			
			if(result > 0) {
				return "redirect:purchase.pa";
			} else {
				throw new paymentException("구매 게시글 작성이 실패하였습니다.");
			}
		} else {
			throw new paymentException("관리자만 게시글 작성이 가능합니다.");
		}
	}
	
	// 파일 저장소를 만드는 메소드(실제 파일이 들어갈 폴더)
//	S
	
	@RequestMapping("insertPurchaes.pa")
	public String insertPurchaes(@ModelAttribute Product p, HttpServletRequest request) {
		System.out.println("test2");
		insertBoard(p, request);
		
		return "purchaes.pa";
	}
	
	@GetMapping("payment.pa")
	public String test2() {
		return "payment";
	}
	
	@GetMapping("detailpurchaes.pa")
	public String test3() {
		return "detailPurchaes";
	}	
}
