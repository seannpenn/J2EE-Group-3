package Group3.Group3prelims.ticket.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Group3.Group3prelims.ticket.entity.Ticket;
import Group3.Group3prelims.ticket.repository.ITicketRepository;
import Group3.Group3prelims.user.entity.User;



@Service

public class TicketServicelmpl implements TicketService{
	@Autowired
	private ITicketRepository ticketJpaRepository;
	
	public Ticket saveTicket(Ticket ticket) {
		return ticketJpaRepository.saveAndFlush(ticket);
	}
	public Ticket updateTicket(Ticket ticket) {
		return ticketJpaRepository.saveAndFlush(ticket);
	}
	public List<Ticket> getAllTickets(){
		return ticketJpaRepository.findAll();
	}
	public Ticket getTicket(Integer id){
		return ticketJpaRepository.findById(id).get();
	}
	
//	public Ticket deleteTicket(Integer id){
//		return ticketJpaRepository.deleteById(id);
//	}
	
	public Ticket findBySubject(String test) {
		return ticketJpaRepository.findBySubject(test);
	}
}
