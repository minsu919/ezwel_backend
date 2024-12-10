package db;

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


@WebServlet("/search")
public class SearchDBServlet extends HttpServlet {

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] items = new String[0];
		if (request.getParameterValues("item") != null) {
			items = request.getParameterValues("item");
		}
		
		String word = request.getParameter("word");
		
		// MemberDAO : ArrayList<MemberDTO> getMembers(String item[], String word)
		
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberDTO> list = null;
		if (items.length >= 1) {
			list = dao.getMembers(items, word);			
		}
		
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
	}

	
}
