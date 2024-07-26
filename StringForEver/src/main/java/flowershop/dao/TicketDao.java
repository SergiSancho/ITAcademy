package flowershop.dao;

import flowershop.entities.Ticket;

//SI LA ENTIDAD O MODELO NO TIENE ID GENERICO(SERVIRA O NO?):
//public interface TicketDao extends GenericDao<TicketDao> {
//public interface TicketDao extends GenericDao<TicketDao, Integer> {
public interface TicketDao extends GenericDao<Ticket>{

    //void createTicket(Ticket<ID> ticket, List<TicketDetail<ID>> details);


    //double getTotalRevenue();

}
