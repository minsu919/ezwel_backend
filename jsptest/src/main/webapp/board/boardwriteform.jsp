<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="userid" class="java.lang.String" scope="session" />
<h1>게시글 작성</h1>
<form action="">
<label for="seq" >번호</label> <input type=text id="seq" name="seq"><br>
<label for="title" >제목</label> <input type=text id="title" name="title"><br>
<label for="contents" >내용</label> <input type=text id="contents" name="contents"><br>
<label for="writer" >작성자</label> <input type=text id="writer" name="writer" 
value="<%=session.getAttribute("userid") %>" readonly><br>
<input type=submit value="글쓰기">
</form>
</body>
</html>