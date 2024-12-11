package visit;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/visit1")
public class VisitServlet1 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 1> 방문자 수 저장할 변수
		// 2> ServletContext.getAttribute(방문자수) 읽어온다
		// 2-1> 없다면 "최초방문자"
		// 2-2> 있다면 2번결과 +1 출력

		// 4> ServletContext 저장 setAttribute()
		// 5> 
		int count = 0;
		ServletContext context = request.getServletContext();
		if (context.getAttribute("count") != null) {
			count = (Integer)context.getAttribute("count"); // 이전까지 누적 방문자 수
		}
		
		context.setAttribute("count", ++count); // 이전까지 누적 방문자 수 + 1 을 컨텍스트에 저장
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(count + " 번째 방문자입니다.");
		
	}

}
