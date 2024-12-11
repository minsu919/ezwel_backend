package session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

class MyPageDTO {
	String id, pw, name, phone, email;

	public MyPageDTO() {}

	public MyPageDTO(String id, String pw, String name, String phone, String email) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phone = phone;
		this.email = email;
	}

	@Override
	public String toString() {
		return 
		"<h3>아이디 = " + id + ", 이름 = " + name + ", 폰 = " + phone + ", 이메일 = " + email + "</h3>";
	}
	
}
@WebServlet("/mypagesession")
public class MyPageServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		MyPageDTO dto = new MyPageDTO(
				(String)session.getAttribute("sessionid"), "1234", "김창수", "010-1232-1244", "kim@chang.su");
		String result = "";
		if (session.getAttribute("sessionid") != null) { // 로그인 한 적 있다
			result = dto.toString();
		} else { 
			result = "<h3><a href='loginsession?id=sessiontest&pw=1234'>로그인</a> 하지 않으면 회원 정보를 볼 수 없습니다</h3>";
		}
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(result);
	}

}
