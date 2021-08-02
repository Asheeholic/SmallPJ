package co.micol.myHomePage.exam.command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.myHomePage.common.Command;
import co.micol.myHomePage.exam.service.ExamService;
import co.micol.myHomePage.exam.serviceImpl.ExamServiceImpl;
import co.micol.myHomePage.vo.ExamVO;

public class ExamListCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
		ExamService dao = new ExamServiceImpl();
		
		List<ExamVO> list = dao.examSelectList();
		
		request.setAttribute("examList", list);
		request.setAttribute("examListPage", "active");
		return "exam/examList";
	}

}
