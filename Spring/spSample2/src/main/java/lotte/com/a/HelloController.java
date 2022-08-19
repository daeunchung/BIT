package lotte.com.a;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lotte.com.a.service.MemberService;

@Controller
public class HelloController {
	
	private static Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	@Autowired
	MemberService service;
	
	@RequestMapping("hello")
	public String hello() {
		//System.out.println("HelloController hello() " + new Date());
		logger.info("HelloController hello() " + new Date());
		
		return "hello";		// hello.jsp 로 이동해라!
	}
	
	@RequestMapping(value = "home.do", method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("HelloController home() " + new Date());
		
		String name = "홍길동";		
		model.addAttribute("name", name);	// 짐싸!
		
		List<MemberDto> list = service.allMember();
		model.addAttribute("memlist", list);	
		
		return "home";
	}
	
	@RequestMapping(value = "world.do", method = RequestMethod.GET)
	public String world(String name, int age) {
		logger.info("HelloController world() " + new Date());
		
		System.out.println("name:" + name);
		System.out.println("age:" + age);
		
		return "home";
	}
}






