package mvc;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/boardstart")
public class BoardServlet extends HttpServlet {

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// service : get + post 모두 처리
		if (request.getParameter("menu") == null) {
			RequestDispatcher rd = request.getRequestDispatcher("/mvc/boardstart.jsp");
			rd.forward(request, response);	
		}
	}

}
