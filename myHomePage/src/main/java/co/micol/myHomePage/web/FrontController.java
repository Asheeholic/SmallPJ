package co.micol.myHomePage.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.myHomePage.command.HomeCommand;
import co.micol.myHomePage.common.Command;
import co.micol.myHomePage.exam.command.ExamDownloadCommand;
import co.micol.myHomePage.exam.command.ExamFormCommand;
import co.micol.myHomePage.exam.command.ExamListCommand;
import co.micol.myHomePage.exam.command.ExamUploadCommand;
import co.micol.myHomePage.login.command.LoginCommand;
import co.micol.myHomePage.login.command.LoginformCommand;
import co.micol.myHomePage.login.command.MemberInsert;
import co.micol.myHomePage.login.command.SignUpFormCommand;
import co.micol.myHomePage.member.command.LogoutCommand;
import co.micol.myHomePage.member.command.MeberSelectCommand;
import co.micol.myHomePage.member.command.MemberListCommand;
import co.micol.myHomePage.sns.command.SnsListCommand;
import co.micol.myHomePage.sns.command.SnsSelectCommand;
import co.micol.myHomePage.member.command.idCheckForm;

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
		map.put("/loginform.do", new LoginformCommand()); // 로그인폼 이동
		map.put("/login.do", new LoginCommand());
		map.put("/logout.do", new LogoutCommand());
		map.put("/signUpForm.do", new SignUpFormCommand());
		map.put("/memberInsert.do", new MemberInsert());
		map.put("/idCheckForm.do", new idCheckForm());
	
		map.put("/home.do", new HomeCommand());
		map.put("/memberList.do", new MemberListCommand()); // 회원(학생,교수) 전체정보
		map.put("/memberSelect.do", new MeberSelectCommand());

		map.put("/examForm.do", new ExamFormCommand());
		map.put("/examUpload.do", new ExamUploadCommand());
		map.put("/examList.do", new ExamListCommand());
		map.put("/examDownload.do", new ExamDownloadCommand());
		
		map.put("/snsList.do", new SnsListCommand());
		map.put("/snsSelect.do", new SnsSelectCommand());
	
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
			if (!viewPage.endsWith(".jsp")) {
				viewPage = viewPage + ".tiles"; // home/home 타일즈
			} else {
				viewPage = "/WEB-INF/views/" + viewPage; // home/home.jsp 타일즈 안탐
			}
		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);

	}

}
