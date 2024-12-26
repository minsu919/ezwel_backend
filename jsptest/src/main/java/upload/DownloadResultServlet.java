package upload;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;


@WebServlet("/downloadresult")
public class DownloadResultServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fileName = request.getParameter("filename");
		String filePath = "c:\\ezwel\\upload\\" + fileName;
		FileInputStream in = new FileInputStream(filePath);
		byte b[] = new byte[4096];
		
		response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
		OutputStream out = response.getOutputStream();
		while (true) {
			int numRead = in.read(b,0,b.length);
			if (numRead == -1) break;
			out.write(b,0,numRead);
		}
		out.close();
		in.close();
	}

}
