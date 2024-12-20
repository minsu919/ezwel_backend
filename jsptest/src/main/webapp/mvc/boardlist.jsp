<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="boardlist" class="java.util.ArrayList"  scope="request"/>

<h1>게시물 리스트</h1>
<table border=2>
<c:forEach items="${boardlist }" varStatus="vs">
<tr>
<td>${vs.current.seq}</td>
<td><a href="/boardstart?menu=boarddetail&seq=${vs.current.seq}">${vs.current.title}</a></td>
<td>${vs.current.writer}</td>
<td>${vs.current.writingTime}</td>
</tr>
</c:forEach>

</table>

<div>
<fmt:formatNumber value = "${ totalcount div count }" var="endpage"/>
<c:forEach begin="1" end="${endpage+(1-(endpage%1))%1}" step="1" var="v">
	<a href="boardstart?menu=boardlist&page=${v }">${v }</a>
</c:forEach>
</div>
<a href="boardstart">첫 화면으로 가기</a>
</body>
</html>