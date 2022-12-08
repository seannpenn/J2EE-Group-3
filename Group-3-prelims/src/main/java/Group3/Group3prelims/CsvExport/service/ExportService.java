package Group3.Group3prelims.CsvExport.service;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.stereotype.Service;

import Group3.Group3prelims.ticket.entity.Ticket;
import Group3.Group3prelims.ticket.repository.ITicketRepository;
import Group3.Group3prelims.user.entity.User;
import Group3.Group3prelims.user.repository.IUserRepository;

@Service
public class ExportService {
	private final ITicketRepository ticketRepository;
	private final IUserRepository userRepository;
	
    public ExportService(ITicketRepository ticketRepository, IUserRepository userRepository) {
        this.ticketRepository = ticketRepository;
        this.userRepository = userRepository;
    }

    public void writeTicketsToCsv(Writer writer) {

        List<Ticket> tickets = ticketRepository.findAll();
        try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
            for (Ticket ticket : tickets) {
                csvPrinter.printRecord(ticket.getTicketID(),ticket.getSubject(),ticket.getDescription(), ticket.getAssignee(), ticket.getStatus(),ticket.getTracker(), ticket.getCreated_at());
            }
        } catch (IOException e) {
            System.out.print(e);
        }
    }
    public void writeTicketsByClientToCsv(Writer writer, Integer id) {
    	

        List<Ticket> tickets = ticketRepository.findByUserID(id);
        try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
            for (Ticket ticket : tickets) {
                csvPrinter.printRecord(ticket.getTicketID(),ticket.getSubject(),ticket.getDescription(), ticket.getAssignee(), ticket.getStatus(),ticket.getTracker(), ticket.getCreated_at());
            }
        } catch (IOException e) {
            System.out.print(e);
        }
    }
    public void writeUsersToCsv(Writer writer) {

        List<User> users = userRepository.findAll();
        try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
            for (User user : users) {
                csvPrinter.printRecord(user.getUser_id(),user.getUser_fname() + user.getUser_lname(),user.getUser_username(),user.getUser_email(), user.getRoles());
            }
        } catch (IOException e) {
            System.out.print(e);
        }
    }
}
