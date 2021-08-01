package co.micol.myHomePage.sns.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.micol.myHomePage.common.Command;
import co.micol.myHomePage.sns.service.SnsService;
import co.micol.myHomePage.sns.serviceImpl.SnsServiceImpl;
import co.micol.myHomePage.vo.SnsVO;

public class SnsDeleteCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("sessionId");
		
		SnsService dao = new SnsServiceImpl();
		int sNo = Integer.valueOf(request.getParameter("dno"));
		SnsVO vo = new SnsVO();
		vo.setsNo(sNo);
		vo.setId(id);
		
		int result = dao.snsDelete(vo);
		
		String page = "";
		String message = "";
		if(result != 0) {
			message = "성공적으로 게시글을 삭제했습니다.";
			request.setAttribute("message", message);
			page = "snsList.do";
		} else {
			message = "게시글 삭제를 실패했습니다. 작성한 아이디가 다릅니다.";
			request.setAttribute("message", message);
			page = "snsList.do";
		}
		
		return page;
	}

}
