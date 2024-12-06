package first;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// c://ezwel/workspace_backend/servlettest/src/main/java/first/FirstServlet
// 클라이언트 호출 - http://ip:port/servlettest/FirstServlet
// 실제 서블릿 경로와 이름 감추고 mapping 이름만 노출
@WebServlet("/first")
public class FirstServlet extends HttpServlet {
	//private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script> alert('test'); </script><h1 style='color:red'>브라우저에 출력됩니다</h1>"); // 브라우저 전달 문자열 html태그나 css js 문장 작성 가능
		System.out.println("<h1>콘솔에 출력됩니다</h1>");
	}
	
	

}
