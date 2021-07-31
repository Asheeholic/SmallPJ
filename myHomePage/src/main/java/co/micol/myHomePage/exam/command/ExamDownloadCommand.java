package co.micol.myHomePage.exam.command;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.myHomePage.common.Command;

public class ExamDownloadCommand implements Command {
	private static final String DOWNLOAD_DIR = "D:/";

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		
		String fileName = request.getParameter("fileName");
		
		response.setContentType("application/octet-stream");
		response.setHeader("Content-disposition", "attachment; filename=\"" + fileName + "\"");
		
		try {
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(DOWNLOAD_DIR + fileName));
			BufferedOutputStream bos = new BufferedOutputStream(response.getOutputStream());
			
			int readBytes = 0;
			while ((readBytes = bis.read()) != -1) {
				bos.write(readBytes);
			}
			
			bis.close();
			bos.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return null;
	}

}
