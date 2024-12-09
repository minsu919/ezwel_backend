package first;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loginjs")
public class LoginJSServlet extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//loginid , loginow , role
		String loginid = request.getParameter("loginid");
		String loginpw = request.getParameter("loginpw");
		String role = request.getParameter("role");
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h3>아이디확인=" + loginid + "</h3>");
		out.println("<h3>암호확인=" + loginpw + "</h3>");
		out.println("<h3>역할확인=" + role + "</h3>");
	}

}
