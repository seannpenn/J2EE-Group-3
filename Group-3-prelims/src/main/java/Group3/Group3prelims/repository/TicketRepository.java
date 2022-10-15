package Group3.Group3prelims.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import Group3.Group3prelims.entity.Ticket;


@Repository
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
	
	
	
}
