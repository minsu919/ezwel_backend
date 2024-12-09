package first;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class CalcServlet extends HttpServlet {
	//http프로토콜정한규칙맞는방법으로 요청 - 처리 - http프로토콜정한규칙맞는방법으로 응답
	//HttpServletRequest 클래스
	//HttpServletResponse 클래스
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//10 20 +  클라이언트 요청정보에 포함.
		//http://ip:port/servletest/calc?su1=20&su2=10&op=%2B
		//http://ip:port/servletest/calc?su1=20&su2=10&op=-
		//http://ip:port/servletest/calc?su1=20&su2=10&op=*
		//http://ip:port/servletest/calc?su1=20&su2=10&op=/
		
		//http://localhost:8080/servlettest/calc?su1=20&su2=0&op=%EB%82%98
		
			//URL?변수명1=값1&변수명2=값2 ( 단 값이 '+' - %2B)
		//추출
		
		int su1 = 0;
		if(request.getParameter("su1") != null  &&  !request.getParameter("su1").equals("") ) {
			su1 = Integer.parseInt(request.getParameter("su1"));
		}

		//String str_su1 = request.getParameter("su1");//""
		//System.out.println("-" + str_su1 + "-");
		//int su1 = Integer.parseInt(str_su1);//정수변경x
		
		
		int su2 = Integer.parseInt(request.getParameter("su2"));
		String op = request.getParameter("op");
		// url 뒤 + 기호 --> ' '
		System.out.println(su1 +":" + su2 + ":" + op);
		//처리	
		// 10 + 20 자바문장 구현
		int result = 0;
		if(op.equals("+")) {   result = su1 + su2; }
		else if(op.equals("-")) {   result = su1 - su2; }
		else if(op.equals("*")) {   result = su1 * su2; }
		else if(op.equals("/") && su2 != 0) {   result = su1 / su2; }
		else {
			result = -1;
		}
	System.out.println(result);//요청 브라우저로 출력 x
	
	//연산자가 여러개 입력 상태
	String[] multipleop = request.getParameterValues("multipleop");//여러개
	
	
		// 결과를 클라이언트 브라우저 전송(http응답한다). 출력
		response.setContentType("text/html; charset=utf-8");
		PrintWriter o = response.getWriter();
		o.println("<h3>" + result+":"+request.getRemoteAddr() + "</h3>");//브라우저로 출력
		o.println("<h3>" + Arrays.toString(multipleop) + "</h3>");//브라우저로 출력
	}

}
