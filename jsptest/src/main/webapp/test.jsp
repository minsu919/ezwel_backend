
<%@page import="java.io.IOException"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page contentType="text/html;charset=UTF-8" errorPage="/error/e.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>테스트</h3>
<%! String name = null; %>
<%   
 name = request.getParameter("name");
String now = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
%>
<%=now%> 시각에 <%=name %> 님이 로그인하셨습니다.<br>
<%= 100+200 %><br>

이름입력:<input type=text name="username" value="<%=request.getParameter("name") %>">

<%!
public String test(String str, PageContext pc) throws IOException{
	pc.getOut().print("출력");
	return str.toUpperCase()+name.toUpperCase();
}
%>

<%= test("java", pageContext) %>
</body>
</html>
<!-- 
http://ip:port/jsptest/test.jsp?name=guest

doGet(....,HttpServletResponse response)

response.setContentType("text/html;charset=utf-8")
-->