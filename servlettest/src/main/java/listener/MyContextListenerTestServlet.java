package listener;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/contextlistenertest")
public class MyContextListenerTestServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("===컨텍스트 동작 확인용 서블릿===");
		ServletContext context = request.getServletContext();
		context.setAttribute("test", "test값"); // 추가
		context.setAttribute("test", "test값2"); // 수정
		context.removeAttribute("test"); // 삭제
		
	}

}
