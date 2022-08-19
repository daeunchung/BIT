package lotte.com.a.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import lotte.com.a.dto.PdsDto;
import lotte.com.a.service.PdsService;
import lotte.com.a.util.PdsUtil;

@Controller
public class PdsController {

	Logger logger = LoggerFactory.getLogger(PdsController.class);
	
	@Autowired
	PdsService service;
	
	@RequestMapping(value = "pdslist.do", method = RequestMethod.GET)
	public String pdslist(Model model) {
		logger.info("PdsController pdslist() " + new Date());
		
		model.addAttribute("doc_title", "자료목록");
		
		List<PdsDto> list = service.pdslist();
		model.addAttribute("pdslist", list);
		
		return "pdslist.tiles";
	}
	
	@RequestMapping(value = "pdswrite.do", method = RequestMethod.GET)
	public String pdswrite(Model model) {
		logger.info("PdsController pdswrite() " + new Date());		
		model.addAttribute("doc_title", "자료올리기");
		
		return "pdswrite.tiles";
	}
	
	@RequestMapping(value = "pdsupload.do", method = RequestMethod.POST)
	public String pdsupload(PdsDto pds, 
							@RequestParam(value = "fileload", required = false)
							MultipartFile fileload,
							HttpServletRequest req) {
		
		logger.info("PdsController pdsupload() " + new Date());
		
		// file명을 취득
		String filename = fileload.getOriginalFilename();
		System.out.println("filename:" + filename);
		
		pds.setFilename(filename);
				
		// upload 경로설정
		// server
		String fupload = req.getServletContext().getRealPath("/upload");
		
		// 폴더
	//	String fupload = "d:\\upload";
		
		System.out.println(fupload);
		
		// 파일명 변경
		String newfilename = PdsUtil.getNewFileName(pds.getFilename());
		pds.setNewfilename(newfilename);
		
		File file = new File(fupload + "/" + newfilename);
		
		try {
			
			// 실제로 업로드 
			FileUtils.writeByteArrayToFile(file, fileload.getBytes());	
			
			// DB에 저장
			service.uploadPds(pds);
			
		} catch (IOException e) {			
			e.printStackTrace();
		}		
		
		return "redirect:/pdslist.do";
	}
	
	@RequestMapping(value = "fileDownload.do", method = RequestMethod.GET)
	public String fileDownload(String newfilename, int seq, String filename, 
							Model model, HttpServletRequest req) {
		
		logger.info("PdsController fileDownload() " + new Date());
		
		// 경로
		// server
		String fupload = req.getServletContext().getRealPath("/upload");
		
		// 폴더
	//	String fupload = "d:\\upload";
		
		File downloadFile = new File(fupload + "/" + newfilename);
		
		model.addAttribute("downloadFile", downloadFile);
		model.addAttribute("originalFile", filename);
		model.addAttribute("seq", seq);
		
		return "downloadView";
	}
	
	@RequestMapping(value = "pdsdetail.do", method= {RequestMethod.GET, RequestMethod.POST})
	public String pdsdetail(int seq, Model model) {		
		logger.info("PdsController pdsdetail() " + new Date());
		
		model.addAttribute("doc_title", "자료상세보기");
		// dto 취득
		PdsDto pdsdto = service.getPds(seq);
		model.addAttribute("pds", pdsdto);
		
		return "pdsdetail.tiles";
	}
}





