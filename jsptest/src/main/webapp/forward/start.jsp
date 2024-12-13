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
String filename = "";
String role = "";
String[] menu = null;

if (id != null){
	if (id.equals("admin") || id.equals("administration") || id.equals("administrator")){
		// admin.jsp
		filename = "/forward/admin.jsp"; // "관리자" 값을 전달
		role = "관리자";
		menu = new String[7];
		menu[0] = "모든 사용자 정보 조회";
		menu[1] = "회원 강제 탈퇴";
		menu[2] =  "게시판 관리";
		menu[3] = "회원가입";
		menu[4] = "상품구입";
		menu[5] =  "게시물작성";
		menu[6] =  "장바구니";
	} else {
		// user.jsp
		filename = "user.jsp"; // "일반회원" 값을 전달
		role = "일반 회원";
		menu = new String[4];
		menu[0] = "회원가입";
		menu[1] = "상품구입";
		menu[2] =  "게시물작성";
		menu[3] =  "장바구니";
	}
} else {
	filename = "none.jsp";
	role = "비회원";
	menu = new String[0];
}

request.setAttribute("menu", menu);

%>
<!-- 출력 무시 -->
<jsp:forward page="<%=filename %>">
	<jsp:param name="role" value="<%=role %>" />
</jsp:forward>
<!-- 출력 무시 -->

</body>
</html>