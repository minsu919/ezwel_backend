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

@WebServlet("/insertdb")
public class InsertDBSdervlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청
		String loginid = request.getParameter("loginid");
		int loginpw = Integer.parseInt(request.getParameter("loginpw"));
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		
		//처리
		MemberDAO dao = new MemberDAO();//DATA ACCESS OBJECT
		MemberDTO dto = new MemberDTO(loginid, name,loginpw, phone, email);//DATA TRANSFER OBJECT . MemberVO (Value Object)
		/*dto.setId(loginid);
		dto.setPw(loginpw);
		dto.setName(name);
		dto.setPhone(phone);
		dto.setEmail(email);*/
		
		String result = dao.insertMember(dto);
		
		//응답
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(result);
		out.println("<a href=insertform_DB.html> 회원가입 페이지로 이동</a>");
	}

}
