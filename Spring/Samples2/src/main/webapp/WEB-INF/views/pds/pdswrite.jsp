<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<form action="pdsupload.do" name="frmForm" id="frm" method="post" enctype="multipart/form-data">

<table class="list_table" style="width: 85%">
<col width="200"><col width="500">

<tr>
	<th>아이디</th>
	<td style="text-align: left;">
		<input type="text" class="form-control" name="id" value="" size="50">
	</td>
</tr>
<tr>
	<th>제목</th>
	<td style="text-align: left;">
		<input type="text" class="form-control" name="title" size="50">
	</td>
</tr>
<tr>
	<th>파일 업로드</th>
	<td style="text-align: left;">
		<input type="file" name="fileload" style="width: 350px">
	</td>
</tr>
<tr>
	<th>내용</th>
	<td style="text-align: left;">
		<textarea rows="10" cols="50" class="form-control" name="content"></textarea>
	</td>
</tr>

<tr align="center">
	<td colspan="2">
		<button type="button" class="btn btn-primary">자료올리기</button>
	</td>
</tr>
</table>

</form>

<script>
$("button").click(function () {
	
	// 빈칸 첵크
	
	$("#frm").submit();
});
</script>









