package lotte.com.a.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lotte.com.a.dto.BbsDto;
import lotte.com.a.dto.BbsParam;
import lotte.com.a.service.BbsService;

@Controller
public class BbsController {

	Logger logger = LoggerFactory.getLogger(BbsController.class);
	
	@Autowired
	BbsService service;
	
	@RequestMapping(value = "bbslist.do", method = { RequestMethod.GET, RequestMethod.POST } )
	public String bbslist(BbsParam param, Model model) {
		logger.info("BbsController bbslist() " + new Date());
		
		int sn = param.getPageNumber();	// 0 1 2 3 4
		int start = 1 + sn * 10;	// 1  11
		int end = (sn + 1) * 10;	// 10 20
		
		param.setStart(start);
		param.setEnd(end);
		
		List<BbsDto> list = service.bbslist(param);
		int len = service.getBbsCount(param);
		
		int bbsPage = len / 10;
		if((len % 10) > 0) {
			bbsPage = bbsPage + 1;
		}
		
		// bbslist
		model.addAttribute("bbslist", list);
		// bbsPage
		model.addAttribute("bbsPage", bbsPage);
		// pageNumber
		model.addAttribute("pageNumber", param.getPageNumber());
		// search
		model.addAttribute("search", param.getSearch());
		// choice
		model.addAttribute("choice", param.getChoice());
		
		return "bbslist";
	}
	
	@RequestMapping(value = "bbswrite.do", method = { RequestMethod.GET, RequestMethod.POST } )
	public String bbswrite() {
		logger.info("BbsController bbswrite() " + new Date());
		return "bbswrite";
	}
	
	@RequestMapping(value = "bbswriteAf.do", method = RequestMethod.POST)
	public String bbswriteAf(BbsDto bbs) {		
		boolean b = service.writeBbs(bbs);
		if(!b) {
			return "bbswrite";
		}
		
		return "redirect:/bbslist.do";
	}
	
	@RequestMapping(value = "bbsdetail.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String bbsdetail(int seq, Model model) {			
		BbsDto bbs = service.getBbs(seq);
		model.addAttribute("bbs", bbs);
		
		return "bbsdetail";
	}
}







