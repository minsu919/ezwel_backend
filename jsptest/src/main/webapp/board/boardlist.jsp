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
<h1>게시물 리스트입니다.</h1>
<%-- <% ArrayList<BoardDTO> boardlist = 
(ArrayList<BoardDTO>) request.getAttribute("boardlist"); %>
<h3><%=boardlist %></h3> --%>

<jsp:useBean id="boardlist" class="java.util.ArrayList" scope="request"/>
<h3><%=boardlist %></h3>


</body>
</html>