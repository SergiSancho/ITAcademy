package dao;

import model.Ticket;
import model.TicketDetail;

import java.util.List;

public interface TicketDao<ID> extends GenericDao<Ticket<ID>, ID>{

    void createTicket(Ticket<ID> ticket, List<TicketDetail<ID>> details);

    List<Ticket<ID>> getAllTickets();

    double getTotalRevenue();

}
