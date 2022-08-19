<%@page import="java.sql.ResultSetMetaData"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>

<h1>mydb Tables</h1>

<pre>
모든 테이블 목록을 출력한다.
</pre>

<%
    Class.forName("com.mysql.cj.jdbc.Driver");

    String url = "jdbc:mysql://localhost:3306/mydb";
    String user = "root";
    String password = "sjdlssj102030";

    Connection conn = DriverManager.getConnection(url, user, password);

    String sql = "show table status";

    PreparedStatement psmt = conn.prepareStatement(sql);

    ResultSet rs = psmt.executeQuery();

    ResultSetMetaData rsmd = rs.getMetaData();	// 컬럼의 정보
    int count = rsmd.getColumnCount();			// 컬럼의 수
%>

<table border="1">
    <tr>
        <%
            for(int i = 1;i < count + 1; i++){
        %>
        <td><%=rsmd.getColumnName(i) %></td>
        <%
            }
        %>
    </tr>
    <%
        while(rs.next()){
    %>
    <tr>
        <%
            for(int i = 1;i < count + 1; i++){
                String cols = rs.getString(i);
        %>
        <td><%=cols %></td>
        <%
            }
        %>
    </tr>
    <%
        }
    %>
</table>

<%
    if(rs != null) rs.close();
    if(psmt != null) psmt.close();
    if(conn != null) conn.close();
%>








</body>
</html>





