<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<fmt:formatNumber value="1234567.89"/><br>
<fmt:formatNumber value="1234567.89" groupingUsed="false"/><br>
<fmt:formatNumber value="0.5" type="percent"/><br>
<fmt:formatNumber value="10000" type="currency"/><br>
<fmt:formatNumber value="10000" type="currency" currencySymbol="$"/><br>

<fmt:formatNumber value="1234567.0412345" pattern="#,#00.#"/><br>
<fmt:formatNumber value="1234567" pattern=".##"/><br>

<c:set var="now" value="<%=new Date() %>"/>
${now } <br>
<fmt:formatDate value="${now }" pattern="yyyy년도 MM월 dd일 E요일 HH시 mm분 ss초"/><br>
<fmt:parseDate value="2024/12/20" pattern="yyyy/MM/dd"/><br>
</body>
</html>