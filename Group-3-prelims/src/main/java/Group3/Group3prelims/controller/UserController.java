package Group3.Group3prelims.controller;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Group3.Group3prelims.entity.User;
import Group3.Group3prelims.service.IUserService;

@RestController
@CrossOrigin("*")
public class UserController {
private IUserService service;
	
	@Autowired
	public UserController(final IUserService service)
	{
		this.service = service;
	}
	
	@RequestMapping("/user/{id}")
	public String getById(@PathVariable final int id)
	{
		return service.findById(id);
	}
	
	@RequestMapping(value = "/user/{email}", method = RequestMethod.GET)
	public String getByEmail(@PathVariable final String email)
	{
		return service.findByEmail(email);
	}
	
	@RequestMapping("/user/all")
	public String getAll()
	{
		return service.findAll();
	}
	
	/**
	 * Method for saving
	 * 
	 * @param request - used to create a requestBody in save
	 * @return a String of the response
	 * @throws IOException if an input or output exception occurred NOTE: You can avoid this using the Optional class HINT: Using Optional.empty()
	 */
	@PostMapping("/user/create")
	@ResponseBody
	public int save(final HttpServletRequest request) throws IOException
	{
		// the reader is where the body is found we then pass this to the service so it'll be processed there
		final BufferedReader body = request.getReader();
		
		//No exception handling is provided in this demo. Please DIY :)
		return service.save(body);
	}
	
	// For update, you can 
	@PostMapping("/user/update/{id}")
	public int update(@PathVariable final int id, @RequestParam("user_fname") final String user_fname, @RequestParam("user_lname") final String user_lname, @RequestParam("user_email") final String user_email, @RequestParam("user_username") final String user_username, @RequestParam("user_password") final String user_password) throws IOException
	{
		//For update, you can just use the same approach above, however. For demo purposes. I'll perform the @RequestParam.
		
		//No exception handling is provided in this demo. Please DIY :)
		return service.update(new User(id, user_fname, user_lname, user_email, user_username, user_password));
	}
//	
	// For delete you can use deleteMapping annotation
	@DeleteMapping("/user/delete/{id}")
	public int delete(@PathVariable final int id) throws IOException
	{		
		//No exception handling is provided in this demo. Please DIY :)
		return service.deleteById(id);
	}
}
