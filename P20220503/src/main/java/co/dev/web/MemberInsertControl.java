package co.dev.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.dev.service.MemberService;
import co.dev.vo.MemberVO;

public class MemberInsertControl implements Control {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		System.out.println("입력처리하는 컨트롤입니다.");
		String id = request.getParameter("id");
		String ps = request.getParameter("passwd");
		String nm = request.getParameter("name");
		String em = request.getParameter("email");
		
		MemberVO vo = new MemberVO();
		vo.setId(id);
		vo.setName(nm);
		vo.setEmail(em);
		vo.setPasswd(ps);
		
		MemberService service = new MemberService();
		service.memberInsert(vo);
		
		request.setAttribute("id", id);
		request.setAttribute("name", nm);
		
		//Dispatcher 객체 forward.
		
		request.getRequestDispatcher("memberResult/memberInsertOutput.jsp").forward(request, response);
	}

}
