/*package controller;

import model.Ticket;
import model.TicketDetail;
import service.TicketService;
import service.TreeService;
import service.FlowerService;
import service.DecorationService;

import java.util.ArrayList;
import java.util.List;

public class TicketController {
    private final TicketService<Integer> ticketService;
    private final TreeService<Integer> treeService;
    private final FlowerService<Integer> flowerService;
    private final DecorationService<Integer> decorationService;

    public TicketController(TicketService<Integer> ticketService,
                            TreeService<Integer> treeService,
                            FlowerService<Integer> flowerService,
                            DecorationService<Integer> decorationService) {
        this.ticketService = ticketService;
        this.treeService = treeService;
        this.flowerService = flowerService;
        this.decorationService = decorationService;
    }

    public void createTicket() {
        List<TicketDetail<Integer>> details = new ArrayList<>();
        while (true) {
            System.out.println("Introduce los detalles del ticket:");
            Integer productId = Entrada.llegirInt("ID del producto (0 para finalizar):");
            if (productId == 0) break;
            int quantity = Entrada.llegirInt("Cantidad:");

            // Buscar el producto en las diferentes categorías
            boolean productFound = false;
            if (treeService.getTreeById(productId) != null) {
                details.add(new TicketDetail<>(null, productId, quantity));
                productFound = true;
            } else if (flowerService.getFlowerById(productId) != null) {
                details.add(new TicketDetail<>(null, productId, quantity));
                productFound = true;
            } else if (decorationService.getDecorationById(productId) != null) {
                details.add(new TicketDetail<>(null, productId, quantity));
                productFound = true;
            }

            if (!productFound) {
                System.out.println("Producto no encontrado.");
            }
        }

        if (!details.isEmpty()) {
            Ticket<Integer> ticket = new Ticket<>(details);
            ticketService.createTicket(ticket);
            System.out.println("Ticket creado con éxito.");

            // Actualizamos el ticket con su ID generado
            Ticket<Integer> createdTicket = ticketService.getAllTickets().stream()
                    .filter(t -> t.getDetails().equals(details))
                    .findFirst()
                    .orElse(null);

            if (createdTicket != null) {
                Integer ticketId = createdTicket.getId(); // Suponiendo que `Ticket` tiene un método `getId`
                details.forEach(detail -> detail.setTicketId(ticketId));
                // Aquí puedes guardar o actualizar los detalles con el ticketId
                System.out.println("Detalles del ticket actualizados con ID: " + ticketId);
            }
        } else {
            System.out.println("No se ha creado ningún ticket.");
        }
    }

    public void displayTickets() {
        List<Ticket<Integer>> tickets = ticketService.getAllTickets();
        if (tickets.isEmpty()) {
            System.out.println("No hay tickets disponibles.");
        } else {
            tickets.forEach(System.out::println);
        }
    }

    public void displayTotalEarnings() {
        double earnings = ticketService.getTotalRevenue();
        System.out.println("Total de dinero ganado: " + earnings);
    }
}
*/