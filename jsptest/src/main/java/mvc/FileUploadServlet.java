package mvc;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.UUID;

/**
 * Servlet implementation class FileUploadServlet
 */
@WebServlet("/boardupload")
@MultipartConfig(location="C:/ezwel/board/", maxFileSize = 1024 * 1024, maxRequestSize = 1024 * 1024 * 5 * 5)
//"C:\\ezwel\\workspace_backend\\jsptest\\src\\main\\webapp\\files"
public class FileUploadServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		//업로드한 파일 저장 경로. 만약 경로가 없으면 자동 생성
		String path = "C:\\ezwel\\board\\";
		File isDir = new File(path);
		if (!isDir.isDirectory()) {
			isDir.mkdir();
		}
		Collection<Part> parts = request.getParts();
		for (Part part : parts) {
			
			
			if (part.getContentType() != null) {
				String fileName = part.getSubmittedFileName(); // fullstackdb_시간.sql
				fileName = fileName.toLowerCase();
				if (fileName.endsWith(".pdf") || fileName.endsWith(".docx") || fileName.endsWith(".hwp")
				|| fileName.endsWith(".txt") || fileName.endsWith(".jpg") || fileName.endsWith(".png")
				|| fileName.endsWith(".gif") || fileName.endsWith(".xls")) {
					
				/*fileName = 
					fileName.substring(0, fileName.indexOf(".")) //fullstackdb
					+ "_" + UUID.randomUUID().toString()
					+ fileName.substring(fileName.indexOf(".")); // sql
				
				out.println("<br>" + part.getContentType());
				out.println("<br>" + part.getSubmittedFileName());
				out.println("<br>" + part.getSize());
				out.println(part.getHeader("content-disposition"));
				*/
				part.write(fileName);
				BoardDTO dto = (BoardDTO)request.getAttribute("dto");
				dto.setFile1(fileName);
				request.setAttribute("dto", dto);
				} // 확장자 검증 if end
			} else {
				String partName = part.getName();
				String fileValue = request.getParameter(partName);
				out.println("<br>" + partName + " : " + fileValue);
			}
		}
		
		
	}

}
