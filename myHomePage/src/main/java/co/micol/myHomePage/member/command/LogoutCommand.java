package co.micol.myHomePage.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.myHomePage.common.Command;

public class LogoutCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		//로그아웃 영역
		HttpSession session = request.getSession();
		System.out.println(session.getAttribute("id"));
		session.invalidate();
		
//		session.removeAttribute("sessionName");
//		session.removeAttribute("sessionAuthor");
//		session.removeAttribute("sessionId");
//		session.removeAttribute("session");
		System.out.println(session);
		return "login/loginform.jsp";
	}

}
