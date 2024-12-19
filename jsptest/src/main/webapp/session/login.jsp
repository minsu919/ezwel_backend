<%@page import="dto.MemberDTO"%>
<%@page import="dao.MemberDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% String id = request.getParameter("id");
	int pw = Integer.parseInt(request.getParameter("pw"));
   //id 회원정보를 db select 
   //MemberDAO - public MemberDTO getMember(String id, int pw)
   MemberDAO dao = new MemberDAO();
   MemberDTO dto = dao.getMember(id, pw);
   
  // HttpSession session = request.getSession();//오류
  //HttpSession ss = request.getSession();//가능. jsp파일 2개 세션. 불필요
  
  session.setAttribute("sessionmember", dto);
%>
<h3> 로그인 완료했습니다. </h3>  
<a href="/jsptest/session/mypage.jsp">내정보 보러가기</a><br>
<a href="logout.jsp">로그아웃하러 가기</a>
</body>
</html>








