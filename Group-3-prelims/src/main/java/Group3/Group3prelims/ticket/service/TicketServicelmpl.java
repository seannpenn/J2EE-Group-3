package Group3.Group3prelims.ticket.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Group3.Group3prelims.ticket.entity.Ticket;
import Group3.Group3prelims.ticket.repository.ITicketRepository;
import Group3.Group3prelims.user.entity.User;

import java.text.DateFormat;


@Service

public class TicketServicelmpl implements TicketService{
	@Autowired
	private ITicketRepository ticketJpaRepository;
	
	public Ticket saveTicket(Ticket ticket) {
		Date date = new Date();
		String dateString = date.toString();
		
		ticket.setDate(dateString);
		return ticketJpaRepository.saveAndFlush(ticket);
	}
	public Ticket updateTicket(Ticket ticket) {
		System.out.print(ticket.getTicketID());
		Ticket existingTicket = ticketJpaRepository.findById(ticket.getTicketID()).get();
		
		existingTicket.setAssignee(ticket.getAssignee());
		existingTicket.setStatus(ticket.getStatus());
		existingTicket.setSubject(ticket.getSubject());
		existingTicket.setDescription(ticket.getDescription());
		existingTicket.setTracker(ticket.getTracker());
		
		return ticketJpaRepository.saveAndFlush(existingTicket);
	}
	public List<Ticket> getAllTickets(){
		return ticketJpaRepository.findAll();
	}
	public Ticket getTicket(Integer id){
		return ticketJpaRepository.findById(id).get();
	}
	
	public Ticket deleteTicket(Integer id){
		Ticket chosenTicket = ticketJpaRepository.findById(id).get();
		if(chosenTicket != null) {
			ticketJpaRepository.delete(chosenTicket);
			return chosenTicket;
		}
		
		return null;
	}
	
	public Ticket findBySubject(String test) {
		return ticketJpaRepository.findBySubject(test);
	}
	
	public List<Ticket> getAllTicketsByUser(Integer id){
		return ticketJpaRepository.findByUserID(id);
	}
}
