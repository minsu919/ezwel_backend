package cart;

import jakarta.servlet.ServletConfig;
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
	HashMap<String,Integer> productMap;
	@Override
	public void init(ServletConfig config) throws ServletException {
		productMap = new HashMap<>();
		productMap.put("상품1", 3000);
		productMap.put("상품2", 10000);
		productMap.put("상품3", 7000);
		productMap.put("상품4", 14000);
		productMap.put("상품5", 50000);
		productMap.put("상품6", 35000);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String result = "";
		PrintWriter out = response.getWriter();
		
		String productName = null;
		String cartID = null;
		int amount = -1;
		int price = -1;
		int totalPrice = -1;
		
		if (request.getParameter("productname") != null 
				&& !request.getParameter("productname").equals("")
				&& request.getParameter("amount") != null 
				&& !request.getParameter("amount").equals("")) {
			productName = request.getParameter("productname");
			amount =Integer.parseInt(request.getParameter("amount"));
			if (productMap.containsKey(productName)) { // hashmap에 제품이름이 있을 때
				
				cartID = request.getParameter("cartid");
				price = productMap.get(productName);
				totalPrice = amount * price;
				
				CartDTO dto = new CartDTO(cartID, productName, amount, totalPrice);
				ArrayList<CartDTO> carts = new ArrayList<CartDTO>();
				if (session.getAttribute("cartdto") != null) { // 장바구니에 물건이 하나 이상 담겼을 경우
					carts = (ArrayList<CartDTO>)session.getAttribute("cartdto");
					
					// 기능 추가
					for (CartDTO cart : carts) {
						if (cart.getProductName().equals(productName)) { // 같은 물건을 장바구니에 추가했다면 
							dto.setAmount(amount + cart.getAmount()); // 수량 늘린다
							dto.setTotalPrice(dto.getAmount() * price);
							carts.remove(cart);
							break;
						} // if end
					} // for end
					// 기능 추가 끝
					
				}
				carts.add(dto);
				session.setAttribute("cartdto", carts);
				System.out.println("장바구니에 저장되었습니다.");
				result += "<h3>장바구니에 저장되었습니다</h3>";
			} 
			else { // 제품이름이 hashmap에 없을 때
				result += "<h3 color='red'>장바구니에 저장할 수 있는 제품이 아닙니다.</h3>";
			}
		} 
		else {// 폼에 제품입력안했을 때
			result += "<h3>장바구니 입력을 확인해부세요</h3>";
		}
		
		
		out.println(result);
	}

}
