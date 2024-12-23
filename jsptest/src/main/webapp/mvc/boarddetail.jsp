<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="/servlettest/js/jquery-3.7.1.min.js"></script>
<script>
$(document).ready(function(){
	$("#boardupdatelink").on('click', function(event){
		let inputString = prompt('글암호를 입력하세요', '암호 입력');
		if (inputString == ${board.writepw}){
			<%System.out.println("같아");%>	
		} else {
			<%System.out.println("달라");%>
			event.preventDefault();
		}
	});
	
});
</script>
</head>
<body>
<h1><%=request.getParameter("seq") %> 번의 게시물 검색</h1>

<jsp:useBean id="board" class="mvc.BoardDTO" scope="request" />
<table border=1>
<tr><td>번호</td><td>${board.seq }</td></tr>
<tr><td>제목</td><td>${board.title }</td></tr>
<tr><td>내용</td><td>${board.contents }</td></tr>
<tr><td>작성자</td><td>${board.writer }</td></tr>
<tr><td>조회수</td><td>${board.viewCount }</td></tr>
<tr><td>작성시간</td><td>${board.writingTime }</td></tr>
<tr>
<td colspan="2" style="align-items: center;">
<a href='boardstart?menu=boardupdate' id="boardupdatelink">수정버튼</a> 
<a href='boardstart?menu=boarddelete' id="boarddeletelink">삭제버튼</a> 
</td>
</tr>
</table>
</body>
</html>