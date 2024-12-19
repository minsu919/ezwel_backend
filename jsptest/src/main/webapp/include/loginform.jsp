<%@page import="dto.MemberDTO"%>
<%@page import="dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>로그인 화면입니다.</h1>
<%
MemberDAO dao = new MemberDAO();
MemberDTO dto = dao.getMember("servlet1", 11111);
%>
<h3><%=dto.getId() %> 회원님 로그인되었습니다</h3>
<jsp:include page="footer.jsp" >
	<jsp:param name="imagename" value="../images/google.png" />
	<jsp:param name="jspname" value="<%=request.getServletPath() %>" />	
</jsp:include>
</body>
</html>