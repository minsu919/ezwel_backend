<%@page import="board.BoardDTO"%>
<%@page import="java.util.ArrayList"%>
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
ArrayList<BoardDTO> boardList = (ArrayList<BoardDTO>)session.getAttribute("list");
out.println("<h1>게시물리스트</h1>");
for (BoardDTO dto : boardList){
	out.println("<p>");
	out.println(dto);
	out.println("</p><hr>");
}
%>
</body>
</html>