package session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/logoutsession")
public class LogoutSessionServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		MyPageDTO dto = new MyPageDTO(
				(String)session.getAttribute("sessionid"), "1234", "김창수", "010-1232-1244", "kim@chang.su");
		String result = "";
		if (session.getAttribute("sessionid") != null) { // 로그인 한 적 있다
			result = "<h3>" + session.getAttribute("sessionid") + "회원님 로그아웃했습니다. 다시 로그인하셔야 정상 사용 가능합니다</h3>";
		} 
		else {
			// 이미 로그아웃을 한번 했거나 브라우저 열고 아직 로그인을 안했거나
			result = "<h3>이미 로그아웃을 한번 했거나 브라우저 열고 아직 로그인한 적이 없습니다</h3>";
		}
		//session.removeAttribute("sessionid"); // 세션 내부 (여러속성 저장된 상태라면) sessionid 삭제, 다른 속성은 살아있다
		session.invalidate(); // 같은 기능 세션 무효화. 모든 속성을 삭제
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(result);
	}

}
