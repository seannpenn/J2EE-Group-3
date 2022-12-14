package Group3.Group3prelims.user.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Group3.Group3prelims.CsvExport.service.ExportService;
import Group3.Group3prelims.common.models.ApiResponse;
import Group3.Group3prelims.message.AppMessages;
import Group3.Group3prelims.ticket.entity.Ticket;
import Group3.Group3prelims.ticket.service.TicketService;
import Group3.Group3prelims.user.entity.User;
import Group3.Group3prelims.user.service.UserService;

@RestController
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	
	private UserService userService;
	private final ExportService csvExportService;
	public UserController(final ExportService csvExportService)
	{
		this.csvExportService = csvExportService;
	}

	@PostMapping("/user/create")
	@ResponseBody
	
	public ApiResponse save(User user) throws IOException {

		User savedUser = userService.saveUser(user);
		
		if (savedUser != null) {
			return ApiResponse.CreateSuccess(savedUser, AppMessages.USER_SUCCESSFULLY_SAVED);
		}

		return ApiResponse.CreateError(AppMessages.GENERIC_UNSUCCESSFUL_SAVE);
	}
	
	@PutMapping("/user/update")
	@ResponseBody
	public ApiResponse update(User user) throws IOException
	{
		User updatedUser = userService.updateUser(user);
		if (updatedUser != null) {
			return ApiResponse.CreateSuccess(updatedUser, "User successfully updated");
		}
		return ApiResponse.CreateError(AppMessages.GENERIC_UNSUCCESSFUL_UPDATE);
	}
	
	@GetMapping("/user/all")
	@ResponseBody
	public ApiResponse getAllUser() {
		List<User> allUsers = userService.getAllUsers();
		if (allUsers != null) {
			return ApiResponse.CreateSuccess(allUsers, AppMessages.USER_SUCCESSFULLY_SAVED);
		}
		return ApiResponse.CreateError(AppMessages.GENERIC_UNSUCCESSFUL_RETRIEVED);
	}
	
	@GetMapping("/user/{id}")
	@ResponseBody
	public ApiResponse getUser(@PathVariable final int id) {
		User user = userService.getUser(id);
		if (user != null) {
			return ApiResponse.CreateSuccess(user, AppMessages.USER_SUCCESSFULLY_SAVED);
		}
		return ApiResponse.CreateError(AppMessages.GENERIC_UNSUCCESSFUL_RETRIEVED);
	}
	
	@DeleteMapping("/user/{id}")
	@ResponseBody
	public ApiResponse deleteUser(@PathVariable final int id) {
		User user = userService.deleteUser(id);
		if (user != null) {
			return ApiResponse.CreateSuccess("Successfully deleted");
		}
		return ApiResponse.CreateError("Unsuccessfull");
	}
	
	@GetMapping("/user/email/{email}")
	@ResponseBody
	public ApiResponse getUserByEmail(@PathVariable final String email) {
		User user = userService.findByEmail(email);
		if (user != null) {
			return ApiResponse.CreateSuccess(user, AppMessages.USER_SUCCESSFULLY_SAVED);
		}
		return ApiResponse.CreateError(AppMessages.GENERIC_UNSUCCESSFUL_RETRIEVED);
	}


	@PostMapping("/user/login")
	@ResponseBody
	public ApiResponse login(@RequestParam("user_email") String username) {
		User user = userService.userlogin(username);
		if(user != null) {
			return ApiResponse.CreateSuccess(user, AppMessages.USER_SUCCESSFULLY_LOGGEDIN);
		}
		return ApiResponse.CreateError(AppMessages.GENERIC_UNSUCCESSFUL_LOGIN);
	}
	
	@RequestMapping(path = "/users/export")
	public void exportAllTUsers(HttpServletResponse servletResponse) throws IOException{
		servletResponse.setContentType("text/csv");
        servletResponse.addHeader("Content-Disposition","attachment; filename=\"users.csv\"");
        
        csvExportService.writeUsersToCsv(servletResponse.getWriter());
	}
}
	
