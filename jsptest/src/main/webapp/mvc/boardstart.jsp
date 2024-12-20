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
	$("#boardwritelink").on('click', function(event){
		let sessionid = <%=session.getAttribute("sessionid") %>;
		if (sessionid == null){
			event.preventDefault();
		}
	});
	
});
</script>

</head>
<body>
<% if (session.getAttribute("sessionid") != null){ %>
	<h6><%=session.getAttribute("sessionid") %></h6>
	<h6>${sessionScope.sessionid }</h6>
	
<%}
else {
%>
<h6>로그인한 적이 없습니다</h6>
<%
}
%>




<h1>나의 게시판 프로젝트</h1>
<h3>메뉴들</h3>
<ul>
<li><a href='boardstart?menu=loginform'>로그인</a></li>
<li><a href='boardstart?menu=logout'>로그아웃</a></li>
<li><a href='boardstart?menu=writingform' id="boardwritelink">글쓰기 </a> (로그인 이후에 사용가능합니다)</li>
<li><a href='boardstart?menu=boardlist&page=1'>게시물리스트 보기</a> (로그인 없이 사용가능합니다)</li>
</ul>
</body>
</html>