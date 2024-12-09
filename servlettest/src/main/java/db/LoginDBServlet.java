package db;

import java.io.IOException;
import java.io.PrintWriter;

import dao.MemberDAO;
import dto.MemberDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/logindb")
public class LoginDBServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청
		String loginid = request.getParameter("loginid");
		int loginpw = Integer.parseInt(request.getParameter("loginpw"));
		//로그인처리
		MemberDAO dao = new MemberDAO();
		MemberDTO dto = dao.getMember(loginid, loginpw);
		//응답
		/* dto.getXXXX()-데이터있다 - 로그인성공
		 * dto.getMemberid()-있다. dto.getxxxx()-null - 아이디존재. 암호 다르게 입력
		 * dto = null - 아이디존재x
		 *  */
		String result = "";
		if(dto != null) {
			if(dto.getPw() == loginpw) {
				result = "<h3 style=color:green>" + loginid + " 회원님 로그인 성공</h3>";
			}
			else {
				result = "<h3 style=color:blue>" + loginid + " 회원님 로그인 실패</h3>";
				result +="<a href='loginform_DB.html'> 로그인페이지로 이동 </a>"; 
			}
		}
		else {
			result = "<h3 style=color:red>" + loginid + " 손님 회원가입부터 하세요.</h3>";
			result +="<a href='insertform_DB.html'> 회원가입페이지로 이동 </a>";
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(result);
	}
}






