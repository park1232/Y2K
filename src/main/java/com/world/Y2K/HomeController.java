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
