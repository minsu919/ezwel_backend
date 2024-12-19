package product;

public class ProductDTO {//products 테이블 
	public ProductDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	int productcode;//컬럼변수
	String productname;
	double price;
	int amount;
	String detail, regdate;
	public int getProductcode() {
		return productcode;
	}
	public void setProductcode(int productcode) {
		this.productcode = productcode;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	public ProductDTO(int productcode, String productname, double price, int amount, String detail, String regdate) {
		super();
		this.productcode = productcode;
		this.productname = productname;
		this.price = price;
		this.amount = amount;
		this.detail = detail;
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "ProductDTO [productcode=" + productcode + ", productname=" + productname + ", price=" + price
				+ ", amount=" + amount + ", detail=" + detail + ", regdate=" + regdate + "]";
	}

}
