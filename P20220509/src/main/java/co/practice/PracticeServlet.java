package co.practice;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/PracticeServlet")
public class PracticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PracticeServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/json; charset=utf-8");

		PracticeDAO dao = new PracticeDAO();
		List<practiceVO> list = dao.getList();

		Gson gson = new GsonBuilder().create();
		response.getWriter().print(gson.toJson(list));

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String job = request.getParameter("job");
		PracticeDAO dao = new PracticeDAO();
		if(job.equals("insert")) {
			String List
		}
	}

}
