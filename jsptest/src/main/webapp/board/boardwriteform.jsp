<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String userId = (String)session.getAttribute("userid");
%>
<form action="board">
	번호<input type='text' name="seq">
	제목<input type='text' name="title">
	내용<input type='text' name="contents">
	작성자<input type='text' name="userid" value=<%=userId %> readonly>
	<input type="submit" value="작성완료">
</form>
</body>
</html>