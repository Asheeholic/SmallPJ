package co.micol.myHomePage.login.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.myHomePage.common.Command;
import co.micol.myHomePage.member.service.MemberService;
import co.micol.myHomePage.member.serviceImpl.MemberServiceImpl;
import co.micol.myHomePage.vo.MemberVO;

public class IdCheckCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 아이디 중복 체크
		MemberService dao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		
		vo.setId(request.getParameter("checkId"));
		int n = dao.memberIdCheck(vo.getId());
		
		if(n == 0) {
			request.setAttribute("message", "사용할 수 없는 아이디 입니다.");	
		} else {
			request.setAttribute("message", "사용할 수 있는 아이디 입니다.");	
			
		}
		return "login/idCheckResult.jsp";
	}

}
