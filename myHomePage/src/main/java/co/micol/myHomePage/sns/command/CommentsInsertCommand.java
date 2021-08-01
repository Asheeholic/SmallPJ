package co.micol.myHomePage.sns.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.myHomePage.common.Command;
import co.micol.myHomePage.sns.service.SnsService;
import co.micol.myHomePage.sns.serviceImpl.SnsServiceImpl;
import co.micol.myHomePage.vo.SnsVO;

public class CommentsInsertCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		SnsService dao = new SnsServiceImpl();
		
		int sNo = Integer.valueOf(request.getParameter("sno"));
		String cName = request.getParameter("writer");
		String cSubject = request.getParameter("contents");
		
		SnsVO vo = new SnsVO();
		vo.setsNo(sNo);
		vo.setcName(cName);
		vo.setcSubject(cSubject);
		
		int result = dao.commentsInsert(vo);
		
		String page = "";
		String message = "";
		if(result != 0) {
			message = "성공적으로 댓글을 입력했습니다.";
			request.setAttribute("message", message);
			page = "snsSelect.do";
		} else {
			message = "게시글 입력을 실패 했습니다.";
			request.setAttribute("message", message);
			page = "snsSelect.do";
		}
		
		return page;
	}

}
