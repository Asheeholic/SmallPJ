package co.micol.myHomePage.login.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.myHomePage.common.Command;

public class SignUpForm implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 회원가입 폼으로 이동 
		return "login/signUpForm.jsp";
	}

}
