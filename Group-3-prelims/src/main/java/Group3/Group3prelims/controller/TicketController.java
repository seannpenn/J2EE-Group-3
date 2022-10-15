package Group3.Group3prelims.controller;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import Group3.Group3prelims.service.ITicketService;
@RestController
public class TicketController {
	
private ITicketService service;
	
	@Autowired
	public TicketController(final ITicketService service)
	{
		this.service = service;
	}
	
//	@RequestMapping("/ticket/{id}")
	@PostMapping("/ticket")
	public int save(final HttpServletRequest request) throws IOException
	{
		// the reader is where the body is found we then pass this to the service so it'll be processed there
		final BufferedReader body = request.getReader();
		
		//No exception handling is provided in this demo. Please DIY :)
		return service.save(body);
	}
	
	@ResponseBody
	public String execute(@PathVariable final int id)
	{
		return service.findById(id);
	}
	
	
	
}
