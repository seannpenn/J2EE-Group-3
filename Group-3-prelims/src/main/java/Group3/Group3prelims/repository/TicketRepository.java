package Group3.Group3prelims.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import Group3.Group3prelims.entity.Ticket;



@Repository
public class TicketRepository implements ITicketRepository{
	@Autowired
	private JdbcTemplate template;
	public int save(final Ticket ticket){
		
		final String sql = "INSERT INTO ticket (ticket_id, assignee, status, subject, description, tracker) VALUES (?, ?, ?, ?, ?, ?)";
		
		final int result = template.update(sql, ticket.getTicket_id(), ticket.getAssignee(), ticket.getStatus(), ticket.getSubject(),ticket.getDescription(),ticket.getTracker());
		
		return 3000;
	}
	public Ticket findById(final int id) 
	{
		final String query = "SELECT * FROM ticket where ticket_id=?";
		final Ticket result = template.queryForObject(query, BeanPropertyRowMapper.newInstance(Ticket.class), id);
	
		return result;
	}
		

		public int updateByID(final Ticket ticket)
		{
			
		
			final String sql = "UPDATE ticket SET ticket_id=?,assignee=?,status=?,subject=?,description=?,tracker=? WHERE ticket_id=?";
			
			try {
				final int result = template.update(sql, ticket.getTicket_id(), ticket.getAssignee(), ticket.getStatus(), ticket.getSubject(),ticket.getDescription(),ticket.getTracker(), ticket.getTicket_id());
				if(result == 0) {
					throw new Exception("Error update cannot proceed"); 
				}
				
				return result;
			}catch(Exception e) {
				System.out.println(e.toString());  
				return 404;
			}
		
	}
	
	public int deleteByID(final int id) {
		
		final String sql = "DELETE FROM ticket WHERE ticket_id=?";
		try {
			final int result = template.update(sql, id);
			if(result == 0) {
				throw new Exception("Ticket Id not found"); 
			}
			
			return result;
		}catch(Exception e) {
			System.out.println(e.toString());  
			return 404;
		}
	}
	
	public List<Ticket> findAll() 
	{
		final String query = "SELECT * FROM ticket";
		final List<Ticket> result = template.query(query, BeanPropertyRowMapper.newInstance(Ticket.class));
		
		return result;
	}
	public int updateStatus(final int id, Ticket ticket) {
		final String sql = "UPDATE ticket SET status=? WHERE ticket_id=?";
		final int result = template.update(sql,ticket.getStatus(), id);
		
		return result;
	}
	
	public int updateAssignee(final int id, Ticket ticket) {
		final String sql = "UPDATE ticket SET assignee=? WHERE ticket_id=?";
		final int result = template.update(sql,ticket.getAssignee(), id);
		
		return result;
	}
	
	
}
