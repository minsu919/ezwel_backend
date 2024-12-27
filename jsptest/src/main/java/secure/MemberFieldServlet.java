package secure;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/member")
public class MemberFieldServlet extends HttpServlet {
	
	String id; // 클라이언트마다 달라야하는건 멤버변수로 공유하지말자.
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		id = request.getParameter("id");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out  = response.getWriter();
		for (int i=1;i<=10;i++) {
			try {
			Thread.sleep(1000);
			} catch(InterruptedException e) {
				System.out.println("스레드슬립오류발생");
			}
			out.println("<h3>입력한 아디는" + id + "입니다</h3>");
			System.out.println("입력한 아디는" + id + "입니다");
		}
	}

}
