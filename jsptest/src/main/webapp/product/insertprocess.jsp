<%@page import="product.ProductDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="productdto" class="product.ProductDTO" />
<jsp:setProperty property="*" name="productdto" />
<!-- productcode, regdate setter 에서 제외 -->

<jsp:useBean id="productdao" class="product.ProductDAO" />
<%  productdao.insertProduct(productdto);
    ArrayList<ProductDTO> productlist = productdao.getlist();
    session.setAttribute("productlist", productlist);
%>
<jsp:forward page="productlist.jsp" />
</body>
</html>