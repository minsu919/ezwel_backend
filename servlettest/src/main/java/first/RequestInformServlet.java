package first;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/requestinform")
public class RequestInformServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h3>클라이언트ip=" + request.getRemoteAddr() +"</h3>");
		out.println("<h3>클라이언트요청방식=" + request.getMethod() +"</h3>");
		out.println("<h3>클라이언트가요청한서블릿=" + request.getRequestURI() +"</h3>");
		out.println("<h3>질의문자열=" + request.getQueryString() +"</h3>");
	}


}
