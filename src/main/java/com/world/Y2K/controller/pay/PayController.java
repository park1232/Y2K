package com.world.Y2K.controller.pay;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PayController {
	
	@GetMapping("/detailpurchaes.pa")
	public String test() {
		return "detailPurchaes";
	}
	
	@GetMapping("payment.pa")
	public String test2() {
		return "payment";
	}
	
	@GetMapping("purchaes.pa")
	public String test3() {
		return "purchaes";
	}
}
