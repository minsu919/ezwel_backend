<%@page import="product.ProductDTO"%>
<%@page import="product.ProductDAO"%>
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
if(request.getParameter("productcode") != null){
	int productcode = Integer.parseInt(request.getParameter("productcode"));
	ProductDAO dao = new ProductDAO();
	ProductDTO dto = dao.getProduct(productcode);
	%>
	<%=dto.toString() %>
<%
}
%>
</body>
</html>