package co.dev.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@WebServlet("/fileUploadServlet")
public class fileUploadServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public fileUploadServ() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String saveDir = "upload";
		saveDir = getServletContext().getRealPath(saveDir);
		int maxSize = 1024 * 1024 * 10; // 5MB
		String encoding = "UTF-8";
		// multipart 요청
		// request(요청정보), 저장위치, Maxsize(최대사이즈), 인코딩 방식, 리네임정책(file.jpg, file1.jpg...)
		MultipartRequest multi = new MultipartRequest(request, saveDir, maxSize, encoding, new DefaultFileRenamePolicy());
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");

		title = multi.getParameter("title");
		content = multi.getParameter("content");
		String profile = multi.getOriginalFileName("profile");
		String fileName = multi.getOriginalFileName("profile");
		System.out.println(
				"title : " + title + ", content : " + content + ", profile : " + profile + ", file : " + fileName);
	}

}
