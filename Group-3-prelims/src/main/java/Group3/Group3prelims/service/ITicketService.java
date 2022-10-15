package Group3.Group3prelims.service;

import java.io.BufferedReader;

public interface ITicketService {
	public int save(final BufferedReader body);

	public String findById(final int id);
}
