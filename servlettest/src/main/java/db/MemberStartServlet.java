package db;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import dto.MemberDTO;


@WebServlet("/start")
public class MemberStartServlet extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = request.getServletContext();
		String[] menu = context.getInitParameter("membermenu").split(" ");
		System.out.println(menu);
		
		
		String result = "<h1>MEMBERMENU</h1>";
		result += "<ul>";
		
		result += "<li><a href= insertform_DB.html>"+ menu[0] +"</a></li>";
		result += "<li><a href= loginform_DB.html>"+ menu[1] +"</a></li>";
		result += "<li><a href= updateform_DB.html>"+ menu[2] +"</a></li>";
		result += "<li><a href= deleteform_DB.html>"+ menu[3] +"</a></li>";
		result += "<li><a href= memberlist>"+ menu[4] +"</a></li>";
		result += "<li><a href= searchform_DB.html>"+ menu[5] +"</a></li>";

		result += "</ul>";
		
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println(result);
	}

}
