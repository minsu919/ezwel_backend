package context;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/context1")
public class ContextServlet1 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = request.getServletContext();
		System.out.println(context);

		// 서버이름
		System.out.println("서버 이름 : " + context.getServerInfo()); 
		// 사용 서블릿 버전
		System.out.println("서블릿 버전 : " + context.getEffectiveMajorVersion());
		System.out.println("서블릿 버전 : " + context.getEffectiveMinorVersion());
		// 서블링 실행 컨텍스트명
		System.out.println("컨텍스트 이름 : " + context.getContextPath());
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script src='" + context.getContextPath() + "/js/jquery-3.7.1.min.js'></script>");
		out.println("<script> $(document).ready(function(){alert('실행됩니다');}); </script>");
		
		// 같은 컨텍스트 내의 모든 서블릿끼리 (forward, include 안해도) 데이터 공유
		context.setAttribute("share", "context1 클래스에서 전달합니다");
	}

}
