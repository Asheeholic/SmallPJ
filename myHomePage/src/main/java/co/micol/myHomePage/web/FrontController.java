package co.micol.myHomePage.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.myHomePage.command.HomeCommand;
import co.micol.myHomePage.common.Command;
import co.micol.myHomePage.exam.command.ExamFormCommand;
import co.micol.myHomePage.exam.command.ExamUploadCommand;
import co.micol.myHomePage.member.command.MeberSelectCommand;
import co.micol.myHomePage.member.command.MemberListCommand;

/**
 * Servlet implementation class FrontController
 */
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, Command> map = new HashMap<String, Command>();

	/**
	 * @see HttpServlet#HttpServlet() 프론트 컨트롤러
	 */
	public FrontController() {
		super();
	}

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {

		map.put("/home.do", new HomeCommand());
		map.put("/memberList.do", new MemberListCommand()); //회원(학생,교수) 전체정보
		map.put("/memberSelect.do", new MeberSelectCommand());
		
		map.put("/examForm.do", new ExamFormCommand());
		map.put("/examUpload.do", new ExamUploadCommand());
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.setCharacterEncoding("utf-8");

		String path = request.getServletPath();

		Command command = map.get(path);
		String viewPage = command.execute(request, response);

		if (!viewPage.endsWith(".do")) {
			if(!viewPage.endsWith(".jsp")) {
				viewPage = viewPage + ".tiles"; // home/home 타일즈
			} else {
				viewPage = "/WEB-INF/views/" + viewPage; // home/home.jsp 타일즈 안탐
			}
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);

	}

}
