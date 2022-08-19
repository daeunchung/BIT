<%@page import="lotte.com.a.dto.PdsDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
PdsDto pds = (PdsDto)request.getAttribute("pds");
%>

<table class="list_table" style="width: 85%">
<colgroup>
	<col width="200"><col width="500">
</colgroup>

<tr>
	<th>아이디</th>
	<td style="text-align: left;"><%=pds.getId() %></td>
</tr>

<tr>
	<th>제목</th>
	<td style="text-align: left;"><%=pds.getTitle() %></td>
</tr>

<tr>
	<th>다운로드</th>
	<td style="text-align: left;">
		<input type="button" name="btnDown" value="다운로드"
			onclick="filedownload('<%=pds.getNewfilename()%>', <%=pds.getSeq() %>, '<%=pds.getFilename() %>')">
	</td>
</tr>

<tr>
	<th>조회수</th>
	<td style="text-align: left;"><%=pds.getReadcount() %></td>
</tr>

<tr>
	<th>다운수</th>
	<td style="text-align: left;"><%=pds.getDowncount() %></td>
</tr>

<tr>
	<th>파일명</th>
	<td style="text-align: left;"><%=pds.getFilename() %></td>
</tr>

<tr>
	<th>등록일</th>
	<td style="text-align: left;"><%=pds.getRegdate() %></td>
</tr>

<tr>
	<th>내용</th>
	<td style="text-align: left;">
		<textarea rows="10" cols="50" class="form-control"><%=pds.getContent() %></textarea>
	</td>
</tr>
</table>

<!-- 수정하기 -->
<div id="buttons_wrap">
		<button type="button" class="btn btn-primary" onclick="">수정하기</button>
</div>

<script>
function filedownload(newfilename, seq, filename) {
	location.href = "fileDownload.do?newfilename=" + newfilename + "&seq=" + seq + "&filename=" + filename;
}
</script> 













