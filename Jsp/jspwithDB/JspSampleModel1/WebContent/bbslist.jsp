<%@page import="java.util.List"%>
<%@ page import="com.example.jspwithdb.dto.BbsDto" %>
<%@ page import="com.example.jspwithdb.dao.BbsDao" %>
<%@ page import="com.example.jspwithdb.dto.MemberDto" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%
    Object obj = session.getAttribute("login");   //loginAf의 setAttribute에 "login"이라고 해놨으므로
    MemberDto mem = null;
    if(obj == null){   //세션이 없어졌을 때
%>
<script>
    alert('로그인해주십시오');
    location.href = "login.jsp";
</script>
<%
    }
    mem = (MemberDto)obj;
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>

<%
    BbsDao dao = BbsDao.getInstance();

    List<BbsDto> list = dao.getBbsList();

%>

<h2>게시판</h2>

<div align="center">

    <table border="1">
        <col width="70"><col width="600"><col width="100"><col width="150">
        <tr>
            <th>번호</th><th>제목</th><th>조회수</th><th>작성자</th>
        </tr>

        <%
            if(list == null || list.size() == 0) {      //db 연결 안됐거나 || 데이터 없을 때
        %>
        <tr>
            <td colspan="4">작성된 글이 없습니다</td>
        </tr>
        <%
        } else {
            for(int i = 0; i< list.size(); i++) {
                BbsDto bbs = list.get(i);
        %>
        <tr>
            <th><%=i+1 %></th>  <!-- 번호 -->
            <td>
                <a href="bbsdetail.jsp?seq=<%=bbs.getSeq() %>"><%=bbs.getTitle() %></a>
            </td>
            <td><%=bbs.getReadcount() %></td>
            <td><%=bbs.getId() %></td>
        </tr>
        <%
                }
            }
        %>

    </table>

</div>

<a href="bbswrite.jsp">글 작성</a>


</body>
</html>
