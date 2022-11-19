//package Group3.Group3prelims.ticket.service.aside;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.google.gson.Gson;
//import java.io.BufferedReader;
//
//import Group3.Group3prelims.ticket.entity.Ticket;
//import Group3.Group3prelims.ticket.repository.ITicketRepository;
//
//
//
//
//@Service
//public class TicketService implements ITicketService {
//	private ITicketRepository repository;
//	private Gson gson;
//	@Autowired
//	public TicketService(final ITicketRepository repository)
//	{
//		this.repository = repository;
//		this.gson = new Gson();
//	}
//	
//	public int save(final BufferedReader body) {
//		
//		final Ticket ticket = gson.fromJson(body, Ticket.class);
//		System.out.println("Ticket values");
//		System.out.println(ticket);
//		return repository.save(ticket);
//	}
//
//	public String findById(final int id) 
//	{
//		return gson.toJson(repository.findById(id));
//	}
//	public int update(final int id, final BufferedReader body)
//	{
//		final Ticket ticket = gson.fromJson(body, Ticket.class);
//		return repository.updateByID(id, ticket);
//	}
//	
//	
//	
//	public int deleteById(final int id)
//	{
//		return repository.deleteByID(id);
//	}
//
//	public String findAll() 
//	{
//		return gson.toJson(repository.findAll());
//	}
//	
//	public int updateStatus(final int id, final BufferedReader body) {
//		final Ticket ticket = gson.fromJson(body, Ticket.class);
//		
//		return repository.updateStatus(id,ticket);
//	}
//	public int updateAssignee(final int id, final BufferedReader body) {
//		final Ticket ticket = gson.fromJson(body, Ticket.class);
//		
//		return repository.updateAssignee(id,ticket);
//	}
//}
