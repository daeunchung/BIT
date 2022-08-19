<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%
Date nows = new Date();
request.setAttribute("_nows", nows);
%>

<div style="width: 100%; height: 53px; margin-top: 5px; margin-bottom: 5px">
	<div style="width: 100%; height: 100%; clear: both; display:inline-block">
		<div id="_title_image" style="width: 30%; float: left; display: inline">
			<img alt="" src="<%=request.getContextPath() %>/image/titleImage.jpg" style="height: 53px">
		</div>
	
		<div id="_title_today" style="width: 70%; float: left; text-align: right;">
			<div style="position: relative; top: 27px">
				<fmt:formatDate value="${_nows}" var="now" pattern="yyyy/MM/dd"/>
				${now}
			</div>
		</div>
	
	</div>
</div> 





