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
<!-- http://localhost:8080/jsptest/application/application1.jsp?id=servlet1&pw=11111 -->
<% String id = request.getParameter("id");
	int pw = Integer.parseInt(request.getParameter("pw"));
	
   //id 회원정보를 db select 
   //MemberDAO - public MemberDTO getMember(String id, int pw)
   MemberDAO dao = new MemberDAO();
   MemberDTO dto = dao.getMember(id, pw);
   
 	application.setAttribute("member", dto);
 	
%>
<%="사용자 정보를 컨텍스트에 저장했습니다. " %>

</body>
</html>