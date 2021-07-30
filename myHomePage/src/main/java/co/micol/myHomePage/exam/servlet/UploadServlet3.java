package co.micol.myHomePage.exam.servlet;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class UploadServlet3
 */
@WebServlet(name="UploadServlet3", urlPatterns= {"/UploadServlet3"})
@MultipartConfig(
		fileSizeThreshold = 1024*1024,
		maxFileSize = 1024*1024*5,
		maxRequestSize = 1024*1024*5*5)
public class UploadServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final String UPLOAD_DIR = "upload_files";
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String uploadPath = getServletContext().getRealPath("D:\\") + File.separator + UPLOAD_DIR;
		
		File uploadDir = new File(uploadPath);
		
		if(!uploadDir.exists()) {
			uploadDir.mkdir();
		}
		
		try {
			String fileName = "";
			for(Part part : request.getParts()) { // req.getParts() : Multipart데이터들을 Part객체로 리턴
				System.out.println(part.getHeader(fileName));
				if(fileName != null && !"".equals(fileName)) {
					part.write(uploadPath + File.separator + fileName);
					System.out.println("파일명: " + fileName + "저장완료!!!");
			
				}
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		System.out.println("파라미터 값 : " + request.getParameter("sender"));
		response.setContentType("text/html");
		response.getWriter().println("업로드 완료...!!");
	}
		
		/**
		 * param 객체를 파싱하여 파일이름 추출하기
		 * @param part
		 * @return 파일명: 파일명이 존재하지 않으면 null (폼필드 데이터)
		 */
		// 헤더 예시
		// form-data; name="multiPartServlet"; filename="git command.txt"
		
	private String getFileName(Part part) {
		for(String content : part.getHeader("content-disposition").split(";")) {
			if(content.trim().startsWith("filename")) {
				return content.substring(content.indexOf("=")+2, content.length()-1);
			}
		}
		return null;
	}
		

}
