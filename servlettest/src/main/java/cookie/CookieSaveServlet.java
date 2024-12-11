package cookie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;


@WebServlet("/cookiesave")
public class CookieSaveServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. Cookie 객체 생성
		Cookie c = new Cookie("name", "tomcat");
		//2. 유효기간 설정(선택적)
		c.setMaxAge(24*60*60); // 초단위
		//3. 클라이언트로 쿠키 전송
		response.addCookie(c);
		
		response.addCookie(new Cookie("age", URLEncoder.encode("20살", "utf-8")));
		response.addCookie(new Cookie("pw","1234"));
	}

}
