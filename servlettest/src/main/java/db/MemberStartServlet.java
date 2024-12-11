package db;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import dto.MemberDTO;


@WebServlet("/member/*")
public class MemberStartServlet extends HttpServlet {

	// web.xml 초기화 파라미터 2가지
	// 현재 서블릿만 초기화 파라미터 전달
	// 컨텍스트 모든 서블릿 초기화 파라미터 전달
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = request.getServletContext();
		String[] menus = context.getInitParameter("membermenu").split(" ");
		String[] sites = new String[] {
				"insertform_DB.html", "loginform_DB.html", "updateform_DB.html","deleteform_DB.html","memberlist","searchform_DB.html"};
		
		
		String result = "<h1>MEMBERMENU</h1>";
		result += "<ul>";
		for (int i=0; i<menus.length; i++) {
			result += "<li><a href=" + sites[i] + ">"+ menus[i] +"</a></li>";
		}
		result += "</ul>";
		
		//response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(result);
		
		// visit1 include
		out.println("<hr>");
//		RequestDispatcher rd = request.getRequestDispatcher("visit1");
//		rd.include(request, response);
		
	}

}
