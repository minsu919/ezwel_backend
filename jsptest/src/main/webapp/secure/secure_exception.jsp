<%@page import="secure.SecureDAO" errorPage="/error/e.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="/servlettest/js/jquery-3.7.1.min.js"></script>
<script>
$(document).ready(function(){
        //구현
});
</script>
</head>
<body>
<% 
SecureDAO dao = new SecureDAO();
%>

<%-- <%= dao.test3("jdbc1", 11111) %> <!-- select * from members id='admin ' -- ' and pw=xxx -->
 --%><%=  %> <!-- select * from members id='admin ' -- ' and pw=xxx -->
</body>
</html>