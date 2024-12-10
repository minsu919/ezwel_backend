package db;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import dao.DBInfo;

@WebServlet("/datasource")
public class DataSourceServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// DataSource 사용 - "미리" db con - context.xml 설정. 공유
		// tomcat 구현 
		
		// DataSource 미사용
		try {
//			Class.forName(DBInfo.driver);
//			long start = System.currentTimeMillis();
//			for(int i=1; i<=100; i++) {
//				Connection con = DriverManager.getConnection
//						(DBInfo.url, DBInfo.account, DBInfo.password);
//				System.out.println(i + " 번째 오라클 db 연결 성공");
//				con.close();
//			}
//			long end = System.currentTimeMillis();
//			System.out.println((end-start) + "(1/1000초단위) 소요");
			

			// DataSource 사용
			Context context = new InitialContext(); // context.xml 파일 설정내용 객체
			Context env = (Context)context.lookup("java:/comp/env");
			DataSource ds =(DataSource)env.lookup("jdbc/mydb"); // 미리 con 몇개 생성
			
			long start2 = System.currentTimeMillis();
			for(int i=1; i<= 100; i++) {
				Connection con = ds.getConnection();
				System.out.println(i + " 번째 datasource 로부터 db 연결 성공");
				con.close();// ds 반납 
				
			}
			long end2 = System.currentTimeMillis();
			System.out.println((end2-start2) + " (1/1000초단위) 소요");
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		}

	
}
