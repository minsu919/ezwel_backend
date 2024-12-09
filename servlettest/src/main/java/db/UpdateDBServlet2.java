package db;

import java.io.IOException;

import dao.MemberDAO;
import dto.MemberDTO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//이름 폰번호 이메일 보여주고 수정 후 
@WebServlet("/updatedb2")
public class UpdateDBServlet2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//이름 폰번호 이메일 만 수정 가능. 
		//요청 4개의 파라미터 입력
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		
		MemberDTO dto = new MemberDTO(id, name, phone, email);
		MemberDAO dao = new MemberDAO();
		String result = dao.updateMember(dto);
		//MemberDAO : updateMember(MemberDTO dto) 구현 완료 + 호출
		//리턴 결과(1. 성공적으로 수정하였습니다.  2. 수정 불가능합니다. ) 
		//응답
		
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println("<h3>" + result + "</h3>");
		
	}

}
