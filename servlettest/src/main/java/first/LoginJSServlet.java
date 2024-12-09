package first;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class LoginJSServlet
 */
@WebServlet("/loginjs")
public class LoginJSServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loginid = request.getParameter("loginid");
		String loginpw = request.getParameter("loginpw");
		String role = request.getParameter("role");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h3> 아이디확인=" +loginid+"</h3>");
		out.println("<h3> 암호화깅=" +loginpw+"</h3>");
		out.println("<h3> 역할확인=" +role+"</h3>");
	}

}
