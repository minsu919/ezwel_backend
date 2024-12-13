package listener;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/sessionlistenertest")
public class MySessionListenerTestServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("===서블릿에서 세션리스너 테스트 확인용===");
		HttpSession session = request.getSession(); // 세션 새로 생성
		
		session.setAttribute("username", "이자바"); // 세션 내 속성추가
		session.removeAttribute("username"); // 세션 내 속성 삭제
		session.invalidate();
	}

}
