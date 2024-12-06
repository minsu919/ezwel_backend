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
//@WebServlet("/second")
public class FirstServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<script> alert('test'); </script><h1 style='color:red'>second.FirstServlet 호출합니다 </h1>"); // 브라우저 전달 문자열 html태그나 css js 문장 작성 가능
		System.out.println("<h1>second.FirstServlet 호출 : 콘솔에 출력됩니다</h1>");
	}

}
