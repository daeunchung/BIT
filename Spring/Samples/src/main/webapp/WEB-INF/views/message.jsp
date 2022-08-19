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
String process = (String)request.getAttribute("process");
%>

<%
if(process.equals("login")){
	boolean b = (Boolean)request.getAttribute("msg");
	if(b){
		%>
		<script type="text/javascript">
		alert('회원가입을 축하합니다');
		location.href = "login.do";
		</script>	
		<%
	}else{
		%>	
		<script type="text/javascript">
		alert('다시 가입해 주십시오');
		location.href = "regi.do";
		</script>
		<%
	}
}
%>



</body>
</html>




