package context;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/context2")
public class ContextServlet2 extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = request.getServletContext();
		System.out.println(context);
		String s = (String)context.getAttribute("share");
		System.out.println("context 공유값=" + s);
		
		String account = context.getInitParameter("account");
		System.out.println(account);
	}

}
