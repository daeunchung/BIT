<%@page import="lotte.com.a.MemberDto"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String name = (String)request.getAttribute("name");

	List<MemberDto> list = (List<MemberDto>)request.getAttribute("memlist");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<p>name:<%=name %></p>
<input type="text" value="<%=name %>">

<br><br>

<table border="1">
<col width="100"><col width="100"><col width="100"><col width="100">
<tr>
	<th>id</th><th>pw</th><th>name</th><th>email</th>
</tr>
<%
for(int i = 0;i < list.size(); i++){
	MemberDto dto = list.get(i);
%>
	<tr>
		<td><%=dto.getId() %></td>
		<td><%=dto.getPwd() %></td>
		<td><%=dto.getName() %></td>
		<td><%=dto.getEmail() %></td>
	</tr>
<%
}
%>


</table>



<form action="world.do">
이름:<input type="text" name="name">
<br>
나이:<input type="text" name="age">
<br>
<input type="submit" value="world로 이동">
</form>



</body>
</html>




