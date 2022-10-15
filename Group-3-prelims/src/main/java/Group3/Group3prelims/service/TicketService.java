package Group3.Group3prelims.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import java.io.BufferedReader;

import Group3.Group3prelims.entity.Ticket;
import Group3.Group3prelims.repository.ITicketRepository;



@Service
public class TicketService implements ITicketService {
	private ITicketRepository repository;
	private Gson gson;
	@Autowired
	public TicketService(final ITicketRepository repository)
	{
		this.repository = repository;
		this.gson = new Gson();
	}
	
	public int save(final BufferedReader body) {
		// TODO Auto-generated method stub
		final Ticket ticket = gson.fromJson(body, Ticket.class);
		
		return repository.save(ticket);
	}

	public String findById(final int id) 
	{
		return new Gson().toJson(repository.findById(id));
	}
	
	public int deleteById(final int id)
	{
		return repository.deleteByID(id);
	}
}
