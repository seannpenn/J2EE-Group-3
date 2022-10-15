package Group3.Group3prelims.repository;

import com.google.gson.JsonElement;

import Group3.Group3prelims.entity.Ticket;

public interface ITicketRepository {
	public int save(final Ticket ticket);

	public Ticket findById(final int id);

	public int deleteByID(final int id);

	public JsonElement findAll();
}
