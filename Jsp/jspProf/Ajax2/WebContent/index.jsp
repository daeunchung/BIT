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
$(document).ready(function() {
	
	$("button").click(function() {
		
		$.ajax({
			url:"data.json",		// file명, link(http://localhost:8090/)
			type:'get',
			datatype:'json',
			success:function(data){
			//	alert('success');
			//	alert(JSON.stringify(data));
				
			//	alert(data[1].address);
			/*
				for(i = 0;i < data.length; i++){
					$("#demo").append(data[i].name + " ");
					$("#demo").append(data[i].age + " ");
					$("#demo").append(data[i].address + " ");
					$("#demo").append(data[i].phone + "<br>");
				}
			*/			
				$.each(data, function (index, item) {
					$("#demo").append(index + " ");
					$("#demo").append(item.name + " ");
					$("#demo").append(item.age + " ");
					$("#demo").append(item.address + " ");
					$("#demo").append(item.phone + "<br>");
				})		
			
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





