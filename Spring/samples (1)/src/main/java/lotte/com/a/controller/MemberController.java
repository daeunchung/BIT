package lotte.com.a.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import lotte.com.a.dto.MemberDto;
import lotte.com.a.service.MemberService;

@Controller
public class MemberController {
	
	Logger logger = LoggerFactory.getLogger(MemberController.class);

	@Autowired
	MemberService service;
	
	@RequestMapping(value = "login.do", method = RequestMethod.GET)
	public String login() {
		logger.info("MemberController login() " + new Date());		
		return "login";
	}	
	
	@RequestMapping(value = "regi.do", method = RequestMethod.GET)
	public String regi() {
		logger.info("MemberController regi() " + new Date());		
		return "regi";
	}
	
	@ResponseBody
	@RequestMapping(value = "idcheck.do", method = { RequestMethod.GET, RequestMethod.POST } )
	public String idcheck(String id) {
		logger.info("MemberController idcheck() " + new Date());
		
		String str = service.getId(id);
		return str;
	}
	
	@RequestMapping(value = "addmember.do", method = { RequestMethod.GET, RequestMethod.POST } )
	public String addmember(Model model, MemberDto mem) {
		logger.info("MemberController addmember() " + new Date());
		
		boolean b = service.addmember(mem);
		/*if(b) {
			// login으로 이동
		}else {
			// message.jsp
		}*/
		
		model.addAttribute("msg", b);
		model.addAttribute("process", "login");
				
		return "message";
	}
	
	@RequestMapping(value = "loginAf.do", method = { RequestMethod.GET, RequestMethod.POST } )
	public String loginAf(HttpServletRequest req, MemberDto dto) {
		logger.info("MemberController loginAf() " + new Date());
		
		MemberDto mem = service.login(dto);
		
		if(mem != null) {
			req.getSession().setAttribute("login", mem);
		//	req.getSession().setMaxInactiveInterval(60 * 60 * 2);
			
			System.out.println("로그인 성공!!!");
			
			// 게시판 이동
			// return "forward:/bbslist.do";
			return "redirect:/bbslist.do";
			
		}else {
			return "login";
		}		
	}
}




