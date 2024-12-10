package forward;

import jakarta.servlet.RequestDispatcher;
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


//@WebServlet("/search")
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
		
		request.setAttribute("list", list);
		RequestDispatcher rd = request.getRequestDispatcher("/forward2");
		rd.forward(request, response);
	}

	
}
