<%@page import="dto.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- html 요청파라미터명--jsp - dto2 저장 프로퍼티명 동일할 때 (자동주입) -->
<!-- 요청파라미터명--dto2 저장 프로퍼티명 다를 때 (매핑작업) -->

<jsp:useBean id="dto2" class="dto.MemberDTO" scope="application"/> 
<jsp:setProperty property="*" name="dto2"/>
<!-- MemberDAO :getMember-- MemberDTO -->

</body>
</html>
