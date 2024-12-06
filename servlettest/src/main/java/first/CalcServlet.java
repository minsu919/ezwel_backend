package first;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;


@WebServlet("/calc")
public class CalcServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// http 포로토콜 정한 규칙 맞는 방법으로 요청 - 처리 -  http 포로토콜 정한 규칙 맞는 방법으로 응답
		// HttpServletRequest 클래스
		// HttpServletResponse 클래스
		// 10 20 + 클라이언트 요청 정보에 포함
		// http://ip:port/servlettest/calc?su1=20&su2=10&op=%2B
		
		// http://localhost:8080/servlettest/calc?su1=20&su2=0&op=%EB%82%98
		// http://localhost:8080/servlettest/calc?su1=20&su2=0&op=%EA%B0%80
		// http://localhost:8080/servlettest/calc?su1=20&su2=0&op=%EA%B0%84
		// 추출
		int su1 = 0;
		if (request.getParameter("su1") != null && !request.getParameter("su1").equals("")) {
			su1 = Integer.parseInt(request.getParameter("su1"));
		}
		
		//String str_su1 = request.getParameter("su1");
		//System.out.println("-" + str_su1 + "-");
		//int su1 = Integer.parseInt(str_su1);
		
		int su2 = Integer.parseInt(request.getParameter("su2"));
//		String str_su2 = request.getParameter("su2");
//		System.out.println("-" + str_su2 + "-");
//		int su2 = Integer.parseInt(str_su2);
		
		String op = request.getParameter("op");
		System.out.println(su1 +":"+su2 +":"+ op);
		int result = 0;
		if (op.equals("+")) {result = su1 + su2;}
		else if (op.equals("-")) {result = su1 - su2;}
		else if (op.equals("*")) {result = su1 * su2;}
		else if (op.equals("/") && su2!=0) {result = su1 / su2;}
		else {
			result = -1;
		}
		System.out.println(result);
		
		String[] multipleop = request.getParameterValues("multipleop");
		// 10 + 20
		// 결과를 클라이언트 브라우저 전송(http 응답한다). 출력
		response.setContentType("text/html;charset=utf-8");
		PrintWriter o = response.getWriter();
		o.println("<h3>" + result + "</h3>");
		o.println("<h3>" + Arrays.toString(multipleop) + "</h3>");
	}

}
