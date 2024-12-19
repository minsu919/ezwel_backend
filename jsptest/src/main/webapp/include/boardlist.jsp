<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>게시물리스트를 보여드립니다.</h1>
<jsp:include page="footer.jsp" >
	<jsp:param name="imagename" value="../images/html5.jpg" />
	<jsp:param name="jspname" value="<%=request.getServletPath() %>" />
</jsp:include>
</body>
</html>