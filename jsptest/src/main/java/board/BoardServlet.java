package board;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/board")
public class BoardServlet extends HttpServlet {
	ArrayList<BoardDTO> boardlist = new ArrayList<>();
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		
		boardlist.add(new BoardDTO(1, "게시물1", "게시물 1의 내용입니다", "id1"));
		boardlist.add(new BoardDTO(2, "게시물2", "게시물 2의 내용입니다", "id2"));
		boardlist.add(new BoardDTO(3, "게시물3", "게시물 3의 내용입니다", "id3"));
		boardlist.add(new BoardDTO(4, "게시물4", "게시물 4의 내용입니다", "id4"));
		boardlist.add(new BoardDTO(5, "게시물5", "게시물 5의 내용입니다", "id5"));
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if (
				request.getParameter("seq") != null
				&& request.getParameter("title") != null
				&& request.getParameter("contents") != null
				&& request.getParameter("userid") != null ) {
			int seq = Integer.parseInt(request.getParameter("seq"));
			String title = request.getParameter("title");
			String contents = request.getParameter("contents");
			String userId = request.getParameter("userid");
			System.out.println("어 파라미터 읽어왔다");
			boardlist.add(new BoardDTO(seq, title, contents, userId));
			System.out.println("어 리스트에 추가했다");
			
		}
		
		HttpSession session = request.getSession();
		RequestDispatcher rd = null;
		session.setAttribute("list",boardlist);
		System.out.println(boardlist);
		String action = "", userId = "";
		
		int seq = -1;
		
		if (request.getParameter("action") != null) {
			action = request.getParameter("action");
			
			if (action.equals("list")) {
				rd = request.getRequestDispatcher("board/boardlist.jsp");
			} else if (action.equals("write") && request.getParameter("userid") != null) {
				userId = request.getParameter("userid");
				session.setAttribute("userid",userId);
				rd = request.getRequestDispatcher("board/boardwriteform.jsp");
			} else if (action.equals("detail") && request.getParameter("seq") != null) {
				seq = Integer.parseInt(request.getParameter("seq"));
				session.setAttribute("seq",seq);
				rd = request.getRequestDispatcher("board/boarddetail.jsp");
			}
			rd.forward(request, response);
		}
		
		
	}

}
