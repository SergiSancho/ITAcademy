/*package controller;

import java.util.Scanner;

public class Menu {

    private final ProductController<Integer> productController;
    private final TicketController<Integer> ticketController;
    private final Scanner scanner = new Scanner(System.in);

    public Menu(ProductController<Integer> productController, TicketController<Integer> ticketController) {
        this.productController = productController;
        this.ticketController = ticketController;
    }

    public void start() {
        boolean running = true;
        while (running) {
            System.out.println("1. Manage Products");
            System.out.println("2. Manage Tickets");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    manageProducts();
                    break;
                case 2:
                    manageTickets();
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void manageProducts() {
        boolean managingProducts = true;
        while (managingProducts) {
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Remove Product");
            System.out.println("4. List All Products");
            System.out.println("5. Show Stock by Category");
            System.out.println("6. Show Total Value by Category");
            System.out.println("7. Back to Main Menu");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    productController.addProduct();
                    break;
                case 2:
                    productController.updateProduct();
                    break;
                case 3:
                    productController.removeProduct();
                    break;
                case 4:
                    productController.showAllProducts();
                    break;
                case 5:
                    productController.showStockByCategory();
                    break;
                case 6:
                    productController.showTotalValueByCategory();
                    break;
                case 7:
                    managingProducts = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void manageTickets() {
        boolean managingTickets = true;
        while (managingTickets) {
            System.out.println("1. Create Ticket");
            System.out.println("2. View Tickets");
            System.out.println("3. Back to Main Menu");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    ticketController.createTicket();
                    break;
                case 2:
                    ticketController.viewTickets();
                    break;
                case 3:
                    managingTickets = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}

*/
/*import java.util.Scanner;

public class Menu {

    public static void start(DaoFactory daoFactory) {
        Scanner scanner = new Scanner(System.in);

        // Crear los DAOs y los controladores utilizando la DaoFactory
        FlowerDao<Integer> flowerDao = daoFactory.getFlowerDao();
        TreeDao<Integer> treeDao = daoFactory.getTreeDao();
        DecorationDao<Integer> decorationDao = daoFactory.getDecorationDao();
        TicketDao<Integer> ticketDao = daoFactory.getTicketDao();

        ProductController<Integer> productController = new ProductController<>(flowerDao, treeDao, decorationDao);
        TicketController<Integer> ticketController = new TicketController<>(ticketDao);

        boolean running = true;
        while (running) {
            System.out.println("Main Menu");
            System.out.println("1. Manage Products");
            System.out.println("2. Manage Tickets");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    manageProducts(scanner, productController);
                    break;
                case 2:
                    manageTickets(scanner, ticketController);
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void manageProducts(Scanner scanner, ProductController<Integer> productController) {
        boolean managingProducts = true;
        while (managingProducts) {
            System.out.println("Product Management");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Remove Product");
            System.out.println("4. List All Products");
            System.out.println("5. Show Stock by Category");
            System.out.println("6. Show Total Value by Category");
            System.out.println("7. Back to Main Menu");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    productController.addProduct();
                    break;
                case 2:
                    productController.updateProduct();
                    break;
                case 3:
                    productController.removeProduct();
                    break;
                case 4:
                    productController.showAllProducts();
                    break;
                case 5:
                    productController.showStockByCategory();
                    break;
                case 6:
                    productController.showTotalValueByCategory();
                    break;
                case 7:
                    managingProducts = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void manageTickets(Scanner scanner, TicketController<Integer> ticketController) {
        boolean managingTickets = true;
        while (managingTickets) {
            System.out.println("Ticket Management");
            System.out.println("1. Add Ticket");
            System.out.println("2. Update Ticket");
            System.out.println("3. Remove Ticket");
            System.out.println("4. List All Tickets");
            System.out.println("5. Back to Main Menu");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    ticketController.addTicket();
                    break;
                case 2:
                    ticketController.updateTicket();
                    break;
                case 3:
                    ticketController.removeTicket();
                    break;
                case 4:
                    ticketController.showAllTickets();
                    break;
                case 5:
                    managingTickets = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
*/