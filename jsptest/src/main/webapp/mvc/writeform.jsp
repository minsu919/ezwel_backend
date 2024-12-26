<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>글쓰기 폼</h1>
<form action="boardstart" method="post" enctype="multipart/form-data">
`	<input type=hidden name="menu" value="write">
	<label for="title">제목</label><input type=text id="title" name="title"><br>
	<label for="contents">내용</label><textarea rows="5" cols="50" id="contents" name="contents"></textarea><br>
	<label for="writepw">글암호</label><input type=text id="writepw" name="writepw"><br>
	<label for="writer">작성자</label><input type=text id="writer" name="writer" value="${sessionid }" readonly><br>
	<label for="file1">첨부파일</label><input type=file id="file1" name="file1"><br>
	<input type=submit value="작성">
</form>
</body>
</html>