package co.edu;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@WebServlet("/StudentGetServlet")
public class StudentGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public StudentGetServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		// plain : 텍스트 형식으로 뿌려줌, json : json포멧

		// GET : cmd = search, cmd = null -> JSON 반환
		String cmd = request.getParameter("cmd");
		System.out.println("cmd : " + cmd);

		// 한건조회
		if (cmd != null && cmd.equals("search")) {

			String id = request.getParameter("user_id");
			StudentDAO dao = new StudentDAO();
			Student student = dao.searchStudent(id);
			if (student != null) {
				// student에 list가 들어갔기 때문에 student를 값으로 넣어야함.
				response.getWriter().println("<h3>학생번호 : " + student.getStudentNo() + "</h3>");
				response.getWriter().println("<h3>이름 : " + student.getStudentName() + "</h3>");
				response.getWriter().println("<form name='frm' action='StudentGetServlet' method='post'>"
						+ "영어점수 : <input type='text' name='eng_score' value =" + student.getEngScore() + " ><br><br>");// input
				response.getWriter().println("국어점수 : <input type='text' name='kor_score' value =" + student.getKorScore() + "><br><br>");// input
				response.getWriter()
						.println("<input type = 'hidden' name = 'user_id' value=" + student.getStudentNo() + ">");
				response.getWriter()
						.println("<input type='hidden' name = 'user_name' value=" + student.getStudentName() + ">");

				response.getWriter().println("<input type='hidden' name='cmd' value='mod'><input type='submit' value='수정'>");
				response.getWriter().println("<br><br></form>");
				
			} else {
				response.getWriter().print("<script>alert('조회된 데이터가 없습니다.')</script>");
			}
		} else if (cmd != null && cmd.equals("listBtn")) {
			// 전체조회
			response.sendRedirect("studentList.jsp");
		} else {

			response.setContentType("text/json;charset=utf-8");
			StudentDAO dao = new StudentDAO();
			List<Student> list = dao.studentList();
			// [{},{},{}]
			Gson gson = new GsonBuilder().create();
			response.getWriter().print(gson.toJson(list));
			// 오브젝트 호출
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 한글처리
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		String cmd = request.getParameter("cmd");
		if (cmd != null && cmd.equals("add")) { // 입력.

			StudentDAO dao = new StudentDAO();
			Student stud = new Student();

			String id = request.getParameter("user_id");
			String name = request.getParameter("user_name");
			String eng = request.getParameter("eng_score");
			String kor = request.getParameter("kor_score");

			stud.setStudentNo(Integer.parseInt(id));
			stud.setStudentName(name);
			stud.setEngScore(Integer.parseInt(eng));
			stud.setKorScore(Integer.parseInt(kor));

			dao.addStudent(stud);

			response.getWriter().print("입력성공");
			response.sendRedirect("studentList.jsp");

		} else if (cmd != null && cmd.equals("del")) {
			String id = request.getParameter("user_id");
			StudentDAO dao = new StudentDAO();
			if (dao.removeStudent(id)) {
				response.getWriter().print("<script>alert('삭제성공')</script>");
			} else {
				response.getWriter().print("<script>alert('삭제실패')</script>");
			}

		} else if (cmd != null && cmd.equals("mod")) {
			// 사용자 입력 파라메터 =>
			Student stud = new Student();

			String id = request.getParameter("user_id");
			String name = request.getParameter("user_name");
			String eng = request.getParameter("eng_score");
			String kor = request.getParameter("kor_score");

			stud.setStudentNo(Integer.parseInt(id));
			stud.setStudentName(name);
			stud.setEngScore(Integer.parseInt(eng));
			stud.setKorScore(Integer.parseInt(kor));

			StudentDAO dao = new StudentDAO();
			dao.modifyStudent(stud);
		}
		// studentList.jsp로 페이지를 재 지정 하겠습니다.
		response.sendRedirect("studentList.jsp");
	} // end of doPost()

} // end of class