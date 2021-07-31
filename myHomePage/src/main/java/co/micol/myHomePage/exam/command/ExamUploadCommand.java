package co.micol.myHomePage.exam.command;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import co.micol.myHomePage.common.Command;

public class ExamUploadCommand implements Command {
	
	private static final String UPLOAD_DIR = "D:\\";
	private static final int MEMORY_TRESHOLD = 1024 * 1024 * 3; // 3mb
	private static final long MAX_FILE_SIZE = 1024 * 1024 * 100; // 100mb
	private static final long MAX_REQUEST_SIZE = 1024 * 1024 * 100; // 100mb
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO 
		if(ServletFileUpload.isMultipartContent(request)) {
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(MEMORY_TRESHOLD);
			
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setFileSizeMax(MAX_FILE_SIZE);
			upload.setSizeMax(MAX_REQUEST_SIZE);
			String uploadPath = UPLOAD_DIR;
			
			try {
				List<FileItem> formItems = upload.parseRequest(request);
				if(formItems != null && formItems.size() > 0) {
					for(FileItem item : formItems) {
						if(!item.isFormField()) {
							String fileName = new File(item.getName()).getName();
							
							String filePath = uploadPath + File.separator + fileName;
							
							File storeFile = new File(filePath);
							item.write(storeFile);
							request.setAttribute("message", "업로드 완료됨. => "+ fileName);
							System.out.println("동작되고 " + fileName);
						
						} //if
					} //for
				}
			} catch (Exception e) {
				request.setAttribute("message", "업로드가 실패됨. => "+ e.getMessage());
				e.printStackTrace();
			}
			
		}
		
		
		
		return "exam/examUploadSuccess.jsp";
	}

}
