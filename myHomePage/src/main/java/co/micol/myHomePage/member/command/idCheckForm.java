package co.micol.myHomePage.member.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.myHomePage.common.Command;

public class idCheckForm implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 로그인 체크 창으로 이동
		
		
		return "login/idCheckForm.jsp";
	}

}
