package co.micol.myHomePage.member.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.myHomePage.common.Command;
import co.micol.myHomePage.member.service.MemberService;
import co.micol.myHomePage.member.serviceImpl.MemberServiceImpl;
import co.micol.myHomePage.vo.MemberVO;

public class MemberListCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		MemberService dao = new MemberServiceImpl();
		
		List<MemberVO> list = dao.memberSelectList();
		
		request.setAttribute("memberList", list);
		
		return "member/memberList";
	}

}
