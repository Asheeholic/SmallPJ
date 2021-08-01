package co.micol.myHomePage.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.myHomePage.common.Command;
import co.micol.myHomePage.member.service.MemberService;
import co.micol.myHomePage.member.serviceImpl.MemberServiceImpl;
import co.micol.myHomePage.vo.MemberVO;

public class MemberUpdateFormCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 회원 수정으로 이동
		request.setAttribute("id", request.getParameter("id"));
		request.setAttribute("password", request.getParameter("password"));
		request.setAttribute("name", request.getParameter("name"));
		request.setAttribute("age", Integer.valueOf(request.getParameter("age")));
		request.setAttribute("department", request.getParameter("department"));
		request.setAttribute("author", request.getParameter("author"));
		
		return "member/memberUpdateForm";
		
	}

}
