package lotte.com.a;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import lotte.com.a.dto.Human;
import lotte.com.a.dto.MemberDto;

@Controller
public class HelloController {

	static Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	// (1) back-end -> front-end
	@RequestMapping(value = "hello.do", method = RequestMethod.GET)
	public String hello(Model model) {
		logger.info("HelloController hello() " + new Date());
				
		MemberDto mem = new MemberDto(1001, "홍길동");
		model.addAttribute("mem", mem);
		
		return "hello";		
	}
	
	// (2) front-end -> back-end 
	@RequestMapping(value = "move.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String move(Model model, MemberDto dto) { // IoC
		logger.info("HelloController move() " + new Date());
		
		System.out.println("number:" + dto.getNumber() + " name:" + dto.getName());
		model.addAttribute("mem", dto);		
		
		return "hello";		
	}
	
	// (3) ajax String -> String
	@ResponseBody
	@RequestMapping(value = "idcheck.do", 
			method = {RequestMethod.GET, RequestMethod.POST}, 
				produces = "application/String; charset=utf-8")
	public String idcheck(String id) {
		logger.info("HelloController idcheck() " + new Date());
		
		System.out.println("id:" + id);
		
		String str = "오케이";
				
		return str;		
	}
	
	// (4) ajax json(front) -> object(back) object(back) -> json(front)
	@ResponseBody
	@RequestMapping(value = "account.do", method = {RequestMethod.GET, RequestMethod.POST})
	public Map<String, Object> account(Human h){
		logger.info("HelloController account() " + new Date());		
		System.out.println(h.toString());
		
		// db
		
		// list
		List<MemberDto> list = new ArrayList<>();
		list.add(new MemberDto(1, "홍길동"));
		list.add(new MemberDto(2, "성춘향"));
		
		// String
		String message = "안녕하세요";
		
		Map<String, Object> map = new HashMap<>();
		map.put("list", list);
		map.put("msg", message);				
		
		return map;
	}
	
}






