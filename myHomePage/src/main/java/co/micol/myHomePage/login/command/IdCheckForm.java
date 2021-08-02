package co.micol.myHomePage.login.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.myHomePage.common.Command;

public class IdCheckForm implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO id중복 체크 폼
		request.setAttribute("checkId", request.getParameter("id"));
		return "login/idCheckForm.jsp";
	}

}
