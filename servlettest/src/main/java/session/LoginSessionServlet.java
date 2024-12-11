package session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/loginsession")
public class LoginSessionServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		// id = sessiontest, pw = 1234 일치 조건 가정
		HttpSession session = request.getSession();
		/* session 내부 정보는 브라우저 종료시까지 같은 서버 같은 컨텍스트 모든 서블릿 공유
		 * 브라우저 열고 최초 같은 서버 같은 컨텍스트 1개의 서블릿 요청 - 새로 객체 생성
		 * 2번째 같은 서버 같은 컨텍스트 1개의 서블릿 요청 - 이전 생성 세션 객체 리턴
		 * 
		 * */
		
		
		
		
		
		
		if (id != null && pw != null) {
			if (id.equalsIgnoreCase("sessiontest") && pw.equalsIgnoreCase("1234")) {
				session.setAttribute("sessionid", id);
			}
		}
		
		String result = "";
		
		if (session.getAttribute("sessionid") != null) {
			result +=  "<h3>사용가능한 메뉴는 다음과 같습니다</h3>";
			result +=  "<h3><a href='banksession'>내 은행계좌 조회하기</a></h3>";
			result +=  "<h3><a href='mypagesession'>내정보 조회하기</a></h3>";
			result +=  "<h3><a href='logoutsession'>로그아웃 하러가기</a></h3>";
			
		} else {
			result = "<h3>로그인 한 적이 없습니다</h3>";
		}
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(result);
		
		System.out.println(" 세션id(브라우저당 1개)=" + session.getId());
		System.out.println(" 세션 생성여부=" + session.isNew());
		//session.setMaxInactiveInterval(11);
		System.out.println(" 세션 최대유지시간=" + session.getMaxInactiveInterval());
		
		
		
	}

}
