package com.world.Y2K.controller.pay;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.world.Y2K.exception.paymentException;
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
	
	@GetMapping("payment.pa")
	public String test2() {
		return "payment";
	}
	
	@GetMapping("detailpurchaes.pa")
	public String test3() {
		return "detailPurchaes";
	}
}
