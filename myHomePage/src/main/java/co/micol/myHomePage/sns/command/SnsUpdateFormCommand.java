package co.micol.myHomePage.sns.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.myHomePage.common.Command;
import co.micol.myHomePage.sns.service.SnsService;
import co.micol.myHomePage.sns.serviceImpl.SnsServiceImpl;
import co.micol.myHomePage.vo.SnsVO;

public class SnsUpdateFormCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		SnsService dao = new SnsServiceImpl();
		String sno = request.getParameter("uno");
		
		List<SnsVO> list = dao.snsSelectAndCommentsList(sno);
		request.setAttribute("snsDetail", list);
		
		return "sns/snsUpdateForm";
	}

}
