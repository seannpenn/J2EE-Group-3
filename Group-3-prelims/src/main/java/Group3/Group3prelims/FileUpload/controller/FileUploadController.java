package Group3.Group3prelims.FileUpload.controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller that will handle fileUpload (sample)
 */
@RestController
@MultipartConfig(
		maxFileSize = 1024 * 1024 * 40,        // 40 MB
		maxRequestSize = 1024 * 1024 * 30      // 30 MB
		)
public class FileUploadController {
	/**
	 * View Name
	 */
	public static final String VIEW_PATH = "/uploadFile.html";
	
	/**
	 * Upload 
	 */
	private static final String UPLOAD_PATH = "D:\\uploadhere\\";
	
	/**
	 * Loads the display page
	 * @return ModelAndView object
	 */
	@GetMapping("/sampleUpload")
	public ModelAndView execute()
	{
		return new ModelAndView(VIEW_PATH);
	}
	
	/**
	 * Handles the upload request
	 * 
	 * @param request           used to get the Part
	 * @return A string         which contains a message (failure/success)
	 * @throws IOException      getPart and other HttpServletRequest usages might throw an Exception
	 * @throws ServletException getPart and other HttpServletRequest usages might throw an Exception
	 */
	@PostMapping("/sampleUpload")
	public String process(final HttpServletRequest request) throws IOException, ServletException
	{
		try {
			final Part part = request.getPart("file");
			part.write(UPLOAD_PATH + getFileName(part));
			
			return "Upload success";
		} catch (final IOException | ServletException exception) {
			System.out.println("Message:" + exception.getMessage() + " Cause: " +  exception.getCause());
			
			return "Upload failure";
		}
	
	}
	
	/**
	 * Gets the file name
	 * 
	 * @param part used to get the fileName
	 * @return file name
	 */
	private String getFileName(final Part part)
	{
		final String contentDisposition = part.getHeader("content-disposition");
		
		if (!contentDisposition.contains("filename=")) {
			return null; // no valid file can be uploaded
		}
		
		final int beginIndex = contentDisposition.indexOf("filename=") + 10;
		final int endIndex = contentDisposition.length() - 1;
		
		return contentDisposition.substring(beginIndex, endIndex);
	}
}
