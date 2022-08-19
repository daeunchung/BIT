<%@page import="lotte.com.a.util.PollUtil"%>
<%@page import="lotte.com.a.poll.PollDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<%
List<PollDto> plist = (List<PollDto>)request.getAttribute("plist");
%>

<table class="list_table" style="width: 95%">
<col width="50"><col width="50"><col width="300"><col width="100">
<col width="100"><col width="100"><col width="50"><col width="50">
<col width="100">

<tr>
	<th>번호</th><th>아이디</th><th>투표제목</th><th>결과</th>
	<th>시작일</th><th>종료일</th><th>보기수</th><th>투표회수</th>
	<th>등록일</th>
</tr>
<%
	for(int i = 0;i < plist.size(); i++){
		PollDto poll = plist.get(i);
		%>
		<tr bgcolor="#aabbcc">
			<td><%=i + 1 %></td>
			<td><%=poll.getId() %></td>
			
			<%
			boolean isS = poll.isVote();
			
			// 투표했음(<-투표를 못하게 한다)
			if(isS == true || PollUtil.isEnd(poll.getEdate()) == true){
				%>
				<td>[마감]<%=poll.getQuestion() %></td> 				
				<%
			}			
			// 투표안했음
			else{
				%>
				<td>
					<a href="polldetail.do?pollid=<%=poll.getPollid() %>">
						<%=poll.getQuestion() %>
					</a>
				</td>	
				<%
			}			
			%>
			
			<td>
			<%
			if(isS == true || PollUtil.isEnd(poll.getEdate()) == true){
				%>
				<a href="pollresult.do?pollid=<%=poll.getPollid() %>">결과</a>
				<%
			}else{
				%>
				<img alt="" src="image/pen.gif">
				<%
			} 
			%>				
			</td>
			
			<td><%=poll.getSdate() %></td>
			<td><%=poll.getEdate() %></td>
			<td><%=poll.getItemcount() %></td>
			<td><%=poll.getPolltotal() %></td>
			<td><%=poll.getRegdate() %></td>
		</tr>
		<%
	}
%>

</table>







