<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1><%=request.getParameter("seq") %> 번의 게시물 검색</h1>
<%-- <%= request.getAttribute("board") %> --%>

<jsp:useBean id="board" class="board.BoardDTO" scope="request" />
번호:<jsp:getProperty property="seq" name="board"/><br>
작성자:<jsp:getProperty property="writer" name="board"/><br>
제목:<jsp:getProperty property="title" name="board"/><br>
내용:<jsp:getProperty property="contents" name="board"/><br>
</body>
</html>