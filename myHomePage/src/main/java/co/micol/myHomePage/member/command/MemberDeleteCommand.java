package co.micol.myHomePage.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.myHomePage.common.Command;
import co.micol.myHomePage.member.service.MemberService;
import co.micol.myHomePage.member.serviceImpl.MemberServiceImpl;
import co.micol.myHomePage.vo.MemberVO;

public class MemberDeleteCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 회원 삭제 구문
		MemberService dao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		
		vo.setId(request.getParameter("id"));
		int n = dao.memberDelete(vo);
		System.out.println("너는 누구니?" + n);	
		String page="";
		if(n != 0) {
			page ="memberList.do";
		}else {
			page ="home/Error";
		}
		return page;
		
	}

}
