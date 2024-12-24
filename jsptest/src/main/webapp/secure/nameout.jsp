<%@page import="java.util.ArrayList"%>
<%@page import="mvc.BoardDTO"%>
<%@page import="secure.SecureDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String name = request.getParameter("name");

	name.replaceAll('union', 'q-union');
	name.replaceAll('or ', 'q-or');
	name.replaceAll('--', '');
SecureDAO dao = new SecureDAO();
//ArrayList<MemberDTO> list = dao.test1(name);
//ArrayList<BoardDTO> list = dao.test2(name);


%>
<c:forEach items="<%=list %>" varStatus="vs">
<h5>${vs.current }</h5>
</c:forEach>
<hr>
<%= dao.test3(name, 22222) %>
<!-- 암호는 DB랑 다르다
	'test1'
 -->
</body>
</html>