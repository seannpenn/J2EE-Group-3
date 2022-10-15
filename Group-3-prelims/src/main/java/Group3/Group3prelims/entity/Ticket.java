package Group3.Group3prelims.entity;

public class Ticket {
	private int ticket_id;
	private String assignee;
	private String status;
	private String subject;
	private String description;
	private String tracker;
	
	public Ticket()
	{
	}
	
	public Ticket(final int ticket_id, final String assignee, final String status, 
			final String subject, final String description, final String tracker)
	{
		this.ticket_id = ticket_id;
		this.assignee = assignee;
		this.status = status;
		this.subject = subject;
		this.description = description;
		this.tracker = tracker;
	}

	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getTicket_id() {
		return ticket_id;
	}
	public void setTicket_id(int ticket_id) {
		this.ticket_id = ticket_id;
	}
	public String getAssignee() {
		return assignee;
	}
	public void setAssignee(String assignee) {
		this.assignee = assignee;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTracker() {
		return tracker;
	}
	public void setTracker(String tracker) {
		this.tracker = tracker;
	}
}
