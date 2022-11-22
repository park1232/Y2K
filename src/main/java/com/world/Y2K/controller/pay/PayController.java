package com.world.Y2K.controller.pay;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.world.Y2K.exception.PaymentException;
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
	public String selectPayList(@RequestParam(value="page", required=false) Integer page, Model model) throws PaymentException {
		
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
			throw new PaymentException("구매 게시글 조회 실패");
		}

	}
	
	@GetMapping("writePurchaes.pa")
	public String test4() {
		return "writePurchaes";	
	}
	
	// 파일 저장소를 만드는 메소드(실제 파일이 들어갈 폴더)
	public String[] addFile(MultipartFile file, HttpServletRequest request) {
		
		String uploadPath = "C:\\Users\\박유진\\Desktop\\uploadFolder/"; 
		
		UUID uuid = UUID.randomUUID();
		
		String originFileName = file.getOriginalFilename();
		String renameFileName = uuid + "_" + originFileName.substring(originFileName.lastIndexOf("."));
		
		File fileFolder = new File(uploadPath + renameFileName);
		
		try {
			file.transferTo(fileFolder);
		} catch (IOException e) {
			System.out.println("파일 전송 에러 : " + e.getMessage());
		}
		
		String[] returnArr = new String[3];
		returnArr[0] = uploadPath;
		returnArr[1] = renameFileName;
		returnArr[2] = originFileName;
		
		System.out.println("파일저장소 나옴?");
		return returnArr;
	}
	
	@RequestMapping("insertPurchaes.pa")
	public String insertPurchaes(@ModelAttribute Product p, @RequestParam("file") MultipartFile file, HttpServletRequest request) throws PaymentException {
		
		
		MultipartFile upload  = file;
				
		ProductPhoto pp = new ProductPhoto();
		
		if(!upload.getOriginalFilename().equals("")) {
			String[] returnArr = addFile(upload, request);
			
			pp.setProductPhotoName(returnArr[2]);
			pp.setProductReNameName(returnArr[1]);
			pp.setProductPhotoPath(returnArr[0]);
			
		}
	
		int result1 = pService.insertBoard(p);
		int result2 = pService.insertPurchaes(pp);		

		System.out.println("나오냐");
		if(result2 > 0 && result1 > 0) {
			return "redirect:purchaes.pa";
		} else {
			throw new PaymentException("구매 게시글 작성이 실패하였습니다.");
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
