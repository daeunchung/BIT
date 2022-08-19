package lotte.com.a.poll;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PollController {

	Logger logger = LoggerFactory.getLogger(PollController.class);
	
	@Autowired
	PollService service;
	
	@RequestMapping(value = "polllist.do", method = RequestMethod.GET)
	public String polllist(Model model, HttpServletRequest req) {
		logger.info("PollController polllist() " + new Date());
		
		String id = (String)req.getSession().getAttribute("loginId");
		
		List<PollDto> list = service.polllist(id);
		model.addAttribute("plist", list);
		
		return "polllist.tiles";
	}
	
	@RequestMapping(value = "pollmake.do", method = RequestMethod.GET)
	public String pollmake(Model model, HttpServletRequest req) {
		logger.info("PollController pollmake() " + new Date());
		
		String id = (String)req.getSession().getAttribute("loginId");		
		model.addAttribute("id", id);
		
		return "pollmake.tiles";		
	}
	
	@RequestMapping(value = "pollmakeAf.do", method = RequestMethod.GET)
	public String pollmakeAf(PollBean pbean, Model model) {
		logger.info("PollController pollmakeAf() " + new Date());
		model.addAttribute("doc_title", "투표목록");
		
		System.out.println(pbean.toString());
		
		service.makePoll(pbean);
		
		return "redirect:/polllist.do";		
	}
	
	@RequestMapping(value = "polldetail.do", method = RequestMethod.GET)
	public String polldetail(PollDto poll, Model model) {
		logger.info("PollController polldetail() " + new Date());
		
		// 투표주제
		PollDto dto = service.getPoll(poll);
				
		// 투표보기들
		List<PollSubDto> list = service.getPollSubList(poll);
		
		model.addAttribute("poll", dto);
		model.addAttribute("pollsublist", list);
		
		return "polldetail.tiles";
	}
	
	@RequestMapping(value = "polling.do", method = RequestMethod.GET)
	public String polling(Voter voter) {
		logger.info("PollController polling() " + new Date());
		
		service.polling(voter);
		
		return "redirect:/polllist.do";
	}
	
	@RequestMapping(value = "pollresult.do", method = RequestMethod.GET)
	public String pollresult(PollDto poll, Model model) {
		logger.info("PollController pollresult() " + new Date());
		
		// Poll(투표 주제)
		PollDto dto = service.getPoll(poll);
		
		// PollSub(보기들)
		List<PollSubDto> list = service.getPollSubList(poll);
		
		model.addAttribute("poll", dto);
		model.addAttribute("pollsublist", list);
		
		return "pollresult.tiles";		
	}
}






