package second;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class FirstServlet
 */
//@WebServlet("/second") //web.xml 설정 
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청 - 처리
		response.setContentType("text/html;charset=utf-8");//한글설정
		PrintWriter out = response.getWriter();
		out.println("<H1 style=\"color:red\">second.FirstServlet 호출 </H1>"); //브라우저 전달 문자열 . HTML태그나 CSS JS문장 작성 가능
		System.out.println("<h1>second.FirstServlet 호출 : 콘솔에 출력됩니다</h1>");//서버컴퓨터 이클립스 콘솔 출력(한글보인다)
	}

}
