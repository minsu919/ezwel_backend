<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>el 쿠키 읽어오기</h1>
NAME=${cookie.name.name } - ${cookie.name.value }<br>
AGE=${cookie.age.name } - ${cookie.age.value }<br>
PW=${cookie.pw.name } - ${cookie.pw.value }<br>
세션아이디=${cookie.JSESSIONID.name } - ${cookie.JSESSIONID.value }<br>
</body>
</html>