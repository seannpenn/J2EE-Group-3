package Group3.Group3prelims.FileUpload.controller;


import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import Group3.Group3prelims.FileUpload.entity.File;
import Group3.Group3prelims.FileUpload.service.FileService;
import Group3.Group3prelims.common.models.ApiResponse;
import Group3.Group3prelims.message.AppMessages;
import Group3.Group3prelims.user.entity.User;

/**
 * Controller that will handle fileUpload (sample)
 */
@RestController
@MultipartConfig(
		maxFileSize = 1024 * 1024 * 40,        // 40 MB
		maxRequestSize = 1024 * 1024 * 30      // 30 MB
		)
@CrossOrigin("*")
public class FileUploadController {
	/**
	 * View Name
	 */
	@Autowired
	private FileService fileService;
	public static final String VIEW_PATH = "/uploadFile.html";
	
	/**
	 * Upload 
	 */
	private static final String UPLOAD_PATH = "D:\\test\\";
	
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
	@PostMapping("/file/create")
	@ResponseBody
	
	public File save(File file) throws IOException {

		File savedFile = fileService.saveFile(file);
		
		return savedFile;
	}
	
	@PostMapping("/sampleUpload")
	@ResponseBody
	public ApiResponse process(final HttpServletRequest request) throws IOException
	{
		
		try {
			
			final Part part = request.getPart("file");
			
			String ticketID = request.getParameter("ticketID");
			String type = request.getParameter("type");
			
			
			System.out.println(ticketID);
			System.out.println(type);
			
			File file = new File();
			file.setPath(UPLOAD_PATH + getFileName(part));
			System.out.println(file.getPath());
			file.setTicketID(Integer.parseInt(ticketID.toString()));
			file.setType(Integer.parseInt(type.toString()));
			part.write(UPLOAD_PATH + getFileName(part));
			
			File savedFile = fileService.saveFile(file);
			
			if (savedFile != null) {
				return ApiResponse.CreateSuccess(savedFile, AppMessages.FILE_SUCCESSFULLY_SAVED);
			}

			return ApiResponse.CreateError(AppMessages.GENERIC_UNSUCCESSFUL_SAVE);
			
		} catch (final IOException | ServletException exception) {
			System.out.println("Message:" + exception.getMessage() + " Cause: " +  exception.getCause());
			
			File fileInside = null;
			return ApiResponse.CreateError(AppMessages.GENERIC_UNSUCCESSFUL_SAVE);
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
	@GetMapping("/files/all")
	@ResponseBody
	public ApiResponse getllAllFiles() {
		List<File> allFiles = fileService.getAllFiles();
		if (allFiles != null) {
			return ApiResponse.CreateSuccess(allFiles, AppMessages.USER_SUCCESSFULLY_SAVED);
		}
		return ApiResponse.CreateError(AppMessages.GENERIC_UNSUCCESSFUL_RETRIEVED);
	}
}
