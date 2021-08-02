package co.micol.myHomePage.exam.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.myHomePage.common.Command;

public class ExamFormCommand implements Command {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// 시험 폼 출력
		
		request.setAttribute("examSubmitPage", "active");
		return "exam/examForm";
	}

}
