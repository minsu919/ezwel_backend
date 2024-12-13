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
BoardDTO target = null;
int seq = (Integer)session.getAttribute("seq");
ArrayList<BoardDTO> boardList = (ArrayList<BoardDTO>)session.getAttribute("list");
for (BoardDTO dto : boardList){
	if (dto.getSeq() == seq){
		target = dto;
		break;
	}
}
if (target == null){
	out.println("<h3>게시물이 존재하지 않습니다.</h3>");
} else {
	out.println(target);
}
%>
</body>
</html>