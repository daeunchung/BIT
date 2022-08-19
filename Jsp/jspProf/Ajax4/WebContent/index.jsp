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

<p id="demo"></p>
<br>
<button type="button">버튼</button>

<script type="text/javascript">
$(function () {

	$("button").click(function() {
		
		$.ajax({
			url:"./hello",
			type:"get",
		//	data:"id=abc&pwd=123",
			data:{ "id":"abc", "pwd":"123" },
			success:function(data){
			//	alert('success');				
			//	alert(JSON.stringify(data));
			
			// String
			// alert(data.str);
			
			// Map
			//	alert(JSON.stringify(data));
			//	alert(data.map.title);
			//	alert(data.map.content);
			
				
			//	alert(JSON.stringify(data));
				alert(data.list[0].name);
				
			},
			error:function(){
				alert('error');
			}
		});
		
	});
	
});
</script>


</body>
</html>





