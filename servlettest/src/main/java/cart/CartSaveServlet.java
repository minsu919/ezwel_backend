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
import java.util.HashMap;

@WebServlet("/cartsave")
public class CartSaveServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO 
		HttpSession session = request.getSession();
		String result = "";
		PrintWriter out = response.getWriter();
		
		HashMap<String,Integer> map = new HashMap<>();
		map.put("상품1", 3000);
		map.put("상품2", 10000);
		map.put("상품3", 7000);
		map.put("상품4", 14000);
		map.put("상품5", 50000);
		map.put("상품6", 35000);
		
		String productName;
		String cartID;
		int amount = -1;
		int price = -1;
		int totalPrice = -1;
		
		if (request.getParameter("productname") != null) {
			productName = request.getParameter("productname");
			if (map.containsKey(productName)) { // hashmap에 제품이름이 있을 때
				
				
				cartID = request.getParameter("cartid");
				amount =Integer.parseInt(request.getParameter("amount"));
				price = map.get(productName);
				totalPrice = amount * price;
				
				CartDTO dto = new CartDTO(cartID, productName, amount, totalPrice);
				ArrayList<CartDTO> carts = new ArrayList<CartDTO>();
				if (session.getAttribute("cartdto") != null) {
					carts = (ArrayList<CartDTO>)session.getAttribute("cartdto");
					
				}
				carts.add(dto);
				session.setAttribute("cartdto", carts);
				System.out.println("장바구니에 저장되었습니다.");
				result += "<h3>장바구니에 저장되었습니다</h3>";
			} 
			else { // 제품이름이 hashmap에 없을 때
				result += "<h3>장바구니에 저장할 수 있는 제품이 아닙니다.</h3>";
			}
		} 
		else {// 폼에 제품입력안했을 때
			result += "<h3>장바구니 입력을 확인해부세요</h3>";
		}
		
		
		out.println(result);
	}

}
