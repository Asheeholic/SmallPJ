package co.micol.myHomePage.login.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.myHomePage.common.Command;
import co.micol.myHomePage.member.service.MemberService;
import co.micol.myHomePage.member.serviceImpl.MemberServiceImpl;
import co.micol.myHomePage.vo.MemberVO;

public class MemberInsert implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 회원 등록
		MemberService dao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		
		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password"));
		vo.setName(request.getParameter("name"));
		vo.setAge(Integer.valueOf(request.getParameter("age")));
		vo.setDepartment(request.getParameter("department"));
		vo.setAuthor(request.getParameter("author"));
		int n = dao.memberInsert(vo);
		String view;
		if(n != 0) {
			request.setAttribute("message", "회원가입이 성공적으로 됐습니다");
			view = "loginform.do";
		} else {
			request.setAttribute("message", "입력이 실패 했습니다.");
			view ="login/signUpForm.jsp";
		}
		
		return view;
	}

}
