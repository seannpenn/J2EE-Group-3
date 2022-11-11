package Group3.Group3prelims.repository;

import java.util.List;


import Group3.Group3prelims.entity.Ticket;

public interface ITicketRepository {
	public int save(final Ticket ticket);

	public Ticket findById(final int id);

	public int deleteByID(final int id);

	public List<Ticket> findAll();

	public int updateByID(Ticket ticket);
	public int updateStatus(final int id, Ticket ticket);
	public int updateAssignee(final int id, Ticket ticket);
}
