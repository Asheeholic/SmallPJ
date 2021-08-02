package co.micol.myHomePage.member.service;

import java.util.List;

import co.micol.myHomePage.vo.MemberVO;

public interface MemberService {
	
	List<MemberVO> memberSelectList(); //전체조회 (R)
	
	MemberVO memberSelect(MemberVO vo); //한건 조회(R)
	
	MemberVO memberLogin(MemberVO vo); // 로그인
	
	int memberIdCheck(String id); //중복아이디 체크 
	int memberInsert(MemberVO vo); //회원(학생,교수) 가입
	int memberUpdate(MemberVO vo); //회원(학생,교수) 수정
	int memberDelete(MemberVO vo); //회원(학생,교수) 삭제<관리자만>
	
	
}
