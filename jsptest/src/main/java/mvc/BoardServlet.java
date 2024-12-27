package mvc;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

import dao.MemberDAO;
import dto.MemberDTO;

@WebServlet("/boardstart")
@MultipartConfig(location = "c:/ezwel/board") // multipart 인식.(request.getParameter)
public class BoardServlet extends HttpServlet {

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// service : get + post 모두 처리
		String jsp = "";
		HttpSession session = request.getSession();
		
		System.out.println(request.getParameter("menu"));
		if (request.getParameter("menu") == null) {
			jsp = "boardstart.jsp";
		}
		else {
			if (request.getParameter("menu").equals("loginform")) {
				jsp = "loginform.jsp";
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
				jsp = "boardstart.jsp";// session 속성 읽어오는 코드 추가
			}
			else if (request.getParameter("menu").equals("logout")) {
				if (session.getAttribute("sessionid") != null) {
					session.removeAttribute("sessionid");
				}
				jsp = "boardstart.jsp";
			}
			else if (request.getParameter("menu").equals("writingform")) {
				jsp = "writeform.jsp";
			}
			else if (request.getParameter("menu").equals("write") && request.getMethod().equals("POST")) {
				String title = request.getParameter("title");
				String contents = request.getParameter("contents");
				//String writer = request.getParameter("writer");
				String writer = (String)session.getAttribute("sessionid");
				int writepw = Integer.parseInt(request.getParameter("writepw"));
				BoardDTO boardDTO = new BoardDTO(title, contents, writepw, writer);
				// 첨부파일 코드
				
				request.setAttribute("dto", boardDTO);
				RequestDispatcher rd2 = request.getRequestDispatcher("boardupload");
				rd2.include(request, response);
				
				boardDTO = (BoardDTO)request.getAttribute("dto");
				
				BoardDAO boardDAO = new BoardDAO();
				String result  = boardDAO.insertBoard(boardDTO);
				response.sendRedirect("http://localhost:8080/jsptest/boardstart");
				return;
			}
			
			else if (request.getParameter("menu").equals("boardlist")) {
				BoardDAO boardDAO = new BoardDAO();
				int page = Integer.parseInt(request.getParameter("page"));
				int count = 3;
				ArrayList<BoardDTO> boardList = boardDAO.getBoardList(page, count); // 토탈  10 / 4 올림
				if (boardList != null) {
					request.setAttribute("boardlist", boardList);
					request.setAttribute("totalcount", boardDAO.getTotalCount());
					request.setAttribute("count",count);
					
				}
				jsp = "boardlist.jsp";
			}
			else if (request.getParameter("menu").equals("boarddetail")) {
				int seq = Integer.parseInt(request.getParameter("seq"));
				BoardDAO boardDAO = new BoardDAO();
				BoardDTO boardDTO = boardDAO.getDetail(seq);
				request.setAttribute("board",boardDTO);
				jsp = "boarddetail.jsp";
			}
			else if (request.getParameter("menu").equals("boardupdate")) {
				int seq = Integer.parseInt(request.getParameter("seq"));
				String updateTitle = request.getParameter("title");
				String updateContents = request.getParameter("contents");
				BoardDAO boardDAO = new BoardDAO();
				BoardDTO dto = boardDAO.getDetail(seq);
				dto.setTitle(updateTitle);
				dto.setContents(updateContents);
				String updateResult = boardDAO.updateBoard(dto,seq);
				System.out.println(updateResult);
				jsp = "boardstart.jsp";
				//jsp = "boardstart?menu=boardlist&page=1";
			}//else
			else if (request.getParameter("menu").equals("boarddelete")) {
				int seq = Integer.parseInt(request.getParameter("seq"));
				BoardDAO boardDAO = new BoardDAO();
				String delResult = boardDAO.deleteBoard(seq);
				System.out.println(delResult);
				
				jsp = "boardstart.jsp";
			}
		}//else
		RequestDispatcher rd = request.getRequestDispatcher("/mvc/" + jsp);
		rd.forward(request, response);
		
	}//service end

}// servlet class
