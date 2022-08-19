<%@page import="util.CalUtil"%>
<%@page import="dao.CalendarDao"%>
<%@page import="java.util.Calendar"%>
<%@page import="dto.CalendarDto"%>
<%@page import="java.util.List"%>
<%@page import="dto.MemberDto"%>
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

<%!
/*
//문자열검사 -> 빈 문자열인 경우 true 리턴
public boolean nvl(String msg){
	return msg == null || msg.trim().equals("")?true:false;
}

//1~9일 때 앞에 0붙이는 메서드
public String two(String msg){
	return msg.trim().length() < 2 ? "0"+msg.trim() : msg.trim();
}

//날짜
public String callist(int year, int month, int day){
	String str = "";
	
	str += String.format("&nbsp;<a href='callist.jsp?year=%d&month=%d&day=%d'>", year, month, day);
	str += String.format("%2d", day);
	str += "</a>";
	
	return str;
}

//pen 아이콘
public String showPen(int year, int month, int day){
	String str = "";
	
	String image = "<img src='image/pen2.png' width='18px' height='18px'>";
	str = String.format("<a href='calwrite.jsp?year=%d&month=%d&day=%d'>%s</a>", year, month, day, image);
	
	return str;
}

//
public String dot3(String msg){
	String str = "";
	
	if(msg.length() >= 10){
		str = msg.substring(0, 10);
		str += "...";
	}
	else{
		str = msg.trim();
	}
	
	return str;
}

//
public String makeTable(int year, int month, int day, List<CalendarDto> list){
	String str = "";
	
	String dates = (year+"")+two(month+"")+two(day+"");
	
	str += "<table>";
	for(CalendarDto dto : list){
		if(dto.getRdate().substring(0, 8).equals(dates)){
			str += "<tr>";
			str += "	<td style='padding:0px;border:1;background-color:white;border-color:blue;radius:3'>";
			str += "		<a href='caldetail.jsp?seq="+dto.getSeq()+"'>";
			str += "			<font style='font-size:10px'>";
			str += 					dot3(dto.getTitle());
			str += "			</font>";
			str += "		</a>";
			str += "	</td>";
			str += "</tr>";
		}
	}
	
	str += "</table>";
	
	return str;
}
*/
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

<style type="text/css">
th{
	background-color: #00a2e8;
}
</style>

</head>
<body>

<h2>일정관리</h2>

<%
	CalUtil carUtil = new CalUtil();
	
	Calendar cal = Calendar.getInstance();
	cal.set(Calendar.DATE, 1);
	
	String syear = request.getParameter("year");
	String smonth = request.getParameter("month");
	
	int year = cal.get(Calendar.YEAR);
	if(carUtil.nvl(syear) == false){
		year = Integer.parseInt(syear);
	}
	
	int month = cal.get(Calendar.MONTH) + 1;
	if(carUtil.nvl(smonth) == false){
		month = Integer.parseInt(smonth);
	}
	
	if(month < 1){
		month = 12;
		year--;
	}
	if(month > 12){
		month = 1;
		year++;
	}
	
	cal.set(year, month-1, 1);
	
	//요일
	int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
	
	String pp = String.format("<a href='%s?year=%d&month=%d'><img src='image/left.gif' width='20px' height='20px'></a>", "calendar.jsp", year-1, month);
	String p = String.format("<a href='%s?year=%d&month=%d'><img src='image/prec.gif' width='20px' height='20px'></a>", "calendar.jsp", year, month-1);
	String n = String.format("<a href='%s?year=%d&month=%d'><img src='image/next.gif' width='20px' height='20px'></a>", "calendar.jsp", year, month+1);
	String nn = String.format("<a href='%s?year=%d&month=%d'><img src='image/last.gif' width='20px' height='20px'></a>", "calendar.jsp", year+1, month);
	
	CalendarDao dao = CalendarDao.getInstance();
	List<CalendarDto> list = dao.getCalendarList(mem.getId(), year+carUtil.two(month+""));
	
%>

<div align="center">
<table class="table table-bordered" style="width:65%">
<col width="100"><col width="100"><col width="100"><col width="100"><col width="100"><col width="100"><col width="100">

<tr>
	<td colspan="7" align="center">
		<%=pp %>&nbsp;&nbsp;<%=p %>&nbsp;&nbsp;
		&nbsp;&nbsp;
		<font color="black" style="font-size: 50px; font-family: fantasy">
			<%=String.format("%d년&nbsp;&nbsp;%d월", year, month) %>
		</font>
		&nbsp;&nbsp;
		<%=n %>&nbsp;&nbsp;<%=nn %>&nbsp;&nbsp;
	</td>
</tr>

<tr height="50" style="background-color: #f0f0f0; color: white;">
	<th class="text-center">일</th>
	<th class="text-center">월</th>
	<th class="text-center">화</th>
	<th class="text-center">수</th>
	<th class="text-center">목</th>
	<th class="text-center">금</th>
	<th class="text-center">토</th>
</tr>

<tr height="100" align="left" valign="top">
<%

//달력 빈칸 표시
for(int i=1; i<dayOfWeek; i++){
	%>
	<td style="background-color: #cecece">&nbsp;</td>
	<%
}

//달력 날짜 표시
int lastday = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
for(int i=1; i<=lastday; i++){
	%>
	<td>
		<%=carUtil.callist(year, month, i) %>&nbsp;&nbsp;<%=carUtil.showPen(year, month, i) %>
		<%=carUtil.makeTable(year, month, i, list) %>
	</td>
	<%
	
	if((i+dayOfWeek-1)%7 == 0 && i != lastday){
		%>
		</tr>
		<tr height="100" align="left" valign="top">
		<%
	}
}

//밑쪽 빈칸
cal.set(Calendar.DATE, lastday);
int weekday = cal.get(Calendar.DAY_OF_WEEK);
for(int i=0; i<7-weekday; i++){
	%>
	<td style="background-color: #cecece">&nbsp;</td>
	<%
}
%>

</tr>

</table>
</div>

</body>
</html>