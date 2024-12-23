package secure;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import mvc.BoardDTO;
import dao.DBInfo;

public class SecureDAO {
	
	
	
	public ArrayList<BoardDTO> test1(String where){
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();
		Connection con = null;
		try {
		Class.forName(DBInfo.driver);
		con = DriverManager.getConnection
				(DBInfo.url, DBInfo.account, DBInfo.password);
		System.out.println("db 연결 성공");
		
		// select * from members where name = ' ' or '1'=1
		
//		String sql = "select * from members where name = '" + where + "'";
		String sql = "select null, title, pw from board where " + where;
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);
		
		while(rs.next()) {
//			MemberDTO dto = new MemberDTO();
//			dto.setId(rs.getString("id"));
//			dto.setName(rs.getString("name"));
//			dto.setPhone(rs.getString("phone"));
//			dto.setEmail(rs.getString("email"));
//			dto.setRegdate(rs.getString("regdate"));
//			list.add(dto);
			BoardDTO dto = new BoardDTO();
			dto.setContents(rs.getString("null"));
			dto.setTitle(rs.getString("title"));
			dto.setWritepw(rs.getInt("pw"));
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
	}
}
