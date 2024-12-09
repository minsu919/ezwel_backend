package first;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/flow")
public class FlowServlet extends HttpServlet {
	int count;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 메소드 호출(수정)");//서블릿 최초 요청시 1번 호출.
		//여러 클라이언트에 공통적 적용 부분 구현
		// 미리 라이브러리 로드
		count = 1;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet 메소드 호출");//클라이언트가 요청시마다 호출
		//  /flow 서블릿 호출 횟수 브라우저에 출력
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("floe 서블릿 요청 횟수=" + count++ );
		
	}

	@Override
	public void destroy() {
		System.out.println("destroy 메소드 호출");
		//서블릿객체가 메모리에서 삭제될 경우 1번 호출
		//라이브러리 삭제 정리
	}
	
	

}
