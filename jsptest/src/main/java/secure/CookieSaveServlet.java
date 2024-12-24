package secure;

import java.io.IOException;
import java.net.URLEncoder;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/cookiesave_secure")
public class CookieSaveServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// db 사용자 정보 읽어온다. 이름
		//1. Cookie 객체 생성
		Cookie c = new Cookie("name", "tomcat");
		//2-1. 유효기간 설정(선택적)
		c.setMaxAge(24*60*60);
		
		// 2-2. 자바스크립트 접근 불가(선택적)
		c.setHttpOnly(true);
		
		//3. 클라이언트로 쿠키 전송
		response.addCookie(c);
		
		Cookie c2 = new Cookie("age", URLEncoder.encode("20살"  , "utf-8"  ));
		response.addCookie(c2);
		
		response.addCookie(new Cookie("pw", "1234"));
		
		//chrome://settings/content/all 에서 확인 또는
		//F12 - application - cookie에서 확인할 수 있다.
	}

}



