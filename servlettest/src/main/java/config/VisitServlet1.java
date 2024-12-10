package config;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(
		urlPatterns = { "/visit1" }, 
		initParams = { 
				@WebInitParam(name = "i", value = "0")
		})
public class VisitServlet1 extends HttpServlet {
	int i;
	public void init(ServletConfig config) throws ServletException {
		i = Integer.parseInt(config.getInitParameter("i"));
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = request.getServletContext();
		context.setAttribute("i", i++);
		i = (int)context.getAttribute("i");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		System.out.println("우리 컨텍스트 방문" + i + "번째 방문자입니다.");
		out.println("우리 컨텍스트 방문" + i + "번째 방문자입니다.");
		
	}

}
