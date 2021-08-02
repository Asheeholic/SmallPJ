package co.micol.myHomePage.sns.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.myHomePage.common.Command;
import co.micol.myHomePage.sns.service.SnsService;
import co.micol.myHomePage.sns.serviceImpl.SnsServiceImpl;
import co.micol.myHomePage.vo.SnsVO;

public class SnsSelectCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 가져온 번호로 출력
		
//		HttpSession session = request.getSession();
//		String sessionId = (String) request.getAttribute("sessionId");
		
		
		SnsService dao = new SnsServiceImpl();
		
		String sno = request.getParameter("sno");
		
		List<SnsVO> list = dao.snsSelectAndCommentsList(sno);
		
		request.setAttribute("snsDetail", list);
//		request.setAttribute("sessionId", sessionId);
		
		return "sns/snsSelect";
	}

}
