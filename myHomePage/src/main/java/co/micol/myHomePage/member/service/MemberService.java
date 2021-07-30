package co.micol.myHomePage.member.service;

import java.util.List;

import co.micol.myHomePage.vo.MemberVO;

public interface MemberService {
	
	List<MemberVO> memberSelectList();
	
	MemberVO memberSelect(MemberVO vo);
	
	MemberVO memberLogin(MemberVO vo);
	
	int memberInsert(MemberVO vo);
	int memberUpdate(MemberVO vo);
	int memberDelete(MemberVO vo);
	
	
}
