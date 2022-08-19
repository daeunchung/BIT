<%@page import="dto.PdsDto"%>
<%@page import="dao.PdsDao"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="java.io.File"%>
<%@page import="java.io.IOException"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%!
// 실제 파일 업로드를 처리하는 함수
public String processUploadFile(FileItem fileItem, String newfilename, String dir)throws IOException{
	
	String f = fileItem.getName();
	long sizeOfBytes = fileItem.getSize();
	
	String fileName = "";
	
	// 업로드한 파일이 정상의 경우
	if(sizeOfBytes > 0){			//	d:\\tmp\\abc.txt
		int idx = f.lastIndexOf("\\");
		if(idx == -1){				//	d:/tmp/abc.txt
			idx = f.lastIndexOf("/");
		}
		fileName = f.substring(idx + 1);	// abc.txt
		
		try{
			File uploadfile = new File(dir, newfilename); // 변환된 파일명
			
			fileItem.write(uploadfile);	// 실제로 업로드 부분
		
		}catch(Exception e){
			e.printStackTrace();
		}			
	}
	
	return fileName;
}
%>

<%
// tomcat(web server) 올리기 <- 실무
String fupload = application.getRealPath("/upload");

System.out.println("파일업로드 경로:" + fupload);

// 지정 폴더에 올리기
// String fupload = "d:\\tmp";

int yourMaxRequestSize = 100 * 1024 * 1024;	// 1M
int yourMaxMemorySize = 100 * 1024;			// 1k

// form field에 데이터
String id = "";
String title = "";
String content = "";

// file 데이터
String filename = "";
String newfilename = "";

boolean isMultipart = ServletFileUpload.isMultipartContent(request);
if(isMultipart){
	
	// FileItem 생성하는 class
	DiskFileItemFactory factory = new DiskFileItemFactory();
	
	factory.setSizeThreshold(yourMaxMemorySize);
	factory.setRepository(new File(fupload));
	
	ServletFileUpload upload = new ServletFileUpload(factory);
	upload.setSizeMax(yourMaxRequestSize);
	
	
	List<FileItem> items = upload.parseRequest(request);
	Iterator<FileItem> it = items.iterator();
	
	while(it.hasNext()){
		FileItem item = it.next();
		
		if(item.isFormField()){	// id, title, content
			if(item.getFieldName().equals("id")){
				id = item.getString("utf-8");
			}
			else if(item.getFieldName().equals("title")){
				title = item.getString("utf-8");
			}
			else if(item.getFieldName().equals("content")){
				content = item.getString("utf-8");
			}
		}
		else{	// file
			
			if(item.getFieldName().equals("fileload")){
				
				// 확장자명
				String fileName = item.getName();			// abc.txt
				int lastInNum = fileName.lastIndexOf(".");	// 3
				String exName = fileName.substring(lastInNum); // .txt
				
				// 새로운 파일명
				newfilename = (new Date().getTime()) + ""; // 3243242342
				newfilename = newfilename + exName;		// 3243242342.txt
				
				filename = processUploadFile(item, newfilename, fupload);
			}			
		}				
	}	
	
}else{
	System.out.println("Multipart 이 아님");
}

// DB에 저장
PdsDao dao = PdsDao.getInstance();
boolean isS = dao.writePds(new PdsDto(id, title, content, filename, newfilename));
if(isS){
	%>
	<script>
	alert('파일 업로드 성공!');
	location.href = "pdslist.jsp";
	</script>
	<%
}else{
	%>
	<script>
	alert('파일 업로드 실패~');
	location.href = "pdswrite.jsp";
	</script>
	<%
}
%>




















  