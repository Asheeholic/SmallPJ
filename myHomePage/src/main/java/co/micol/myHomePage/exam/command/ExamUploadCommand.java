package co.micol.myHomePage.exam.command;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import co.micol.myHomePage.common.Command;
import co.micol.myHomePage.exam.service.ExamService;
import co.micol.myHomePage.exam.serviceImpl.ExamServiceImpl;
import co.micol.myHomePage.vo.ExamVO;

public class ExamUploadCommand implements Command {
	
	private static final String UPLOAD_DIR = "D:\\";
	private static final int MEMORY_TRESHOLD = 1024 * 1024 * 3; // 3mb
	private static final long MAX_FILE_SIZE = 1024 * 1024 * 100; // 100mb
	private static final long MAX_REQUEST_SIZE = 1024 * 1024 * 100; // 100mb
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 
		
		//request.getParameter로 꺼낼수 없어서 map넣고 씀
		Map<String, String> formMap = new HashMap<String, String>();
		
		if(ServletFileUpload.isMultipartContent(request)) {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(MEMORY_TRESHOLD);
			
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setFileSizeMax(MAX_FILE_SIZE);
			upload.setSizeMax(MAX_REQUEST_SIZE);
			String uploadPath = UPLOAD_DIR;
			String fileName = null;
			
			try {
				List<FileItem> formItems = upload.parseRequest(request);
				if(formItems != null && formItems.size() > 0) {
					for(FileItem item : formItems) {
						if(!item.isFormField()) {
							fileName = new File(item.getName()).getName();
							
							String filePath = uploadPath + File.separator + fileName;
							
							File storeFile = new File(filePath);
							item.write(storeFile);
							
							
							request.setAttribute("message", "업로드 완료됨. => "+ fileName);
							System.out.println("동작되고 " + fileName);
						
						} else {
							//폼을 담아줌
							formMap.put(item.getFieldName(), item.getString("UTF-8"));
						}
						//if
					} //for
				}
			} catch (Exception e) {
				request.setAttribute("message", "업로드가 실패됨. => "+ e.getMessage());
				e.printStackTrace();
			}
			
			//맵을 통해서 폼에있는 파라미터들을 보여줌
			for(Entry<String, String> entry : formMap.entrySet()) {
				System.out.println("파라미터명: " + entry.getKey());
				System.out.println("파라미터값: " + entry.getValue());
			}
			
			System.out.println("꺼내짐 : " + formMap.get("id"));
			System.out.println("안꺼내짐 : " + request.getParameter("id"));
			
			//이것이 text타입 폼을 출력해주는것.
			request.setAttribute("sender", "보낸사람 : " + formMap.get("sender"));
			
			
			
			//dao 연결해서 db에 보관하기
			ExamService dao = new ExamServiceImpl();
			String id = formMap.get("id");
			ExamVO vo = new ExamVO();
			vo.setId(id);
			vo.setFilePath(fileName);
			
			int result = dao.examInsert(vo);
			String page = "";
			if(result != 0) {
				page = "exam/examForm";
				request.setAttribute("message", "업로드를 성공했습니다!");
			} else {
				page = "home/Error.jsp";
				request.setAttribute("message", "업로드를 실패했거나 비정상적 접근입니다.");
			}
			
		}
		
		
		
		return "exam/examForm";
	}

}
