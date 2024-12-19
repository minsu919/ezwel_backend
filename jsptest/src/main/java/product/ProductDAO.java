package product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class ProductDAO {
	public void insertProduct(ProductDTO dto){
		Connection con = null;
		try {
		Context context = new InitialContext(); // context.xml 파일 설정내용 객체
		Context env = (Context)context.lookup("java:/comp/env"); // "연관설정 가져오는 접두어
		DataSource ds = (DataSource)env.lookup("jdbc/mydb");// 미리 con 몇개 생성
		con = ds.getConnection();
			
		//삽입 productcode 자동 증가
		String selectSQL = "select max(productcode)+1 from products";//1행1열
		PreparedStatement pt2 = con.prepareStatement(selectSQL);
		ResultSet rs = pt2.executeQuery();
		rs.next();
		int maxcode = rs.getInt("max(productcode)+1");
		
		String insertSQL = 
		"INSERT INTO products VALUES(?, ?, ?, ?, ?, default)";
		PreparedStatement pt = con.prepareStatement(insertSQL);
		pt.setInt(1, maxcode);
		pt.setString(2, dto.getProductname());
		pt.setDouble(3, dto.getPrice());
		pt.setInt(4, dto.getAmount());
		pt.setString(5, dto.getDetail());
		int rows = pt.executeUpdate();
		con.close();
		}
		catch(NamingException e) {
			System.out.println("context.xml 데이터베이스설정 미작성");
		}
		catch(SQLException e) {
			System.out.println("db 연결 실패-연결 정보를 확인하세요");
			e.printStackTrace();//오류발생원인 추적하여 출력
		}finally {
			try {
				if(!con.isClosed()) {
					con.close();
					System.out.println("finally - db 연결 해제 성공");
				}
			}catch(Exception e) {}
		}
	}//insertProduct end

	public ArrayList<ProductDTO> getlist() {
		ArrayList<ProductDTO> list = new ArrayList<ProductDTO>();

		Connection con = null;
		try {
		Context context = new InitialContext(); // context.xml 파일 설정내용 객체
		Context env = (Context)context.lookup("java:/comp/env"); // "연관설정 가져오는 접두어
		DataSource ds = (DataSource)env.lookup("jdbc/mydb");// 미리 con 몇개 생성
		con = ds.getConnection();
		
		String selectSQL = "select * from products";
		PreparedStatement pt2 = con.prepareStatement(selectSQL);
		ResultSet rs = pt2.executeQuery();//rs 생성되면 첫번째 레코드 참조하는 것이 아니다
		
		while(rs.next()) {
			ProductDTO dto = new ProductDTO();
			dto.setProductcode(rs.getInt("productcode"));
			dto.setProductname(rs.getString("productname"));
			dto.setPrice(rs.getDouble("price"));
			dto.setAmount(rs.getInt("amount"));
			dto.setDetail(rs.getString("detail"));
			dto.setRegdate(rs.getString("regdate"));
			list.add(dto);
		}
		con.close();
		}catch(Exception e) {
			System.out.println("예외발생");
			e.printStackTrace();//오류발생원인 추적하여 출력
		}finally {
			try {
				if(!con.isClosed()) {
					con.close();
					System.out.println("finally - db 연결 해제 성공");
				}
			}catch(Exception e) {}
		}
		return list;

	}//getlist() end

	public ProductDTO getProduct(int productcode) {
		ProductDTO dto = null;

		Connection con = null;
		try {
		Context context = new InitialContext(); // context.xml 파일 설정내용 객체
		Context env = (Context)context.lookup("java:/comp/env"); // "연관설정 가져오는 접두어
		DataSource ds = (DataSource)env.lookup("jdbc/mydb");// 미리 con 몇개 생성
		con = ds.getConnection();
		
		String selectSQL = "select * from products where productcode=?";
		PreparedStatement pt2 = con.prepareStatement(selectSQL);
		pt2.setInt(1, productcode);
		ResultSet rs = pt2.executeQuery();//rs 생성되면 첫번째 레코드 참조하는 것이 아니다
		
		rs.next();
		dto = new ProductDTO();
		dto.setProductcode(rs.getInt("productcode"));
		dto.setProductname(rs.getString("productname"));
		dto.setPrice(rs.getDouble("price"));
		dto.setAmount(rs.getInt("amount"));
		dto.setDetail(rs.getString("detail"));
		dto.setRegdate(rs.getString("regdate"));
		
		con.close();
		}catch(Exception e) {
			System.out.println("예외발생");
			e.printStackTrace();//오류발생원인 추적하여 출력
		}finally {
			try {
				if(!con.isClosed()) {
					con.close();
					System.out.println("finally - db 연결 해제 성공");
				}
			}catch(Exception e) {}
		}
		return dto;

	}//getProduct() end

}
