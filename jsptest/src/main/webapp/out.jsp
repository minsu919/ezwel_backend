<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
      %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>out내장객체 -html 출력</h3>
<%="out내장객체 - 표현문태그 출력" %>
<% out.println("<h3>out내장객체 - println 출력</h3>"); %>
<%=request.getParameter("id").equals("java") %><br>

총버퍼크기=<%=out.getBufferSize() %><br>
남아있는버퍼크기<%=out.getRemaining() %><br>

<% out.flush(); /*버퍼 출력하고 버퍼 초기화*/%>
남아있는버퍼크기<%=out.getRemaining() %><br>

<!-- 모든 출력문장 정의하면 즉시 브라우저 출력하는 것은 아니다
     예외발생시 출력문장 취소하고 예외메시지 출력
     출력문장내용 버퍼 저장하고 끝까지jsp 실행 종료- 버퍼 출력 
 -->
</body>
</html>