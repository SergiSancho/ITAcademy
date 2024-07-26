package dao.jdbc;

import dao.TicketDao;
import model.Ticket;
import model.TicketDetail;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TicketDaoJdbc extends GenericJdbcDao<Ticket<Integer>, Integer> implements TicketDao<Integer> {

    private static final Logger logger = Logger.getLogger(TicketDaoJdbc.class.getName());

    public TicketDaoJdbc(Connection connection) {
        super(connection);
    }

    @Override
    public void create(Ticket<Integer> ticket) {
        String insertTicketSql = "INSERT INTO ticket (sale_date, total_price) VALUES (?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(insertTicketSql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setDate(1, new java.sql.Date(ticket.getDate().getTime()));
            pstmt.setDouble(2, ticket.getTotalPrice());
            pstmt.executeUpdate();

            ResultSet generatedKeys = pstmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                ticket.setId(generatedKeys.getInt(1)); // Asignar el ID generado al objeto Ticket
            } else {
                throw new SQLException("Error al obtener el ID del ticket");
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al crear ticket", e);
        }
    }

    @Override
    public void createTicket(Ticket<Integer> ticket, List<TicketDetail<Integer>> details) {
        String insertTicketSql = "INSERT INTO ticket (sale_date, total_price) VALUES (?, ?)";
        String insertTicketDetailSql = "INSERT INTO ticket_detail (id_ticket, id_product, quantity) VALUES (?, ?, ?)";

        try {
            connection.setAutoCommit(false);

            int ticketId;
            try (PreparedStatement pstmt = connection.prepareStatement(insertTicketSql, Statement.RETURN_GENERATED_KEYS)) {
                pstmt.setDate(1, new java.sql.Date(ticket.getDate().getTime()));
                pstmt.setDouble(2, ticket.getTotalPrice());
                pstmt.executeUpdate();

                ResultSet generatedKeys = pstmt.getGeneratedKeys();
                if (generatedKeys.next()) {
                    ticketId = generatedKeys.getInt(1);
                    ticket.setId(ticketId); // Asignar el ID generado al objeto Ticket
                } else {
                    throw new SQLException("Error al obtener el ID del ticket");
                }
            }

            try (PreparedStatement pstmt = connection.prepareStatement(insertTicketDetailSql)) {
                for (TicketDetail<Integer> detail : details) {
                    pstmt.setInt(1, ticketId);
                    pstmt.setInt(2, detail.getProductId());
                    pstmt.setInt(3, detail.getQuantity());
                    pstmt.addBatch();
                }
                pstmt.executeBatch();
            }

            connection.commit();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al crear ticket y detalles", e);
            try {
                connection.rollback();
            } catch (SQLException rollbackEx) {
                logger.log(Level.SEVERE, "Error al deshacer la transacción", rollbackEx);
            }
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                logger.log(Level.SEVERE, "Error al restaurar el modo auto-commit", e);
            }
        }
    }

    @Override
    public Ticket<Integer> read(Integer id) {
        String sql = "SELECT id_ticket, sale_date, total_price FROM ticket WHERE id_ticket = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new Ticket<>(
                        rs.getInt("id_ticket"),
                        rs.getDate("sale_date"),
                        rs.getDouble("total_price")
                );
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al leer ticket por ID", e);
        }
        return null;
    }

    @Override
    public void update(Ticket<Integer> ticket) {
        String updateTicketSql = "UPDATE ticket SET sale_date = ?, total_price = ? WHERE id_ticket = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(updateTicketSql)) {
            pstmt.setDate(1, new java.sql.Date(ticket.getDate().getTime()));
            pstmt.setDouble(2, ticket.getTotalPrice());
            pstmt.setInt(3, ticket.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al actualizar el ticket", e);
        }
    }

    @Override
    public void deleteById(Integer id) {
        String deleteTicketSql = "DELETE FROM ticket WHERE id_ticket = ?";
        String deleteTicketDetailsSql = "DELETE FROM ticket_detail WHERE id_ticket = ?";
        try {
            connection.setAutoCommit(false);

            try (PreparedStatement pstmt = connection.prepareStatement(deleteTicketDetailsSql)) {
                pstmt.setInt(1, id);
                pstmt.executeUpdate();
            }

            try (PreparedStatement pstmt = connection.prepareStatement(deleteTicketSql)) {
                pstmt.setInt(1, id);
                pstmt.executeUpdate();
            }

            connection.commit();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al eliminar ticket y detalles", e);
            try {
                connection.rollback();
            } catch (SQLException rollbackEx) {
                logger.log(Level.SEVERE, "Error al deshacer la transacción", rollbackEx);
            }
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                logger.log(Level.SEVERE, "Error al restaurar el modo auto-commit", e);
            }
        }
    }

    @Override
    public List<Ticket<Integer>> findAll() {
        return getAllTickets();
    }

    @Override
    public List<Ticket<Integer>> getAllTickets() {
        List<Ticket<Integer>> tickets = new ArrayList<>();
        String sql = "SELECT id_ticket, sale_date, total_price FROM ticket";

        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Ticket<Integer> ticket = new Ticket<>(
                        rs.getInt("id_ticket"),
                        rs.getDate("sale_date"),
                        rs.getDouble("total_price")
                );
                tickets.add(ticket);
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al obtener todos los tickets", e);
        }
        return tickets;
    }

    @Override
    public double getTotalRevenue() {
        String sql = "SELECT SUM(total_price) AS total_revenue FROM ticket";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                return rs.getDouble("total_revenue");
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al obtener los ingresos totales", e);
        }
        return 0;
    }
}
