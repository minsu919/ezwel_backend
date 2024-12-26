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
<%-- <%
String referer = request.getHeader("Referer"); // 요청하는 사이트 http://127.0.0.1:8080
String host = request.getHeader("host"); // 현재 나의 사이트 http://localhost:8080
if (referer == null || !referer.contains("host")){
	
}
%> --%>

<%
String csrfTokenParam = request.getParameter("CSRF_TOKEN");
String csrfTokenSession = (String)session.getAttribute("CSRF_TOKEN");
if (csrfTokenParam == null || !csrfTokenParam.equals(csrfTokenSession)){
	out.println("csrf 공격입니다. 토큰이 없습니다.");
	return;
}
%>
<% 
if (request.getParameter("pw") != null){
	session.setAttribute("sessionpw", request.getParameter("pw"));
}
%>
<h4><%=session.getAttribute("sessionid")%> 님 암호가 변경되었습니다.</h4>
<a href='secure_csrf_mypage.jsp'>내정보보기</a>
</body>
</html>