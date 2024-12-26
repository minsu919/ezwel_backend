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
<%
if (session.getAttribute("sessionid") != null){
	out.println(session.getAttribute("sessionid")+"회원님 안녕하세요");
	out.println(session.getAttribute("sessionpw")+"암호 사용중입니다.");
} else {
	out.println("처리불가");
}

%>
</body>
</html>