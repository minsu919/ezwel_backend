<%@page import="dto.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
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
SecureDAO dao = new SecureDAO();
ArrayList<MemberDTO> list = dao.test1(name);


%>
<c:forEach items="<%=list %>" varStatus="vs">
<h5>${vs.current }</h5>
</c:forEach>
</body>
</html>