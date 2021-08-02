package co.micol.myHomePage.login.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.myHomePage.common.Command;
import co.micol.myHomePage.member.service.MemberService;
import co.micol.myHomePage.member.serviceImpl.MemberServiceImpl;
import co.micol.myHomePage.vo.MemberVO;

public class LoginCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 로그인 과정 처리하는 장소

		MemberService dao = new MemberServiceImpl();
		MemberVO vo = new MemberVO();
		HttpSession session = request.getSession();
		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password"));
		vo = dao.memberLogin(vo);
		System.out.println("Login.....");
		char s = 'Y';
		String page = "";
		// 권한
		System.out.println();
		if (vo.getName() != null ) {
			session.setAttribute("sessionName", vo.getName());
			session.setAttribute("sessionAuthor", vo.getAuthor());
			session.setAttribute("sessionId", vo.getId());
			page = "home/home";
			System.out.println("로그인 성공!!!");
		} else {
			String message = "존재하지 않는 아이디 또는 패스워드가 틀립니다.";
			request.setAttribute("message", message);
			page = "login/loginform.jsp";
			System.out.println("로그인 실패");
		}
		return page;
	}

}
