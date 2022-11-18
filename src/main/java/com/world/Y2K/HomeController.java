package com.world.Y2K;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
//	@Autowired
//	private TestService testService;
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		System.out.println("helloWorld");
		System.out.println("占쎌넅占쎌뵠占쎈샒 占쎌뵠甕곕뜆肉� �몭占�");
		System.out.println("占쎈연嚥∽옙..");
		System.out.println("占쎄쉐�⑨옙");
		System.out.println("占쎌읈占쎈툡占쎈뻸占쎈빍占쎈뼄.....");
		System.out.println("�꽭�긽�뿉...");
		System.out.println("한바퀴 다돌앗다.");
		return "/login/loginPage";
	}
	
	
//	@RequestMapping(value = "/test.do", method = RequestMethod.GET)
//	public List<Test> test() {
//		return testService.test();
////		List<Test> list = testService.test();
////		for(int i = 0 ; i<list.size() ; i++) {
////			System.out.println(list.get(i).toString());
////		}
//		
//	}

	
}
