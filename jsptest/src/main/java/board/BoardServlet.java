package board;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/board")
public class BoardServlet extends HttpServlet {
	ArrayList<BoardDTO> boardlist;
	//http://ip:port/jsptest/bord
   //http://ip:port/jsptest/bord?action=list
	//http://ip:port/jsptest/board?action=write&userid=testid 
	//http://ip:port/jsptest/board?action=detail&seq=1
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String jspfile = "";
		//1. action 파라미터 값 읽자
		String action = req.getParameter("action");
		if(action == null || action.equals("list")) {
			req.setAttribute("boardlist", boardlist);//forward된 파일까지 공유
			jspfile="/board/boardlist.jsp";
		}
		//2. write  이면 userid 파라미터 값 읽자
		else if(action.equals("write") && req.getParameter("userid")!= null) {
			HttpSession session = req.getSession();
			session.setAttribute("userid", req.getParameter("userid"));//forward파일+동일 브라우저 동작 파일들 공유
			jspfile = "/board/boardwriteform.jsp";
		}
		//3. detail 이면 seq 파라미터 값 읽자
		else if(action.equals("detail") && req.getParameter("seq")!= null) {
			int seq = Integer.parseInt(req.getParameter("seq"));
			for(BoardDTO dto : boardlist) {
				if(dto.getSeq() == seq) { //board내부에서 seq 중복 게시물 없다 가정하고
					req.setAttribute("board", dto);
					break;
				}
			}
			jspfile = "/board/boarddetail.jsp";
		}
		
		RequestDispatcher rd =  req.getRequestDispatcher(jspfile);
		rd.forward(req, resp);
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		boardlist = new ArrayList();
		boardlist.add(new BoardDTO(1, "게시물1", "게시물 1의 내용입니다", "id1"));
		boardlist.add(new BoardDTO(2, "게시물2", "게시물 2의 내용입니다", "id2"));
		boardlist.add(new BoardDTO(3, "게시물3", "게시물 3의 내용입니다", "id3"));
		boardlist.add(new BoardDTO(4, "게시물4", "게시물 4의 내용입니다", "id4"));
		boardlist.add(new BoardDTO(5, "게시물5", "게시물 5의 내용입니다", "id5"));
		Map<String, String[]> category = new HashMap();
		category.put("의류", new String[] {"남성의류", "여성의류","아동의류","유아의류","스포츠의류"});
		category.put("식품", new String[] {"냉동", "과일","축산","음료","과자"});
		category.put("가전", new String[] {"소형가전", "주방가전","오디오/비디오"});
		category.put("학용품", new String[] {"미술용품", "필기류","포장지류"});
	}

}








