package Group3.Group3prelims.ticket.service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import Group3.Group3prelims.ticket.entity.Ticket;

public interface TicketService {
	public Ticket saveTicket(Ticket ticket);
	public Ticket updateTicket(Ticket ticket);
	public List<Ticket> getAllTickets();
	public Ticket getTicket(Integer id);
	public Ticket deleteTicket(Integer id);
	
	public Ticket findBySubject(String test);
	public List<Ticket> getAllTicketsByUser(Integer id);
	public List<Ticket> findByCreateDate(String date);
}
