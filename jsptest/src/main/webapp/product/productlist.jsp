<%@page import="product.ProductDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<jsp:useBean id="productlist" class="java.util.ArrayList" scope="session" />
<table border=3>
<%
for(Object obj : productlist){
	ProductDTO dto = (ProductDTO)obj;
%>
  <tr><td><%=dto.getProductcode() %></td><td><a href='productlist.jsp?productcode=<%=dto.getProductcode() %>'><%=dto.getProductname() %></a></td><td><%=dto.getPrice() %></td></tr>	
<%
}
%>
</table>

<jsp:include page="detailproduct.jsp" />
 

</body>
</html>





