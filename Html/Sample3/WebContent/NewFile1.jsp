<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String hobby[] = request.getParameterValues("hobby");

for(int i = 0;i < hobby.length; i++){
	System.out.println(hobby[i]);	
}

String car = request.getParameter("car");
System.out.println(car);


%>    

    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>