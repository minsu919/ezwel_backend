<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
td:nth-child(2n) {background-color : pink}
td:nth-child(2n+1) {background-color : lime}
</style>
</head>
<body>
<jsp:useBean id="boardlist" class="java.util.ArrayList" scope="request"/>
<jsp:useBean id="categorymap" class="java.util.HashMap" scope="request"/>
<h1>게시물 리스트</h1>
<table border=2>
<c:forEach items="${boardlist }" varStatus="vs">
<tr>
<td>${vs.current.seq}</td>
<td>${vs.current.title}</td>
<td>${vs.current.contents}</td>
<td>${vs.current.writer}</td>
</tr>
</c:forEach>
</table>
<hr>
<h1>카테고리</h1>
<table border=2>
<c:forEach items="${categorymap }" varStatus="vs">
	<tr>
	<td>${vs.current.key }</td>
	<td>
	<c:forEach items="${vs.current.value}" varStatus="vs2">
	${vs2.current}
	<c:if test="${! vs2.last }"> ,</c:if>
	</c:forEach>
	</td>
	</tr>
</c:forEach>
</table>
</body>
</html>