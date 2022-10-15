package Group3.Group3prelims.service;

import java.io.BufferedReader;

import Group3.Group3prelims.entity.Ticket;


public interface ITicketService {
	public int save(final BufferedReader body);

	public String findById(final int id);
	public int deleteById(final int id);
	public int update(final Ticket user);
}
