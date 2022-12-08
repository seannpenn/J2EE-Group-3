package Group3.Group3prelims.ticket.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
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

@RestController
@CrossOrigin("*")
public class TicketController {
	
//private ITicketService service;
	
	@Autowired
	
	private TicketService ticketService;
	private final ExportService csvExportService;
	public TicketController(final ExportService csvExportService)
	{
		this.csvExportService = csvExportService;
	}
//	
	@PostMapping("/ticket/create")
	@ResponseBody
	
	public ApiResponse save(Ticket ticket) throws IOException {

		Ticket savedTicket = ticketService.saveTicket(ticket);
		
		if (savedTicket != null) {
			return ApiResponse.CreateSuccess(savedTicket, AppMessages.TICKET_SUCCESSFULLY_SAVED);
		}

		return ApiResponse.CreateError(AppMessages.GENERIC_UNSUCCESSFUL_SAVE);
	}
	
	@PutMapping("/ticket/update")
	@ResponseBody
	public ApiResponse update(Ticket ticket) throws IOException
	{
		Ticket updatedTicket = ticketService.updateTicket(ticket);
		if (updatedTicket != null) {
			return ApiResponse.CreateSuccess(updatedTicket, AppMessages.TICKET_SUCCESSFULLY_UPDATED);
		}
		return ApiResponse.CreateError(AppMessages.GENERIC_UNSUCCESSFUL_UPDATE);
	}
	
	@GetMapping("/ticket/all")
	@ResponseBody
	public ApiResponse getTickets() {
		List<Ticket> allTickets = ticketService.getAllTickets();
		if (allTickets != null) {
			return ApiResponse.CreateSuccess(allTickets, AppMessages.TICKETS_SUCCESSFULLY_RETRIEVED);
		}
		return ApiResponse.CreateError(AppMessages.GENERIC_UNSUCCESSFUL_RETRIEVED);
	}
	
	@GetMapping("/ticket/{id}")
	@ResponseBody
	public ApiResponse getTicket(@PathVariable final int id) {
		Ticket ticket = ticketService.getTicket(id);
		if (ticket != null) {
			return ApiResponse.CreateSuccess(ticket, AppMessages.TICKET_SUCCESSFULLY_RETRIEVED);
		}
		return ApiResponse.CreateError(AppMessages.GENERIC_UNSUCCESSFUL_RETRIEVED);
	}
	@DeleteMapping("/ticket/delete/{id}")
	@ResponseBody
	public ApiResponse deleteTicket(@PathVariable final int id) {
		Ticket ticket = ticketService.deleteTicket(id);
		if (ticket != null) {
			return ApiResponse.CreateSuccess("Successfully deleted");
		}
		return ApiResponse.CreateError("Unsuccessfull");
	}
	
	
	@PostMapping("/ticket/login")
	@ResponseBody
	
	public ApiResponse login(@RequestParam("subject") String subject) {
		Ticket ticket = ticketService.findBySubject(subject);
		if(ticket != null) {
			return ApiResponse.CreateSuccess(ticket, AppMessages.TICKET_SUCCESSFULLY_RETRIEVED);
		}
		return ApiResponse.CreateError(AppMessages.GENERIC_UNSUCCESSFUL_RETRIEVED);
	}
	
	@GetMapping("/ticket/user/{id}")
	@ResponseBody
	
	public ApiResponse getAllTicketsByUser(@PathVariable final int id) {
		List<Ticket> ticket = ticketService.getAllTicketsByUser(id);
		System.out.println(ticket.size());
		if(ticket != null && ticket.size() != 0) {
			return ApiResponse.CreateSuccess(ticket, AppMessages.TICKET_SUCCESSFULLY_RETRIEVED);
		}
		return ApiResponse.CreateError(AppMessages.GENERIC_UNSUCCESSFUL_RETRIEVED);
	}
	
	@GetMapping("/ticket/aging/all")
	@ResponseBody
	public ApiResponse getAllAgingTicket() throws ParseException {
//		Date createDate = new SimpleDateFormat("yyyy-MM-dd").parse("2022-12-02");
		String testDate = "2022-12-03 20:53:33";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); 
		LocalDateTime dateTime = LocalDateTime.parse(testDate, formatter);
		
		LocalDateTime currentDate = LocalDateTime.now();
		LocalDateTime currentDateMinus6Months = currentDate.minusWeeks(2);
		
		System.out.println(currentDateMinus6Months);

				
		List<Ticket> ticket = ticketService.findByCreateDate(testDate);
		
		if(ticket != null && ticket.size() != 0) {
			return ApiResponse.CreateSuccess(ticket, AppMessages.TICKET_SUCCESSFULLY_RETRIEVED);
		}
		return ApiResponse.CreateError(AppMessages.GENERIC_UNSUCCESSFUL_RETRIEVED);
	}
	
	@RequestMapping(path = "/tickets/export")
	public void exportAllTickets(HttpServletResponse servletResponse) throws IOException{
		servletResponse.setContentType("text/csv");
        servletResponse.addHeader("Content-Disposition","attachment; filename=\"tickets.csv\"");
        
        csvExportService.writeTicketsToCsv(servletResponse.getWriter());
	}
	
//	Export all tickets by client 
	@RequestMapping(path = "/tickets/user/{id}/export")
	public void exportTicketsByUser(HttpServletResponse servletResponse, @PathVariable Integer  id) throws IOException{
		
		servletResponse.setContentType("text/csv");
        servletResponse.addHeader("Content-Disposition","attachment; filename=\"ticketsByClient.csv\"");
        
        csvExportService.writeTicketsByClientToCsv(servletResponse.getWriter(), id);
	}
//	@RequestMapping("/ticket/all")
//	@ResponseBody
//	public ApiResponse getAllTicket()
//	{
//		Ticket ticketCollection = ticketService.getAllTicket();
//		return ApiResponse.CreateError(TicketMessages.GENERIC_UNSUCCESSFUL_SAVE);
//	}
	
//	
//	
//	
//	@RequestMapping("/ticket/get/{id}")
//	public String execute(@PathVariable final int id)
//	{
//		return service.findById(id);
//	}
//	
//	@RequestMapping("/ticket/all")
//	@ResponseBody
//	public String execute()
//	{
//		return service.findAll();
//	}
//	
//	@DeleteMapping("/ticket/delete/{id}")
//	public int delete(@PathVariable final int id) throws IOException
//	{	
//		return service.deleteById(id);
//	}
//	
////	@PostMapping("/ticket/update/{id}")
////	public int save(@PathVariable final int id, final HttpServletRequest request) {
//////			@RequestParam("assignee") final String assignee, @RequestParam("status") final String status,@RequestParam("subject") final String subject,@RequestParam("description") final String description, @RequestParam("tracker") final String tracker ) throws IOException
////		
////		return service.update(id, request);
////	}
//	@PatchMapping("/ticket/update/{id}/status")
//	public int updateStatus(@PathVariable final int id, final HttpServletRequest request) throws IOException
//	{
//		final BufferedReader body = request.getReader();
//		return service.updateStatus(id, body);
//	}
//	
//	@PatchMapping("/ticket/update/{id}/assignee")
//	public int updateAssignee(@PathVariable final int id, final HttpServletRequest request) throws IOException
//	{
//		final BufferedReader body = request.getReader();
//		return service.updateAssignee(id, body);
//	}
//	
//	
	
	
	
}
