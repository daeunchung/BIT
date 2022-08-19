<%@page import="lotte.com.a.dto.PdsDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
List<PdsDto> list = (List<PdsDto>)request.getAttribute("pdslist");
%>

<table class="list_table" style="width: 85%">
<col width="50"><col width="100"><col width="300"><col width="50">
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
			<a href="pdsdetail.do?seq=<%=pds.getSeq() %>">
				<%=pds.getTitle() %>
			</a>
		</td>
		<td>
			<input type="button" name="btndown" value="다운로드"
				onclick="filedownload('<%=pds.getNewfilename()%>', <%=pds.getSeq() %>, '<%=pds.getFilename() %>')">
		</td>
		<td><%=pds.getReadcount() %></td>
		<td><%=pds.getDowncount() %></td>
		<td><%=pds.getRegdate() %></td>	
	</tr>	
	<%
}
%>
</table>

<script>
function filedownload(newfilename, seq, filename) {
	location.href = "fileDownload.do?newfilename=" + newfilename + "&seq=" + seq + "&filename=" + filename;
}

</script>





