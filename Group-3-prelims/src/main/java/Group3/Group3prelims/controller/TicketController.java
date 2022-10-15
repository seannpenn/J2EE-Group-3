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

import Group3.Group3prelims.entity.Ticket;
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
	
	@RequestMapping("/ticket")
	@ResponseBody
	public String execute()
	{
		return service.findAll();
	}
	
	@DeleteMapping("/ticket/delete/{id}")
	public int delete(@PathVariable final int id) throws IOException
	{		
		//No exception handling is provided in this demo. Please DIY :)
		return service.deleteById(id);
	@PostMapping("/ticket/{id}")
	public int save(@PathVariable final int id, @RequestParam("ticketID") final String ticketID,@RequestParam("assignee") final String assignee, @RequestParam("status") final String status,@RequestParam("subject") final String subject,@RequestParam("description") final String description, @RequestParam("tracker") final String tracker ) throws IOException
	{
		
		return service.update(new Ticket(id,assignee, status, subject, description, tracker));
	}
	
	
	
	
	
}
