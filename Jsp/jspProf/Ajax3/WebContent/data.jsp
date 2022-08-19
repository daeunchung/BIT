<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// DB
String name = "홍길동";
int age = 24;
String birth = "09/03/12";

String str = "{ \"name\":\"" + name + "\", \"age\":" + age + ", \"birth\":\"" + birth + "\" }"; 

out.println(str);
%>
