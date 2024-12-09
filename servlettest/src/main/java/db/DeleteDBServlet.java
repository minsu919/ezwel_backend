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


@WebServlet("/deletedb")
public class DeleteDBServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청
		String loginid = request.getParameter("loginid");
		int loginpw = Integer.parseInt(request.getParameter("loginpw"));
		//로그인처리
		MemberDAO dao = new MemberDAO();
		String result = dao.deleteMember(loginid, loginpw);
		//응답


		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<h3>"+result+"</h3>");
	}
}





