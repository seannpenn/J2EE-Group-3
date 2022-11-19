package Group3.Group3prelims.ticket.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Group3.Group3prelims.ticket.entity.Ticket;



@Repository
public interface ITicketRepository extends JpaRepository<Ticket, Integer>{
	public Ticket findBySubject(String test);
}