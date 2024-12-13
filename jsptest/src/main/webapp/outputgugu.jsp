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
if (request.getMethod().equals("POST")){
int start = Integer.parseInt(request.getParameter("startdan"));
int end = Integer.parseInt(request.getParameter("enddan"));
%>
<table border="3">
<%for (int i=start; i<=end; i++){
%>
<tr>
<%
	for (int j=1; j<=9; j++){
%>
<%= "<td>" + i + " x " + j + " = " + j*i + "</td>" %>
<%
}
%>	
</tr>	
<%
}
} // if end
else{
%>
<h3> 요청방식 오류 </h3>
<%
}
%> 
</table>
</body>
</html>