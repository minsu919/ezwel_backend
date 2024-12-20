package mvc;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

import dao.MemberDAO;
import dto.MemberDTO;

@WebServlet("/boardstart")
public class BoardServlet extends HttpServlet {

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// service : get + post 모두 처리
		String jsp = "";
		HttpSession session = request.getSession();
		
		if (request.getParameter("menu") == null) {
			jsp = "/mvc/boardstart.jsp";
		}
		else {
			if (request.getParameter("menu").equals("loginform")) {
				jsp = "/mvc/loginform.jsp";
			}
			else if (request.getParameter("menu").equals("login") && request.getMethod().equals("POST")) {
				String id = request.getParameter("id");
				int pw = Integer.parseInt(request.getParameter("pw"));
				MemberDAO dao = new MemberDAO();
				MemberDTO dto = dao.getMember(id,pw);
				if (dto != null && dto.getPw() != 0) {
					session.setAttribute("sessionid", dto.getId());
				}
				// id 와 pw 파라미터를 읽어온다 --> MemberDAO:getMember() 결과 : MemberDTO --> session 저장 
				//--> boardstart.jsp 이동
				jsp = "/mvc/boardstart.jsp";// session 속성 읽어오는 코드 추가
			}
			else if (request.getParameter("menu").equals("logout")) {
				if (session.getAttribute("sessionid") != null) {
					session.removeAttribute("sessionid");
				}
				jsp = "/mvc/boardstart.jsp";
			}
			else if (request.getParameter("menu").equals("writingform")) {
				jsp = "/mvc/writeform.jsp";
			}
			else if (request.getParameter("menu").equals("write") && request.getMethod().equals("POST")) {
				String title = request.getParameter("title");
				String contents = request.getParameter("contents");
				String writer = request.getParameter("writer");
				int writepw = Integer.parseInt(request.getParameter("writepw"));
				BoardDAO boardDAO = new BoardDAO();
				BoardDTO boardDTO = new BoardDTO(title, contents, writepw, writer);
				String result  = boardDAO.insertBoard(boardDTO);
				if (result != null ) { // 현재 result는 항상 not null, 의미없음
					jsp = "/mvc/boardstart.jsp";
				}
			}
			else if (request.getParameter("menu").equals("boardlist")) {
				BoardDAO boardDAO = new BoardDAO();
				int page = Integer.parseInt(request.getParameter("page"));
				int count = 4;
				ArrayList<BoardDTO> boardList = boardDAO.getBoardList(page, count); // 토탈  10 / 4 올림
				if (boardList != null) {
					request.setAttribute("boardlist", boardList);
					request.setAttribute("totalcount", boardDAO.getTotalCount());
					request.setAttribute("count",count);
					
				}
				jsp = "/mvc/boardlist.jsp";
			}
		}//else
		RequestDispatcher rd = request.getRequestDispatcher(jsp);
		rd.forward(request, response);
		
	}//service end

}// servlet class
