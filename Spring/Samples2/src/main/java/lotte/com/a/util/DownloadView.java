package lotte.com.a.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import lotte.com.a.service.PdsService;

public class DownloadView extends AbstractView{

	@Autowired
	PdsService service;
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
	//	System.out.println("DownloadView renderMergedOutputModel()");

		File file = (File)model.get("downloadFile");	// getAttribute
		String originalFile = (String)model.get("originalFile");
		int seq = (Integer)model.get("seq");
		
		// 한글파일명을 설정
		originalFile = URLEncoder.encode(originalFile, "utf-8");
		
		response.setHeader("Content-Disposition", "attachment; filename=\"" + originalFile + "\";");
		response.setHeader("Content-Transfer-Encoding", "binary;");
		response.setHeader("Content-Length", "" + file.length());
		response.setHeader("Pragma", "no-cache;"); 
		response.setHeader("Expires", "-1;");
		
		OutputStream out = response.getOutputStream();
		FileInputStream fis = new FileInputStream(file); 
		
		FileCopyUtils.copy(fis, out);
		
		// 다운로드 회수 증가
		
		if(fis != null) {
			fis.close();
		}
		
	}
	
}






