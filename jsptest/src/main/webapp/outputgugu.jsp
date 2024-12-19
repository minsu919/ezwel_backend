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
if(request.getMethod().equals("POST")){
int start = Integer.parseInt(request.getParameter("start"));
int end = Integer.parseInt(request.getParameter("end"));
if(start <= end && start >= 2 && start <= 9 && end >= 2 && end <= 9){
	//조건에 맞을때 구구단 출력
}
else{
	//조건에 맞지 않을때 구구단 미출력
}
%>
<table border=1>
<%
for(int i = 1; i <= 9; i++){  //2*1 ~ 2*9
%>
	<tr>
<%
	for(int dan = start; dan <=end; dan++){
%>

		<td><%= dan + "*" + i + "=" + dan*i %></td>
<%
	}
%>
	</tr>
<%
}
}//IF END
else{
%>
	<h3>요청방식 오류</h3>
<%
}
%>
</table>
</body>
</html>