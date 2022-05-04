package co.dev.service;

import java.util.List;

import co.dev.dao.MemberDAO;
import co.dev.vo.MemberVO;

public class MemberService {
	MemberDAO dao = new MemberDAO(); //DB CRUD 작업.
	
	public MemberVO memberSearch(String id) {
		return dao.searchMember(id);
	}
	
	public void memberInsert(MemberVO member) {
		dao.insertMember(member);
	}
	
	public List<MemberVO> memberList(){
		return dao.listMember();
	}
	
	public void memberDelete(String id) {
		dao.deleteMember(id);
	}
	
	public void memberUpdate(MemberVO member) {
		dao.updateMember(member);
		
	};
	
	
}
