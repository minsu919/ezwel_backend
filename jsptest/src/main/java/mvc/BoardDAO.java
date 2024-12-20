package mvc;

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

import dao.DBInfo;


public class BoardDAO {
	
	public String insertBoard(BoardDTO dto){
		String result = "";
		
		Connection con = null;
		try {
		Context context = new InitialContext(); // context.xml 파일 설정내용 객체
		Context env = (Context)context.lookup("java:/comp/env"); // "연관설정 가져오는 접두어
		DataSource ds = (DataSource)env.lookup("jdbc/mydb");// 미리 con 몇개 생성
		con = ds.getConnection();
			
		//삽입 productcode 자동 증가
		String selectSQL = "select max(seq)+1 from board";//1행1열
		PreparedStatement pt2 = con.prepareStatement(selectSQL);
		ResultSet rs = pt2.executeQuery();
		rs.next();
		int maxSeq = rs.getInt("max(seq)+1");
		
		String insertSQL = 
		"INSERT INTO board VALUES(?, ?, ?, ?, ?, 0, sysdate)";
		PreparedStatement pt = con.prepareStatement(insertSQL);
		pt.setInt(1, maxSeq);
		pt.setString(2, dto.getTitle());
		pt.setString(3, dto.getContents());
		pt.setString(4, dto.getWriter());
		pt.setInt(5, dto.getWritepw());
		int rows = pt.executeUpdate();
		result = rows + "";
		System.out.println("insertBoard의 결과는 : " + result);
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
		return result;
	}//insertBoard end

	
	public ArrayList<BoardDTO> getBoardList(int page, int count) {
		ArrayList<BoardDTO> list = new ArrayList<BoardDTO>();

		Connection con = null;
		try {
		Context context = new InitialContext(); // context.xml 파일 설정내용 객체
		Context env = (Context)context.lookup("java:/comp/env"); // "연관설정 가져오는 접두어
		DataSource ds = (DataSource)env.lookup("jdbc/mydb");// 미리 con 몇개 생성
		con = ds.getConnection();
		
		String selectSQL = 
		"select seq, title, writer, writingtime "
		+ "	from(select rownum r,  imsi.* "
		+ " from (select * from board order by writingtime desc) imsi)" 
		+ " where r between ? and ?";
		 
		int start = (page-1)*count + 1;
		int end = page * count;

		PreparedStatement pt2 = con.prepareStatement(selectSQL);
		pt2.setInt(1,  start);
		pt2.setInt(2,  end);
		ResultSet rs = pt2.executeQuery();//rs 생성되면 첫번째 레코드 참조하는 것이 아니다
		
		while(rs.next()) {
			BoardDTO dto = new BoardDTO();
			dto.setSeq(rs.getInt("seq"));
			dto.setTitle(rs.getString("title"));
			dto.setWriter(rs.getString("writer"));
			dto.setWritingTime(rs.getString("writingtime"));
			list.add(dto);
		}
		con.close();
		System.out.println("db 연결 해제 성공");
		//
		}catch(Exception e) {
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

	}//getBoardList(int, int) end
	
	public int getTotalCount() {
		int total = 0;

		Connection con = null;
		try {
		Context context = new InitialContext(); // context.xml 파일 설정내용 객체
		Context env = (Context)context.lookup("java:/comp/env"); // "연관설정 가져오는 접두어
		DataSource ds = (DataSource)env.lookup("jdbc/mydb");// 미리 con 몇개 생성
		con = ds.getConnection();
		System.out.println("db 연결 성공");
		
		String selectSQL = "select count(*) cnt from board";
		PreparedStatement pt2 = con.prepareStatement(selectSQL);
		ResultSet rs = pt2.executeQuery();//rs 생성되면 첫번째 레코드 참조하는 것이 아니다
		
		rs.next();
		total = rs.getInt("cnt");
		
		con.close();
		System.out.println("db 연결 해제 성공");
		//
		}catch(Exception e) {
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


}
