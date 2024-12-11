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

/**
 * Servlet implementation class CartRemoveServlet
 */
@WebServlet("/cartremove")
public class CartRemoveServlet extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		int resultPrice = 0;
		int resultAmount = 0;
		
		String result = "<h2>결제</h2>";
		
		
		
		ArrayList<CartDTO> carts = new ArrayList<CartDTO>();
		if (session.getAttribute("cartdto") != null) {
			carts = (ArrayList<CartDTO>)session.getAttribute("cartdto");
			for (CartDTO dto : carts) {
				resultAmount += dto.getAmount();
				resultPrice += dto.getTotalPrice();
			}
			result += "<h3>총 상품 "+ resultAmount +"개 "+ resultPrice +"원 결제되었습니다</h2>";
		} else {
			result += "<h3>장바구니에 상품이 없습니다</h2>";
		}
		out.println(result);
		session.removeAttribute("cartdto");
	}

}
