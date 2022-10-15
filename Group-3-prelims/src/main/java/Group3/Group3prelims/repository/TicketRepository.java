package Group3.Group3prelims.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import Group3.Group3prelims.entity.Ticket;



public class TicketRepository implements ITicketRepository{
	@Autowired
	private JdbcTemplate template;
	public int save(final Ticket ticket)
	{
		//The code below is for normal insert
		
		final String sql = "INSERT INTO ticket (ticket_id, assignee, status, subject, description, tracker) VALUES (?, ?, ?, ?, ?, ?)";
		final int result = template.update(sql, ticket.getTicket_id(), ticket.getAssignee(), ticket.getStatus(), ticket.getSubject(),ticket.getDescription(),ticket.getTracker());
		
		return result;
	}
	@Override
	public Ticket findById(final int id) 
	{
		final String query = "SELECT * FROM ticket where ticketId=?";
		final Ticket result = template.queryForObject(query, BeanPropertyRowMapper.newInstance(Ticket.class), id);
		
		return result;
	}
	
	
	
}
