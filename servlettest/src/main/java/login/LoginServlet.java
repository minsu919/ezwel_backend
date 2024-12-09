package login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Set;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//자바백엔드프로젝트
// servlet+html 
// jsp+html
//servlet+jsp+html
//spring+jsp(최종목적)


@WebServlet("/login") //doGet()
public class LoginServlet extends HttpServlet {
//요청이전에 주어진 데이터를 맵으로 구성
	String[] data = new String[]{"java:1111", "html:2222", "spring:3333", "servlet:4444", "jsp:5555", "springboot:6666"};
	HashMap<String, Integer> map = new HashMap();
	
	void makeMap() {
		for(int i = 0; i < data.length; i++) {
			String inform[] = data[i].split(":");
			map.put(inform[0], Integer.parseInt(inform[1]));
		}
		System.out.println(map);
		
	}
	
	
	//HttpServlet overriding : doGet / doost 선언부 일치
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		makeMap();
		String loginid = null;
		int loginpw = 0;
		String result = "";
		if(request.getParameter("loginid") != null) {
			loginid = request.getParameter("loginid");
		}
		if(request.getParameter("loginpw") != null && !request.getParameter("loginpw").equals("")) {
			loginpw = Integer.parseInt(request.getParameter("loginpw"));
		}		
		
		boolean isID = map.containsKey(loginid);
		if(isID) {
			int mapPW = map.get(loginid);
			if(mapPW == loginpw) {
				//아이디.암호 모두 일치 - xxxx 회원님 로그인 성공 응답
				result = "<h3 style=color:green>" + loginid + " 회원님 로그인 성공</h3>";
			}
			else {
				//아이디 일치/ 암호 불일치 - xxxx 회원님 로그인 실패 출력후 loginform.html 이동 링크
				result = "<h3 style=color:blue>" + loginid + " 회원님 로그인 실패</h3>";
				result +="<a href='loginform.html'> 로그인페이지로 이동 </a>"; 
			}
		}
		else {
			//아이디 일치하는 것 없다 - xxxx 님 회원가입부터 하세요. 출력
			result = "<h3 style=color:red>" + loginid + " 손님 회원가입부터 하세요.</h3>";
			result +="<a href='memberinsertform.html'> 회원가입페이지로 이동 </a>";
		}
		//응답
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(result);

	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}







