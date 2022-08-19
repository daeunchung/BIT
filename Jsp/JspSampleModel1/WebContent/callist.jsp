<%@page import="util.calUtil"%>
<%@page import="dto.CalendarDto"%>
<%@page import="java.util.List"%>
<%@page import="dao.CalendarDao"%>
<%@page import="dto.MemberDto"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%!
// Date -> String
public String toDates(String mdate){
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 hh시 mm분");	
	
	String s = mdate.substring(0, 4) + "-"  // yyyy
			 + mdate.substring(4, 6) + "-"	// MM
			 + mdate.substring(6, 8) + " "  // dd
			 + mdate.substring(8, 10) + ":" // hh
			 + mdate.substring(10, 12) + ":00";	// mm:ss
	Timestamp d = Timestamp.valueOf(s);
			 
	return sdf.format(d);		 
}		
%>    


<%
MemberDto mem = (MemberDto)session.getAttribute("login");
if(mem == null){
%>  
	<script>
	alert("로그인 해 주십시오");
	location.href = "login.jsp";
	</script>	
<%
}
%>  

<%
String year = request.getParameter("year");
String month = request.getParameter("month");
String day = request.getParameter("day");

String dates = year + calUtil.two(month + "") + calUtil.two(day + "");

CalendarDao dao = CalendarDao.getInstance();
List<CalendarDto> list = dao.getDayList(mem.getId(), dates);

for(int i = 0;i < list.size(); i++){
	CalendarDto c = list.get(i);
	System.out.println(c.toString());
}
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

<style type="text/css">
th{
	background-color: #00a2e8;
	color: white;
}
</style>
</head>
<body>

<h2><%=year %>년 <%=month %>월 <%=day %>일 일정</h2>

<hr>

<div align="center">

<table class="table table-bordered" style="width: 65%">
<col width="100"><col width="300"><col width="450"><col width="50">

<tr>
<th>번호</th><th>시간</th><th>제목</th><th>삭제</th>
</tr>

<%
for(int i = 0;i < list.size(); i++){
	CalendarDto dto = list.get(i);
	%>
	<tr>
		<td><%=i + 1 %></td>
		<td><%=toDates(dto.getRdate()) %></td>
		<td>
			<a href="caldetail.jsp?seq=<%=dto.getSeq() %>">
				<%=dto.getTitle() %>
			</a>
		</td>
		<td>
			<form action="caldel.jsp" method="post">
				<input type="hidden" name="seq" value="<%=dto.getSeq() %>">
				<input type="submit" value="일정삭제">
			</form>
		</td>	
	</tr>
	<%
}	
%>
</table>
</div>



</body>
</html>











