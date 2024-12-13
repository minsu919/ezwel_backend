package dto;

public class MemberDTO {
	String id, name;
	int pw;
	String phone, email, regdate;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPw() {
		return pw;
	}
	public void setPw(int pw) {
		this.pw = pw;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id + " 회원님의 정보는 다음과 같습니다.\n" + "이름 : " + name + " 폰 : " + phone + " 이메일 : " +
				email + " 가입일 : " + regdate;
	}
	//생성자추가정의
	public MemberDTO(String id, String name, int pw, String phone, String email) {
		super();
		this.id = id;
		this.name = name;
		this.pw = pw;
		this.phone = phone;
		this.email = email;
	}
	
	
	public MemberDTO(String id, String name, String phone, String email) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
	}
	public MemberDTO() {}
	
	
	
	//toString메소드
	
	
	
}
