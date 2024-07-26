package dao.jdbc;

import dao.TicketDetailDao;
import model.TicketDetail;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TicketDetailDaoJdbc extends GenericJdbcDao<TicketDetail<Integer>, Integer> implements TicketDetailDao<Integer> {

    private static final Logger logger = Logger.getLogger(TicketDetailDaoJdbc.class.getName());

    public TicketDetailDaoJdbc(Connection connection) {
        super(connection);
    }

    @Override
    public void create(TicketDetail<Integer> detail) {
        String sql = "INSERT INTO ticket_detail (id_ticket, id_product, quantity) VALUES (?, ?, ?)";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, detail.getTicketId());
            pstmt.setInt(2, detail.getProductId());
            pstmt.setInt(3, detail.getQuantity());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al insertar detalle del ticket", e);
        }
    }

    @Override
    public TicketDetail<Integer> read(Integer id) {
        String sql = "SELECT id_ticket, id_product, quantity FROM ticket_detail WHERE id_ticket = ? AND id_product = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setInt(2, id);  // Esto puede necesitar ajuste si el ID de detalle es compuesto
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new TicketDetail<>(
                        rs.getInt("id_ticket"),
                        rs.getInt("id_product"),
                        rs.getInt("quantity")
                );
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al leer detalle del ticket por ID", e);
        }
        return null;
    }

    @Override
    public void update(TicketDetail<Integer> detail) {
        String sql = "UPDATE ticket_detail SET quantity = ? WHERE id_ticket = ? AND id_product = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, detail.getQuantity());
            pstmt.setInt(2, detail.getTicketId());
            pstmt.setInt(3, detail.getProductId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al actualizar detalle del ticket", e);
        }
    }

    @Override
    public void deleteById(Integer id) {
        String sql = "DELETE FROM ticket_detail WHERE id_ticket = ? AND id_product = ?";

        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setInt(2, id);  // Esto puede necesitar ajuste si el ID de detalle es compuesto
            pstmt.executeUpdate();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al eliminar detalle del ticket", e);
        }
    }

    @Override
    public List<TicketDetail<Integer>> findAll() {
        List<TicketDetail<Integer>> details = new ArrayList<>();
        String sql = "SELECT id_ticket, id_product, quantity FROM ticket_detail";

        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                TicketDetail<Integer> detail = new TicketDetail<>(
                        rs.getInt("id_ticket"),
                        rs.getInt("id_product"),
                        rs.getInt("quantity")
                );
                details.add(detail);
            }
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error al obtener todos los detalles del ticket", e);
        }
        return details;
    }
}
