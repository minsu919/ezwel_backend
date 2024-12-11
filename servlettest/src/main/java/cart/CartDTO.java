package cart;

public class CartDTO {
	String cartID, productName;
	int amount, totalPrice;
	
	public String getCartID() {
		return cartID;
	}

	public void setCartID(String cartID) {
		this.cartID = cartID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public CartDTO() {}
	
	public CartDTO(String cartID, String productName, int amount, int totalPrice) {
		super();
		this.cartID = cartID;
		this.productName = productName;
		this.amount = amount;
		this.totalPrice = totalPrice;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "상품이름 : " + productName + " |  수량 : " + amount +  " |  총 가격 : " + totalPrice ;
	}

}
