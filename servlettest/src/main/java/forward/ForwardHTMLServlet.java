package forward;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/forwardhtml")
public class ForwardHTMLServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 멤버리스트 출력 - 사전조건 id=admin 이어야한다.
		
//		response.setContentType("text/html;charset=utf-8");
//		PrintWriter o = response.getWriter();
//		o.println("로그인 화면으로 이동합니다."); // 이동전에 출력문장 브라우저 출력x
		// o 객체 출력내용 작성하면 - 브라우저 즉각 전송 출력 아니다.
		// o 객체 출력내용 작성하면 - 서버내부 임시기억공간 임시적 저장 - 버리고 이동
		
		// 로그인화면 이동
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/loginform_DB.html");
		rd.forward(request, response); // forward 동작 이후
		// 이 밑은 출력되지않는다.
//		response.setContentType("text/html;charset=utf-8");
//		PrintWriter o2 = response.getWriter();
//		o2.println("로그인 화면으로 이동합니다.");
	}

}
