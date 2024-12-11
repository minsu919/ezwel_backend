package cart;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet("/cartread")
public class CartGetServlet extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션에 저장된 데이터들 추출
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		String result = "<h2>장바구니 조회</h2>";
		
		
		
		ArrayList<CartDTO> carts = new ArrayList<CartDTO>();
		if (session.getAttribute("cartdto") != null) {
			carts = (ArrayList<CartDTO>)session.getAttribute("cartdto");
			result += "<ul>";
			for (CartDTO dto : carts) {
				result += "<li>"+ dto +"</li>";
			}
			result += "</ul>";
		} else {
			result += "<h2>장바구니에 상품이 없습니다</h2>";
		}
		out.println(result);
	}

}
