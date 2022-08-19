<%@page import="dto.PdsDto"%>
<%@page import="java.util.List"%>
<%@page import="dao.PdsDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
PdsDao dao = PdsDao.getInstance();
List<PdsDto> list = dao.getPdslist();
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>pdslist</title>
</head>
<body>

<h2>자료실</h2>

<div align="center">
<table border="1">
<col width="50"><col width="100"><col width="400"><col width="50">
<col width="50"><col width="50"><col width="100">

<tr>
	<th>번호</th><th>작성자</th><th>제목</th><th>다운로드</th>
	<th>조회수</th><th>다운수</th><th>작성일</th>
</tr>

<%
for(int i = 0;i < list.size(); i++){
	PdsDto pds = list.get(i);
	%>
	<tr>
		<th><%=i + 1 %></th>
		<td><%=pds.getId() %></td>
		<td>
			<a href="pdsdetail.jsp?seq=<%=pds.getSeq() %>">
				<%=pds.getTitle() %>
			</a>
		</td>
		<td>
			<input type="button" name="btndown" value="다운로드"
				onclick="filedownload('<%=pds.getNewfilename()%>', <%=pds.getSeq() %>)">
		</td>
		<td><%=pds.getReadcount() %></td>
		<td><%=pds.getDowncount() %></td>
		<td><%=pds.getRegdate() %></td>	
	</tr>	
	<%
}
%>
</table>

<br>
<a href="pdswrite.jsp">자료올리기</a>

</div>

<script type="text/javascript">
function filedownload(newfilename, seq) {
	
	location.href = "filedown?newfilename=" + newfilename + "&seq=" + seq;
}
</script>

</body>
</html>





