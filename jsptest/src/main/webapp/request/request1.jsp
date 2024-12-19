<%@page import="dao.MemberDAO"%>
<%@page import="dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- http://localhost:8080/jsptest/request/request1.jsp?id=servlet1&pw=11111 -->
<% String id = request.getParameter("id");
	int pw = Integer.parseInt(request.getParameter("pw"));

	
   //id 회원정보를 db select 
   //MemberDAO - public MemberDTO getMember(String id, int pw)
   MemberDAO dao = new MemberDAO();
   MemberDTO dto = dao.getMember(id, pw);
   
   //출력-무시
   request.setAttribute("member", dto);
   RequestDispatcher rd = request.getRequestDispatcher("/request/request2.jsp");
   rd.forward(request, response);
   //출력-무시
%>
</body>
</html>