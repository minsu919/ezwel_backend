package login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	HashMap<String, Integer> data = new HashMap<String, Integer>();
	String[] str_data = new String[]{"java:1111", "html:2222", "spring:3333", "servlet:4444", "jsp:5555"};
	
	
	void makeMap() {
		
		for (String d : str_data) {
			String[] spl_d = d.split(":");
			data.put(spl_d[0], Integer.parseInt(spl_d[1]));
		}
		//System.out.println(data);
		
	}
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		makeMap();
		String id = null;
		int pwd = 0;
		if (request.getParameter("loginid") != null) {
			id = request.getParameter("loginid");
		}
		if (request.getParameter("loginpw") != null && !request.getParameter("loginpw").equals("")) {
			String pwdStr = request.getParameter("loginpw");
	        try {
	            pwd = Integer.parseInt(pwdStr);  // 정수로 변환
	        } catch (NumberFormatException e) {
	            // 파싱할 수 없는 문자열인 경우 처리
	            response.setContentType("text/html;charset=utf-8");
	            PrintWriter o = response.getWriter();
	            o.println("<h3 style=color:red> 비밀번호는 숫자만 입력할 수 있습니다! </h3>");
	            o.println("<a href='loginform.html'> 로그인 페이지로 돌아가기 </a>");
	            return;  // 예외 발생 시 더 이상 처리하지 않고 반환
	        } 
		}
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter o = response.getWriter();
		if (data.containsKey(id)) {
			if (data.get(id).equals(pwd)) {
				o.println("<h3 style=color:green>" + id + "회원님 로그인 성공! </h3>");
			} else { // 아이디 일치 / 암호 불일치
				o.println("<h3 style=color:blue>" + id + "회원님 로그인 실패! </h3>");
				o.println("<a href='loginform.html'> 로그인 페이지로 이동 </a>");
			}
		} else {o.println("<h3 style=color:red> 아이디가 없습니다! 회원가입을 진행하세요 </h3>");}
	}

}
