<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<ul>
<li><a href='boardlist.jsp'>게시물리스트 보러가기</a></li>
<li><a href='loginform.jsp'>로그인하러가기</a></li>
</ul>


<jsp:include page="footer.jsp" >
	<jsp:param name="imagename" value="../images/iphone.png" />
	<jsp:param name="jspname" value="<%=request.getServletPath() %>" />
</jsp:include>

</body>
</html>