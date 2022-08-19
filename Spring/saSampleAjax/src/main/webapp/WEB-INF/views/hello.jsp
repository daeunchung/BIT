<%@page import="lotte.com.a.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>

<h2>hello.jsp</h2>

<!-- (1) -->
<%
	MemberDto mem = (MemberDto)request.getAttribute("mem");
%>
number:<%=mem.getNumber() %><br>
name:<%=mem.getName() %><br>
<!-- EL tag, Core tag -->
number:${mem.number}<br>
name:${mem.name}<br>
<br>

<!-- (2) front-end -> back-end -->
<form action="move.do" method="post">
번호:<input type="text" name="number" size="20"><br>
이름:<input type="text" name="name" size="20"><br>
<input type="submit" value="move">	
</form>

<br><br>

<!-- (3) ajax String -> String -->
ID:<input type="text" id="checkid"><br>
<br>
<button type="button" onclick="idCheckFunc()">아이디 첵크</button>

<script type="text/javascript">
function idCheckFunc() {
	
	$.ajax({
		url:"idcheck.do",
		type:"get",
	//	data:"id=" + $("#checkid").val(),
		data:{ id:$("#checkid").val() },
		success:function(data){
			// alert('success');
			alert(data);
		},
		error:function(){
			alert('error');
		}
	})
}
</script>

<br><br>

<!-- 
(4) ajax json(front) -> object(back)
		 object(front) -> json(front) 	 
 -->

name:<input type="text" id="name" value="홍길동"><br>
phone:<input type="text" id="phone" value="123-4567"><br>
e-mail:<input type="text" id="email" value="hgd@naver.com"><br>
birth:<input type="text" id="birth" value="2001/03/15"><br>
<button type="button" id="account">회원가입</button>

<script type="text/javascript">
$("#account").click(function() {
	
	let human = {
			"name":$("#name").val(),
			"phone":$("#phone").val(),
			"email":$("#email").val(),
			"birth":$("#birth").val()			
	};
	
	$.ajax({
			url:"account.do",
			type:"post",
			dataType:'json',
			data:human,
			async:true,
			success:function( obj ){
				// alert('success');
				// alert( JSON.stringify(obj) );
				
				alert(obj.msg);
				
				alert(obj.list[1].number);
				alert(obj.list[1].name);
				
			},
			error:function(){
				alert('error');
			}
	})
	
	
	
});


</script>


</body>
</html>




