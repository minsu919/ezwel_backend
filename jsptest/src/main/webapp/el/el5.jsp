<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<H1>el에서 jsp 내장객체 접근 </H1>
컨텍스트명 = <%=request.getContextPath() %><br>
현재url = <%=request.getRequestURI() %><br>
현재url = <%=request.getServletPath()%><br>
<% pageContext.setAttribute("s2", "");  %>

<h1>el</h1>
컨텍스트명 = ${ pageContext.request.contextPath}<br>
현재url = ${ pageContext.request.requestURI}<br>

<a href=${pageContext.request.requestURI } > el5.jsp 이동 </a>

<script src=${ pageContext.request.contextPath}/js/jquery-3.7.1.min.js ></script>



</body>
</html>