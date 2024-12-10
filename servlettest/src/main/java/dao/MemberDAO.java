package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import dto.MemberDTO;


public class MemberDAO {
	public String insertMember(MemberDTO dto){
		String msg = "";
		//dto 변수 전달 모든 내용을 members 테이블에 저장 구현
		Connection con = null;
		try {
		Class.forName(DBInfo.driver);
		con = DriverManager.getConnection
				(DBInfo.url, DBInfo.account, DBInfo.password);
		System.out.println("db 연결 성공");
			
		//dto.getId() members  테이블 중복 검사
		String selectSQL = "select id from members where id=?";
		PreparedStatement pt2 = con.prepareStatement(selectSQL);
		pt2.setString(1, dto.getId());
		ResultSet rs = pt2.executeQuery();
		// members id pk ( 1개(o) /0개(o)   /n개(x)  )
		if(rs.next()) {
			//중복 id 존재
			msg = "중복된 아이디입니다. 다른 아이디를 입력하세요.";
		}
		else {
			//id 중복x
			String insertSQL = "INSERT INTO MEMBERS VALUES(?, ?, ?, ?, ?, sysdate)";
			PreparedStatement pt = con.prepareStatement(insertSQL);
			pt.setString(1, dto.getId());
			pt.setString(2, dto.getName());
			pt.setInt(3, dto.getPw());
			pt.setString(4, dto.getPhone());
			pt.setString(5, dto.getEmail());
			int rows = pt.executeUpdate();
			msg = rows + " 명의 회원가입 성공했습니다.";
		}
		con.close();
		System.out.println("db 연결 해제 성공");
		//
		}
		catch(ClassNotFoundException e) {
			System.out.println("잘못된 드라이버이름 혹은 classpath 잘못되었을 수 있습니다.");
			System.out.println("module-info.java 미설정 확인하세요 ");
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
		return msg;
	}//insertMember end
	
	public String deleteMember(String id, int pw) {
		String msg = "";
		//dto 변수 전달 모든 내용을 members 테이블에 저장 구현
		Connection con = null;
		try {
		Class.forName(DBInfo.driver);
		con = DriverManager.getConnection
				(DBInfo.url, DBInfo.account, DBInfo.password);
		System.out.println("db 연결 성공");
		
		//회원 존재여부+암호 일치여부
		String selectSQL = "select id, pw from members where id=?";
		PreparedStatement pt2 = con.prepareStatement(selectSQL);
		pt2.setString(1, id);
		ResultSet rs = pt2.executeQuery();
		
		if(rs.next()) {//회원 존재
			if(pw == rs.getInt("pw")) {//암호 같으면
				//delete구현
				String deleteSQL = "delete from members where id=?";
				PreparedStatement pt = con.prepareStatement(deleteSQL);
				pt.setString(1, id);
				pt.executeUpdate();
				msg = "성공적으로 탈퇴처리되었습니다.";
			}
			else {// 암호 다르면
				msg = "입력하신 암호는 회원님의 암호와 다릅니다.";
			}
		}
		else {//회원 미존재
			msg = "가입된 회원이 아닙니다.";
		}
		
		con.close();
		System.out.println("db 연결 해제 성공");
		//
		}catch(ClassNotFoundException e) {
			System.out.println("잘못된 드라이버이름 혹은 classpath 잘못되었을 수 있습니다.");
			System.out.println("module-info.java 미설정 확인하세요 ");
		}catch(SQLException e) {
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
		return msg;
	}//deleteMember end
	
	public String updateMember(MemberDTO dto) {
		String sql = "update members set name=?, phone=?, email=? where id=?";
		
		String msg = "";
		
		Connection con = null;
		try {
		Class.forName(DBInfo.driver);
		con = DriverManager.getConnection
				(DBInfo.url, DBInfo.account, DBInfo.password);
		System.out.println("db 연결 성공");
		
		PreparedStatement pt2 = con.prepareStatement(sql);
		pt2.setString(1, dto.getName());
		pt2.setString(2, dto.getPhone());
		pt2.setString(3, dto.getEmail());
		pt2.setString(4, dto.getId());	
		pt2.executeUpdate();
		msg = "update 성공";
		
		con.close();
		System.out.println("db 연결 해제 성공");
		//
		}catch(ClassNotFoundException e) {
			System.out.println("잘못된 드라이버이름 혹은 classpath 잘못되었을 수 있습니다.");
			System.out.println("module-info.java 미설정 확인하세요 ");
		}catch(SQLException e) {
			System.out.println("db 연결 실패-연결 정보를 확인하세요");
			e.printStackTrace();//오류발생원인 추적하여 출력
			msg = "update 실패";
		}finally {
			try {
				if(!con.isClosed()) {
					con.close();
					System.out.println("finally - db 연결 해제 성공");
				}
			}catch(Exception e) {}
		}
		return msg;
		
		
	}
	
	public MemberDTO getMember(String id, int pw) {
		MemberDTO dto = null;
		Connection con = null;
		try {
		Class.forName(DBInfo.driver);
		con = DriverManager.getConnection
				(DBInfo.url, DBInfo.account, DBInfo.password);
		System.out.println("db 연결 성공");
		
		//회원 존재여부+암호 일치여부
		String selectSQL = 
				"select id, name, pw, phone, email, to_char(regdate, 'yyyy\"년도\"mm\"월\"dd\"일\"') regdate from members where id=?";
		PreparedStatement pt2 = con.prepareStatement(selectSQL);
		pt2.setString(1, id);
		ResultSet rs = pt2.executeQuery();
		if(rs.next()) {//회원 존재
			if(pw == rs.getInt("pw")) {//암호 같으면
				dto = new MemberDTO();
				dto.setId(rs.getString("id"));
				dto.setPw(rs.getInt("pw"));
				dto.setName(rs.getString("name"));
				dto.setPhone(rs.getString("phone"));
				dto.setEmail(rs.getString("email"));
				dto.setRegdate(rs.getString("regdate"));
			}
			else {// 암호 다르면
				dto = new MemberDTO();
				dto.setId(rs.getString("id"));
			}
		}

		
		con.close();
		System.out.println("db 연결 해제 성공");
		//
		}catch(ClassNotFoundException e) {
			System.out.println("잘못된 드라이버이름 혹은 classpath 잘못되었을 수 있습니다.");
			System.out.println("module-info.java 미설정 확인하세요 ");
		}catch(SQLException e) {
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
		return dto;// 모든정보 포함 / id만 포함 / null
	}//getMember end
	
	public int getTotalCount() {
		int total = 0;

		Connection con = null;
		try {
		Class.forName(DBInfo.driver);
		con = DriverManager.getConnection
				(DBInfo.url, DBInfo.account, DBInfo.password);
		System.out.println("db 연결 성공");
		
		String selectSQL = "select count(*) cnt from members";
		PreparedStatement pt2 = con.prepareStatement(selectSQL);
		ResultSet rs = pt2.executeQuery();//rs 생성되면 첫번째 레코드 참조하는 것이 아니다
		
		rs.next();
		total = rs.getInt("cnt");
		
		con.close();
		System.out.println("db 연결 해제 성공");
		//
		}catch(ClassNotFoundException e) {
			System.out.println("잘못된 드라이버이름 혹은 classpath 잘못되었을 수 있습니다.");
			System.out.println("module-info.java 미설정 확인하세요 ");
		}catch(SQLException e) {
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
		return total;
	}//getTotalCount end	
	
	
	public ArrayList<MemberDTO> getMembers(int pagenumber, int count) {
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();

		Connection con = null;
		try {
		Class.forName(DBInfo.driver);
		con = DriverManager.getConnection
				(DBInfo.url, DBInfo.account, DBInfo.password);
		System.out.println("db 연결 성공");
		
		String selectSQL = 
		"select id, name, phone, email, regdate "
		+ "	from(select rownum r,  imsi.* "
		+ " from (select * from members order by regdate desc) imsi)" 
		+ " where r between ? and ?";
		 
		int start = (pagenumber-1)*count + 1;
		int end = pagenumber * count;

		PreparedStatement pt2 = con.prepareStatement(selectSQL);
		pt2.setInt(1,  start);
		pt2.setInt(2,  end);
		ResultSet rs = pt2.executeQuery();//rs 생성되면 첫번째 레코드 참조하는 것이 아니다
		
		while(rs.next()) {
			MemberDTO dto = new MemberDTO();
			dto.setId(rs.getString("id"));
			dto.setName(rs.getString("name"));
			dto.setPhone(rs.getString("phone"));
			dto.setEmail(rs.getString("email"));
			dto.setRegdate(rs.getString("regdate"));
			list.add(dto);
		}
		con.close();
		System.out.println("db 연결 해제 성공");
		//
		}catch(ClassNotFoundException e) {
			System.out.println("잘못된 드라이버이름 혹은 classpath 잘못되었을 수 있습니다.");
			System.out.println("module-info.java 미설정 확인하세요 ");
		}catch(SQLException e) {
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
		return list;

	}//getMembers(int, int) end	
	
	
	
	public ArrayList<MemberDTO> getMembers(String[] items, String word) {
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();

		Connection con = null;
		try {
		Class.forName(DBInfo.driver);
		con = DriverManager.getConnection
				(DBInfo.url, DBInfo.account, DBInfo.password);
		System.out.println("db 연결 성공");
		
		String selectSQL = "select * from members where " + items[0] + " like ?";
		for (int i=1; i<items.length; i++) {
			selectSQL += " or " + items[i] + " like ?";
		}
		System.out.println(selectSQL);
		
		
		PreparedStatement pt2 = con.prepareStatement(selectSQL);
		
		for (int i=1; i<=items.length; i++) {
			pt2.setString(i,  "%" + word + "%");		
		}
		
		ResultSet rs = pt2.executeQuery();//rs 생성되면 첫번째 레코드 참조하는 것이 아니다
		
		while(rs.next()) {
			MemberDTO dto = new MemberDTO();
			dto.setId(rs.getString("id"));
			dto.setName(rs.getString("name"));
			dto.setPhone(rs.getString("phone"));
			dto.setEmail(rs.getString("email"));
			dto.setRegdate(rs.getString("regdate"));
			list.add(dto);
		}
		con.close();
		System.out.println("db 연결 해제 성공");
		//
		}catch(ClassNotFoundException e) {
			System.out.println("잘못된 드라이버이름 혹은 classpath 잘못되었을 수 있습니다.");
			System.out.println("module-info.java 미설정 확인하세요 ");
		}catch(SQLException e) {
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
		return list;

	}//getMembers(int, int) end
	
	public static void main(String args[]) {
		// MemberDAO - java application 실행
		ArrayList<MemberDTO> list = new MemberDAO().getMembers(new String[] {"id", "name"}, "김");
		System.out.println(list);
	}

}//class end




