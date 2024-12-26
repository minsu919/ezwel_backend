<%@page import="java.util.UUID"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/servlettest/js/jquery-3.7.1.min.js"></script>
<script>
$(document).ready(function(){
        //구현
});
</script>
</head>
<body>
<form action="<%=request.getRequestURI() %>" method="post">
아이디 <input type=text name="id"><br>
암호 <input type=password name="pw"><br>
<input type=submit value="로그인">
</form>
<%
if (request.getParameter("id") != null){
	session.setAttribute("sessionid", request.getParameter("id"));
	session.setAttribute("sessionpw", request.getParameter("pw"));
	
	// 시큐어코딩 -토큰
	session.setAttribute("CSRF_TOKEN", UUID.randomUUID().toString());
}
%>

<h3><%= (String)session.getAttribute("sessionid") %> 님 환영합니다</h3>
<h4><a href='secure_csrf_inputpw.jsp'>암호 변경하기</a></h4>
<h4><a href='secure_csrf_mypage.jsp'>내정보 보기</a></h4>
<h4><a href='secure_csrf_logout.jsp'>로그아웃하기</a></h4>

<!-- http://localhost:8080 로그인상태  -->
<img src="http://127.0.0.1:8080/servlettest/nonsecure_csrf_inputpw.jsp">
</body>
</html>