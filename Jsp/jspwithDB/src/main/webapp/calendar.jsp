<%@ page import="com.example.jspwithdb.dto.MemberDto" %>
<%@ page import="com.example.jspwithdb.dto.CalendarDto" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Calendar" %>
<%@ page import="com.example.jspwithdb.dao.CalendarDao" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%
    Object obj = session.getAttribute("login");   //loginAf의 setAttribute에 "login"이라고 해놨으므로
    MemberDto mem = null;
    if(obj == null){   //세션이 없어졌을 때
%>
<script>
    alert('로그인해주십시오');
    location.href = "login.jsp";
</script>
<%
    }
    mem = (MemberDto)obj;
%>

<%!
    //문자열 검사, 비었거나 빈 문자열일땐 true 리턴
    public boolean nvl(String msg){
		return msg == null || msg.trim().equals("")?true:false;
    }

	//1~9 -> 일때 앞에 0 붙여야함
	public String two(String msg){
		return msg.trim().length() < 2?"0" + msg.trim():msg.trim();
    }

	//일별 일정
	public String callist(int year, int month, int day){
		String str="";
		str += String.format("&npsp:<a href='callist.jsp?year=%d&month=%d&day=%d'>",
                                            year, month, day);
		str += String.format("%2d",day);
		str += "</a>";
		return str;
    }

	public String showPen(int year, int month, int day){
		String str = "";
		String image = "<img src='image/pen2.png' width='18px' height='18px'>";
		str = String.format("<a href='calwrite.jsp?year=%d&month=%d&day=%d'>%s</a>",
                                    year, month, day, image);
		return str;
    }

	// CGV 에서 6시까지 영화보기로 하였음 -> CGV 에서 6시...

	public String dot3(String msg){
		String str = "";
		if(msg.length() >= 10) {
			str = msg.substring(0,10);
			str += "...";
        } else {
			str = msg.trim();
        }
		return str;
    }

	public String makeTable(int year, int month, int day, List<CalendarDto> list){
        String str = "";
		// 202276 -> 20220706
        String dates = (year + "") + two(month + "") + two(day + "");
		str += "<table>";
		for(CalendarDto dto : list){
			if(dto.getRdate().substring(0,8).equals(dates)){
				str += "<tr>";
                str += "    <td style='padding:0px; border:1; background-color:white; border-color:blue; radius:3'>";
                str += "      <a href='caldetail.jsp?seq=" + dto.getSeq() + "'>";
                str += "        <font style='font-size:10px'>";
				str +=              dot3(dto.getTitle());
				str += "        </font>";
                str +=        "</a>";
				str += "    </td>";
				str += "</tr>";
            }
        }
		str += "</table>";
		return str;
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
		}
	</style>
</head>
<body>
	<h2>일정관리</h2>
	<%
		Calendar cal = Calendar.getInstance();

		cal.set(Calendar.DATE, 1);
		String syear = request.getParameter("year");
		String smonth = request.getParameter("month");
		// String sday = request.getParameter("day");

		int year = cal.get(Calendar.YEAR);
		if(nvl(syear) == false){ // 넘어온 데이터가 있었을 때
			year = Integer.parseInt(syear);
		}

		int month = cal.get(Calendar.MONTH) + 1;
		if(nvl(smonth) == false){ // 넘어온 데이터가 있었을 때
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

		cal.set(year, month - 1, 1);

		//요일
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		//<<year--
		String pp = String.format("<a href='%s?year=%d&month=%d'><img src='left.gif' width=20px height=20px></a>",
				                  "calendar.jsp", year-1,month);

		// < month--
		String p = String.format("<a href='%s?year=%d&month=%d'><img src='prec.gif' width=20px height=20px></a>",
				"calendar.jsp", year,month-1);

		// > month++
		String n = String.format("<a href='%s?year=%d&month=%d'><img src='next.gif' width=20px height=20px></a>",
				"calendar.jsp", year,month+1);

		// >> year++
		String nn = String.format("<a href='%s?year=%d&month=%d'><img src='last.gif' width=20px height=20px></a>",
				"calendar.jsp", year+1, month);

		CalendarDao dao = CalendarDao.getInstance();
		List<CalendarDto> list = dao.getCalendarList(mem.getId(), year + two(month + ""));
	%>

<div align="center">
	<table class="table table-bordered" style="width:65%">
	<col width="100"><col width="100"><col width="100"><col width="100">
	<col width="100"><col width="100"><col width="100">
	<tr>
		<td colspan="7" align="center">
			<%=pp %>&nbsp;&nbsp;<%=p %>&nbsp;&nbsp;
			&nbsp;&nbsp;
			<font color="black" style="font-size: 50px; font-family: fantasy;">
				<%=String.format("%d년&nbsp;&nbsp;%d월", year, month)%>
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
				for (int i = 0; i < dayOfWeek; i++) {
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