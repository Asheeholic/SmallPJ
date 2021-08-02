package co.micol.myHomePage.sns.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.myHomePage.common.Command;
import co.micol.myHomePage.sns.service.SnsService;
import co.micol.myHomePage.sns.serviceImpl.SnsServiceImpl;
import co.micol.myHomePage.vo.SnsVO;

public class SnsListCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 게시판 출력
		
		SnsService dao = new SnsServiceImpl();
		List<SnsVO> list = dao.snsSelectList();
		
		request.setAttribute("snsList", list);
		request.setAttribute("community", "active");
		return "sns/snsList";
	}

}
