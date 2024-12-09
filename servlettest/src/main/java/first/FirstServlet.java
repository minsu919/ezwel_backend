package first;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//c:/ezwel/workspace_backend/servlettest/src/main/java/first/FirstServlet --> 서블릿 서버컴퓨터 저장 "실제"경로
// 클라이언트 호출 - http://ip:port/servlettest/first
// 실제서블릿경로와이름 감추고 매핑 이름만 노출
@WebServlet("/first")
public class FirstServlet extends HttpServlet {
	//private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script> alert('test'); </script><H1 style=\"color:red\">브라우저에 출력됩니다</H1>"); //브라우저 전달 문자열 . HTML태그나 CSS JS문장 작성 가능
		System.out.println("<h1>콘솔에 출력됩니다</h1>");//서버컴퓨터 이클립스 콘솔 출력(한글보인다)
	}

}
