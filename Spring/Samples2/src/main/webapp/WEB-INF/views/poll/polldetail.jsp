<%@page import="lotte.com.a.poll.PollSubDto"%>
<%@page import="java.util.List"%>
<%@page import="lotte.com.a.poll.PollDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String id = (String)request.getSession().getAttribute("loginId");

PollDto poll = (PollDto)request.getAttribute("poll");
List<PollSubDto> pollsublist = (List<PollSubDto>)request.getAttribute("pollsublist");
%>

<form action="polling.do" method="get">

<table class="list_table" style="width: 95%">
<col width="200"><col width="200">

<tr>
	<th>투표번호</th>
	<td style="text-align: left;">
		<%=poll.getPollid() %>
		<input type="hidden" name="pollid" value="<%=poll.getPollid() %>">
	</td>
</tr>
<tr>
	<th>아이디</th>
	<td style="text-align: left;">
		<%=id %>
		<input type="hidden" name="id" value="<%=id %>">
	</td>
</tr>

<tr>
	<th>투표기한</th>
	<td style="text-align: left;">
		<%=poll.getSdate() %>~<%=poll.getEdate() %>
	</td>
</tr>

<tr>
	<th>투표내용</th>
	<td style="text-align: left;">
		<textarea rows="10" cols="50" name="question"><%=poll.getQuestion() %></textarea>
	</td>
</tr>
<tr>
	<th>보기수</th>
	<td style="text-align: left;"><%=poll.getItemcount() %></td>
</tr>
<tr>
	<th>투표 보기들</th>
	<td style="text-align: left;">
		<%
		for(int i = 0;i < pollsublist.size(); i++){
			PollSubDto pollsub = pollsublist.get(i);
			%>
			<%=i + 1 %>번&nbsp;
			<input type="radio" name="pollsubid" <%=(i + "").equals("0")?"checked='checked'":"" %> value="<%=pollsub.getPollsubid() %>">
			
			<input type="text" name="answer" size="60" value="<%=pollsub.getAnswer() %>" readonly="readonly">
			<br>
			<%
		}
		%>	
	</td>
</tr>
<tr>
	<td colspan="2">
		<input type="submit" value="투표하기">
	</td>
</tr>

</table>
</form>








