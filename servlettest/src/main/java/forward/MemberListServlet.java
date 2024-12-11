package forward;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import dao.MemberDAO;
import dto.MemberDTO;


@WebServlet("/forwardlist")
public class MemberListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  //   http:.../list?page=
		int page = 1;
		int cntOfPage = 3;
		if(request.getParameter("page") != null && !request.getParameter("page").equals("")) {
			page = Integer.parseInt(request.getParameter("page"));
		}
		
		MemberDAO dao = new MemberDAO();
		ArrayList<MemberDTO> list = dao.getMembers(page, cntOfPage);
		
		request.setAttribute("list", list);
		RequestDispatcher rd = request.getRequestDispatcher("/forward2");
		rd.forward(request, response);
	}

}




