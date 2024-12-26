<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
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
<form action="/jsptest/httpresponsesplit">
이름 <textarea rows=5 cols=50 name="name"></textarea>
<input type=submit value="응답분할인젝션테스트">
</form>
</body>
</html>