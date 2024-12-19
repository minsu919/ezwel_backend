<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
${100 / 3 }<br>
<%-- ${100 div 3 }<br> --%>
${100 % 3 }<br>
${100 mod 3 }<br>

<input type=text value=${ 'java' > '3'}>
${"100" + "3" }<br>
${"100" == "100" }<br>
${"백" += "100" += "이백" }<br>
1.${cookie.JSESSIONID.value}<br>
2.${cookie.JSESSIONID}<br>
3.${cookie.JSESSIONID.name}<br>
\${100 }은 ${100 } 입니다/
</body>
</html>