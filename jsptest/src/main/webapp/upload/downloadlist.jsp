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
<h1>다운로드 목록을 보여드립니다.</h1>
<c:forEach items="${filearray }" var="filename">
<h2><a href=''>${filename }</a> 파일 다운로드</h2>

</c:forEach>
</body>
</html>