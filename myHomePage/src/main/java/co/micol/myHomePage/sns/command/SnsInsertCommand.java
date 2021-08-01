package co.micol.myHomePage.sns.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.myHomePage.common.Command;
import co.micol.myHomePage.sns.service.SnsService;
import co.micol.myHomePage.sns.serviceImpl.SnsServiceImpl;
import co.micol.myHomePage.vo.SnsVO;

public class SnsInsertCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 게시글 입력
		
		SnsService dao = new SnsServiceImpl();
		
		String writer = request.getParameter("writer");
		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		
		SnsVO vo = new SnsVO();
		vo.setsWriter(writer);
		vo.setsTitle(title);
		vo.setsContents(contents);
		
		int result = dao.snsInsert(vo);
		
		String page = "";
		String message = "";
		if(result != 0) {
			message = "성공적으로 게시글을 입력했습니다.";
			request.setAttribute("message", message);
			page = "snsList.do";
		} else {
			message = "게시글 입력을 실패 했습니다.";
			request.setAttribute("message", message);
			page = "sns/snsInsertForm";
		}
		
		return page;
	}

}
