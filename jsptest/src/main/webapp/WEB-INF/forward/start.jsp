<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
String id = request.getParameter("id"); 
String filename = "", role = "";
if(id != null){
	if(id.equals("admin") || id.equals("administration") || id.equals("administrator")){
		filename="admin.jsp";//"관리자" 전달
		role = "관리자";
	}
	else{
		filename="user.jsp";//"일반회원" 전달
		role = "일반회원";
	}
}
else{
	filename="none.jsp";
	role ="비회원";
}
%>
<!-- 출력무시 -->
<jsp:forward page="<%=filename %>" >
	<jsp:param name="role" value="<%=role %>" />
</jsp:forward>
<!-- request.getParameter("role") 유사  -->	
<!-- 출력무시 -->
</body>
</html>







