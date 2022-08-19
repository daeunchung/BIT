package lotte.com.a;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	public String hello() {
		System.out.println("HelloController hello() " + new Date());
		
		return "hello";		// hello.jsp 로 이동해라!
	}
}






