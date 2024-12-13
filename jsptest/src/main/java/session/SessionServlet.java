package session;

import java.io.IOException;
import java.io.PrintWriter;

import dao.MemberDAO;
import dto.MemberDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import oracle.security.o3logon.a;

@WebServlet("/sessionservlet")
public class SessionServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		//요청 파라미터정보필요-처리-자바문장-공유(세션)- jsp- 응답
		
		String id = request.getParameter("id");
		int pw = Integer.parseInt(request.getParameter("pw"));
		
		// id 회원정보를 db select
		//MemberDAO - public MemberDTO getMember(String id, int pw)
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.getMember(id, pw);
		
		session.setAttribute("sessionmember", dto);
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h3>로그인 완료했습니다.</h3>");
		out.println("<a href=\"session/mypage.jsp\">내정보 보러가기</a><br>");
		out.println("<a href=\"session/logout.jsp\">로그아웃 하러가기</a>");
	
	
	
	
	}

}
