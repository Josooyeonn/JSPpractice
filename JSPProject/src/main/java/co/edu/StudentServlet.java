package co.edu;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// IOC : Introversion Of Control
public class StudentServlet extends HttpServlet {
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() 호출.");
		// 제일 처음 로딩될 때 한번만 호출
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// resp :응답정보 req : 요청정보
		resp.setContentType("text/html;charset=UTF-8");

		PrintWriter out = resp.getWriter(); // 출력스트림 생성
		String method = req.getMethod();
		out.print("<h3>Student Sample page.</h3>");
		
		if (method.equals("GET")) {
			out.print("<h3>Get방식 호출</h3>");

		} else if (method.equals("POST")) {
			out.print("<h3>Post방식 호출</h3>");
		}

		out.print("<a href='../index.jsp>index page</a>");
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

	@Override
	public void destroy() {
		System.out.println("destory() 호출");
	}

	// init() -> service -> destroy() ::서버가 끝날때 destroy() 실행

}