package co.micol.myHomePage.login.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		return null;
	}

}
