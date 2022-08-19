<%@page import="util.CalUtil"%>
<%@page import="dto.MemberDto"%>
<%@page import="dto.CalendarDto"%>
<%@page import="dao.CalendarDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
Object obj = session.getAttribute("login");
MemberDto mem = null;

if(obj == null){
	%>
	<script type="text/javascript">
		alert("로그인 해 주십시오.");
		location.href = "login.jsp";
	</script>
	<%
}
mem = (MemberDto) obj;
%>

<%
request.setCharacterEncoding("utf-8");

String id = request.getParameter("id");
String title = request.getParameter("title");
String content = request.getParameter("content");

String year = request.getParameter("year");
String month = request.getParameter("month");
String day = request.getParameter("day");
String hour = request.getParameter("hour");
String min = request.getParameter("min");

CalUtil carUtil = new CalUtil();

String rdate = year+carUtil.two(month)+carUtil.two(day)+carUtil.two(hour)+carUtil.two(min);

CalendarDao dao = CalendarDao.getInstance();

boolean isS = dao.addCalandar(new CalendarDto(id, title, content, rdate));
if(isS){
	%>
	<script type="text/javascript">
	alert('일정이 추가되었습니다.');
	location.href = "calendar.jsp";
	</script>
	<%
}
else{
	%>
	<script type="text/javascript">
	alert('추가되지 않았습니다.');
	location.href = "calendar.jsp";
	</script>
	<%
}
%>