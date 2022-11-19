package Group3.Group3prelims.ticket.service;

import java.util.List;

import Group3.Group3prelims.ticket.entity.Ticket;

public interface TicketService {
	public Ticket saveTicket(Ticket ticket);
	public Ticket updateTicket(Ticket ticket);
	public List<Ticket> getAllTickets();
	public Ticket getTicket(Integer id);
//	public void deleteTicket(Integer id);
	
	public Ticket findBySubject(String test);
}
