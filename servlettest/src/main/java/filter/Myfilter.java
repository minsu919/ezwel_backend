package filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


@WebFilter("/*")
public class Myfilter /*extends HttpFilter*/ implements Filter {


	public void destroy() {}
	
	// 서블릿 request - HttpServletRequest requset
	// class HttpServletRequest extends ServletRequest 하위클래스이다.
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 요청시점 서블릿마다 공통 처리 내용 구현
		// 서블릿이름, 클라이언트 ip, 요청 시간 정보
		String servletname = ((HttpServletRequest)request).getServletPath();
		String clientip = request.getRemoteAddr();
		String now = new SimpleDateFormat("yyyy년도 MM월 dd일 HH시 mm분 ss초").format(new Date());
		
		System.out.println("서블릿 명 =" + servletname + " , IP = " + clientip + " , 요청시각 = " + now);
		long start = System.currentTimeMillis();
		// MyFilter 이외에 다른 FIlter 메소드 이동, 더이상 다른 필터가 없으면 서블릿 실행
		chain.doFilter(request, response); 
		long end = System.currentTimeMillis();
		System.out.println((end - start) + "(1/1000)초");
		
		response.setContentType("text/html;charset=utf-8");
	}

	public void init(FilterConfig fConfig) throws ServletException {}

}
