/*package controller;

import dao.jdbc.FlowerDaoJdbc;
import dao.jdbc.TreeDaoJdbc;
import service.DecorationService;
import service.FlowerService;
import service.TreeService;
import service.TicketService;
import dao.DecorationDao;
import dao.FlowerDao;
import dao.TreeDao;
import dao.TicketDao;

public class Application {

    private final ProductController<ID> productController;
    private final TicketController<ID> ticketController;

    public Application() {
        // Instanciación de los DAOs
        TreeDao<ID> treeDao = new TreeDaoJdbc<ID>();
        FlowerDao<Integer> flowerDao = new FlowerDaoJdbc();
        DecorationDao<Integer> decorationDao = new DecorationDao<>();
        TicketDao<Integer> ticketDao = new TicketDao<>();

        // Instanciación de los servicios con los DAOs
        TreeService<ID> treeService = new TreeService<ID>(treeDao);
        FlowerService<ID> flowerService = new FlowerService<ID>(flowerDao);
        DecorationService<ID> decorationService = new DecorationService<ID>(decorationDao);
        TicketService<ID> ticketService = new TicketService<ID>(ticketDao);

        // Instanciación de los controladores con los servicios
        this.productController = new ProductController<ID>(treeService, flowerService, decorationService);
        this.ticketController = new TicketController<ID>(ticketService, treeService, flowerService, decorationService);
    }

    public void start() {
        while (true) {
            System.out.println("\nSelecciona una opción:");
            System.out.println("1. Crear Árbol");
            System.out.println("2. Crear Flor");
            System.out.println("3. Crear Decoración");
            System.out.println("4. Mostrar Stock");
            System.out.println("5. Retirar Árbol");
            System.out.println("6. Retirar Flor");
            System.out.println("7. Retirar Decoración");
            System.out.println("8. Crear Ticket");
            System.out.println("9. Mostrar Tickets");
            System.out.println("10. Mostrar Ingresos Totales");
            System.out.println("0. Salir");

            byte option = Entrada.llegirByte("Selecciona una opción:");

            switch (option) {
                case 1:
                    productController.addTree();
                    break;
                case 2:
                    productController.addFlower();
                    break;
                case 3:
                    productController.addDecoration();
                    break;
                case 4:
                    productController.displayStock();
                    break;
                case 5:
                    productController.removeTree();
                    break;
                case 6:
                    productController.removeFlower();
                    break;
                case 7:
                    productController.removeDecoration();
                    break;
                case 8:
                    ticketController.createTicket();
                    break;
                case 9:
                    ticketController.displayTickets();
                    break;
                case 10:
                    ticketController.displayTotalEarnings();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }
}
*/