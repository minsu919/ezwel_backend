package forward;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import dao.MemberDAO;
import dto.MemberDTO;

@WebServlet("/forward2") // 응답역할. forward2 단독실행결과 얻을 수 없다.
public class ForwardServlet2 extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 처리결과 전달받기 getAttribute
		ArrayList<MemberDTO> list = (ArrayList<MemberDTO>) request.getAttribute("list");
		
		// 응답
		String result = "<style> td {border:2px solid pink}  </style>";
		result += "<table style='border:2px solid blue'>";
		
		for(MemberDTO dto : list) {
			result += "<tr>";
			result +="<td style='border:2px solid pink'>" + dto.getId() + "</td>";
			result +="<td>" + dto.getName() + "</td>";
			result +="<td>" + dto.getPhone() + "</td>";
			result +="<td>" + dto.getEmail() + "</td>";
			result +="<td>" + dto.getRegdate() + "</td>";
			result += "</tr>";
		}
		
		result += "</table>";
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		out.println(result);
		out.println("<h3>" + request.getRequestURI() + "</h3>");
		
//		String id = request.getParameter("id");
//		String upperid = (String)request.getAttribute("upperid");
//		out.println("<h3>" + id + " : " + upperid + "</h3>");
	}

}
