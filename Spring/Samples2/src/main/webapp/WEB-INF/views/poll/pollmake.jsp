<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
String id = (String)request.getAttribute("id");
%>

<%
Calendar cal = Calendar.getInstance();
int tyear = cal.get(Calendar.YEAR);
int tmonth = cal.get(Calendar.MONTH) + 1;
int tday = cal.get(Calendar.DATE);
System.out.println(tmonth);

%>

<form action="pollmakeAf.do" method="get">

<table class="list_table" style="width: 85%">
<col width="200px"><col width="500px">

<tr>
	<th>아이디</th>
	<td style="text-align: left;">
		<%=id %><input type="hidden" name="id" value="<%=id %>">
	</td>
</tr>
<tr>
	<th>투표기한</th>
	<td style="text-align: left;">
		<select name="syear">
			<%
			for(int i = tyear;i < tyear + 5; i++){
				%>
				<option <%=(tyear + "").equals(i + "")?"selected='selected'":"" %> value="<%=i %>"><%=i %></option>
				<%
			}
			%>
		</select>년&nbsp;
	
		<select name="smonth">
			<%
			for(int i = 1;i <= 12; i++){
				%>
				<option <%=(tmonth + "").equals(i + "")?"selected='selected'":"" %> value="<%=i %>"><%=i %></option>
				<%
			}
			%>
		</select>월&nbsp;
		
		<select name="sday">
			<%
			for(int i = 1;i <= cal.getActualMaximum(Calendar.DAY_OF_MONTH); i++){
				%>
				<option <%=(tday + "").equals(i + "")?"selected='selected'":"" %> value="<%=i %>"><%=i %></option>
				<%
			}
			%>
		</select>일&nbsp;
		
		~
		&nbsp;
		<select name="eyear">
			<%
			for(int i = tyear;i < tyear + 5; i++){
				%>
				<option <%=(tyear + "").equals(i + "")?"selected='selected'":"" %> value="<%=i %>"><%=i %></option>
				<%
			}
			%>
		</select>년&nbsp;
		
		<select name="emonth">
			<%
			for(int i = 1;i <= 12; i++){
				%>
				<option <%=(tmonth + "").equals(i + "")?"selected='selected'":"" %> value="<%=i %>"><%=i %></option>
				<%
			}
			%>
		</select>월&nbsp;
		
		<select name="eday">
			<%
			for(int i = 1;i <= cal.getActualMaximum(Calendar.DAY_OF_MONTH); i++){
				%>
				<option <%=(tday + "").equals(i + "")?"selected='selected'":"" %> value="<%=i %>"><%=i %></option>
				<%
			}
			%>
		</select>일	
	</td>	
</tr>

<tr>
	<th>투표 내용</th>
	<td style="text-align: left;">
		<textarea rows="5" cols="20" name="question" class="form-control"></textarea>
	</td>
</tr>

<tr>
	<th>투표 문항수</th>
	<td style="text-align: left;">
		<select name="itemcount" onchange="pollchange(this)">
			<%
			for(int i = 2;i <= 10; i++){
				%>
				<option <%=(4 + "").equals(i + "")?"selected='selected'":"" %> value="<%=i %>"><%=i %></option>
				<%
			}
			%>
		</select>
	</td>
</tr>
<tr>
	<th>투표 상세 문항</th>
	<td style="text-align: left;">
		<%
		for(int i = 1;i <= 10; i++){
			%>
			<div id="poll<%=i %>">
				<%=(i + "") %>번:<input type="text"name="poll<%=i %>">
			</div>
			<%
		}
		%>
	</td>
</tr>
<tr>
	<td colspan="2">
		<input type="submit" value="투표만들기">
	</td>
</tr>
</table>

</form>

<script type="text/javascript">
$(document).ready(function(){
	
	// 보기 항목을 초기화
	for(i = 5;i <= 10; i++){
		$("#poll" + i).hide();
	}
})


function pollchange( sel ) {
	
	let val = sel.options[sel.selectedIndex].value;
//	alert(val);

	// 초기화
	for(i = 1;i <= 10; i++){
		$("#poll" + i).val("");
		$("#poll" + i).hide();
	}
	
	// 설정한 값만큼 보여준다
	for(i = 1;i <= val; i++){
		$("#poll" + i).show();
	}

}

</script>






