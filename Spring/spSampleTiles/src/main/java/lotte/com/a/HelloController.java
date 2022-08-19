package lotte.com.a;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping("login.do")
	public String login() {
		System.out.println("HelloController login.do");		
		return "login.tiles";
	}
	
	
}
