<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
	Calendar cal = Calendar.getInstance();
	int tyear = cal.get(Calendar.YEAR);
	int tmonth = cal.get(Calendar.MONTH) + 1;
	int tday = cal.get(Calendar.DATE);
	int thour = cal.get(Calendar.HOUR_OF_DAY);
	int tmin = cal.get(Calendar.MINUTE);

	cal.set(Calendar.MONTH, Integer.parseInt(month) - 1);
	// 월 만 세팅을 바꾸어주었음
	%>

	<h2>일정추가</h2>
	<div align="center">
		<!-- 모델 1 구조이기 때문에 -->
		<form action="calwriteAf.jsp" method="post">
			<table class="table table-bordered" style="width: 65%">
				<col width="200">
				<col width="500">

				<tr>
					<th>아이디</th>
					<td><%=mem.getId()%><input type="hidden" name="id"
						value="<%=mem.getId()%>"></td>
				</tr>
				<tr>
					<th>제목</th>
					<td><input type="text" size="60" name="title"></td>
				</tr>

				<tr>
					<th>일정</th>
					<td>
					
					<select name="year">
							<%
							for (int i = tyear - 5; i <= tyear + 5; i++) {
							%>
							<option <%=year.equals(i + "") ? "selected ='selected'" : ""%>
								value="<%=i%>">
								<%=i%>
							</option>
							<%
							}
							%>
					</select>년
			</table>
<!-- 시간 범위 설정할때는 select 로 ,, 아닐까는 date 로 사용하는 것이 깔끔하다 -->

		</form>

	</div>
</body>
</html>