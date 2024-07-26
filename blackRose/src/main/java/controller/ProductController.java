/*package controllers;

import dao.DecorationDao;
import dao.FlowerDao;
import dao.TreeDao;
import model.Decoration;
import model.Flower;
import model.Tree;

import java.util.List;

public class ProductController<ID> {

    private final FlowerDao<ID> flowerDao;
    private final TreeDao<ID> treeDao;
    private final DecorationDao<ID> decorationDao;

    private static final String MESSAGE_SEPARATOR = "----------------------------------------";
    private static final String FORMAT_HEADER = "%-10s %-20s %-10s %-10s %-10s %-20s %n";
    private static final String FORMAT_PRODUCT = "%-10s %-20s %-10d %-10.2f %-10s %-20s %n";

    public ProductController(FlowerDao<ID>flowerDao, TreeDao<ID> treeDao, DecorationDao<ID> decorationDao) {
        this.flowerDao = flowerDao;
        this.treeDao = treeDao;
        this.decorationDao = decorationDao;
    }

    public void showAllProducts() {
        System.out.println(MESSAGE_SEPARATOR);
        System.out.println("All Products:");
        System.out.println(MESSAGE_SEPARATOR);
        System.out.printf(FORMAT_HEADER, "ID", "Name", "Stock", "Price", "Type", "Details");

        List<Flower<ID>> flowers = flowerDao.findAll();
        for (Flower<ID> flower : flowers) {
            System.out.printf(FORMAT_PRODUCT, flower.getId(), flower.getName(), flower.getStock(), flower.getPrice(), "Flower", "Color: " + flower.getColour());
        }

        List<Tree<ID>> trees = treeDao.findAll();
        for (Tree<ID> tree : trees) {
            System.out.printf(FORMAT_PRODUCT, tree.getId(), tree.getName(), tree.getStock(), tree.getPrice(), "Tree", "Height: " + tree.getHeight());
        }

        List<Decoration<ID>> decorations = decorationDao.findAll();
        for (Decoration<ID> decoration : decorations) {
            System.out.printf(FORMAT_PRODUCT, decoration.getId(), decoration.getName(), decoration.getStock(), decoration.getPrice(), "Decoration", "Material: " + decoration.getMaterial());
        }
        System.out.println(MESSAGE_SEPARATOR);
    }

    public void showStockByCategory() {
        System.out.println(MESSAGE_SEPARATOR);
        System.out.println("Stock by Category:");
        System.out.println(MESSAGE_SEPARATOR);

        System.out.println("Flowers:");
        List<Flower<ID>> flowers = flowerDao.findAll();
        for (Flower<ID> flower : flowers) {
            System.out.printf("Name: %-20s Stock: %d%n", flower.getName(), flower.getStock());
        }

        System.out.println("\nTrees:");
        List<Tree<ID>> trees = treeDao.findAll();
        for (Tree<ID> tree : trees) {
            System.out.printf("Name: %-20s Stock: %d%n", tree.getName(), tree.getStock());
        }

        System.out.println("\nDecorations:");
        List<Decoration<ID>> decorations = decorationDao.findAll();
        for (Decoration<ID> decoration : decorations) {
            System.out.printf("Name: %-20s Stock: %d%n", decoration.getName(), decoration.getStock());
        }

        System.out.println(MESSAGE_SEPARATOR);
    }

    public void showTotalValueByCategory() {
        System.out.println(MESSAGE_SEPARATOR);
        System.out.println("Total Value by Category:");
        System.out.println(MESSAGE_SEPARATOR);

        double totalFlowerValue = flowerDao.getTotalValueForFlowers();
        double totalTreeValue = treeDao.getTotalValueForTrees();
        double totalDecorationValue = decorationDao.getTotalValueForDecorations();

        System.out.printf("Flowers Value: %.2f%n", totalFlowerValue);
        System.out.printf("Trees Value: %.2f%n", totalTreeValue);
        System.out.printf("Decorations Value: %.2f%n", totalDecorationValue);

        double totalValue = totalFlowerValue + totalTreeValue + totalDecorationValue;
        System.out.printf("Total Shop Value: %.2f%n", totalValue);

        System.out.println(MESSAGE_SEPARATOR);
    }

    // Methods to add, update and remove products
    public void addProduct() {
        String type = InputControl.readString("Enter product type (flower, tree, decoration): ");
        switch (type.toLowerCase()) {
            case "flower":
                addFlower();
                break;
            case "tree":
                addTree();
                break;
            case "decoration":
                addDecoration();
                break;
            default:
                System.out.println("Invalid product type.");
        }
    }

    private void addFlower() {
        Flower<ID> flower = new Flower<>();
        flower.setName(InputControl.readString("Enter flower name: "));
        flower.setStock(InputControl.readInt("Enter flower stock: "));
        flower.setPrice(InputControl.readDouble("Enter flower price: "));
        flower.setColour(InputControl.readString("Enter flower colour: "));
        flowerDao.create(flower);
    }

    private void addTree() {
        Tree<ID> tree = new Tree<>();
        tree.setName(InputControl.readString("Enter tree name: "));
        tree.setStock(InputControl.readInt("Enter tree stock: "));
        tree.setPrice(InputControl.readDouble("Enter tree price: "));
        tree.setHeight(InputControl.readDouble("Enter tree height: "));
        treeDao.create(tree);
    }

    private void addDecoration() {
        Decoration<ID> decoration = new Decoration<>();
        decoration.setName(InputControl.readString("Enter decoration name: "));
        decoration.setStock(InputControl.readInt("Enter decoration stock: "));
        decoration.setPrice(InputControl.readDouble("Enter decoration price: "));
        decoration.setMaterial(InputControl.readString("Enter decoration material: "));
        decorationDao.create(decoration);
    }

    public void updateProduct() {
        // Logic to update a product
        // Similar to addProduct, prompt the user for the product type and details, then update
    }

    public void removeProduct() {
        String type = InputControl.readString("Enter product type (flower, tree, decoration): ");
        int id = InputControl.readInt("Enter product ID: ");
        switch (type.toLowerCase()) {
            case "flower":
                flowerDao.deleteById(id);
                break;
            case "tree":
                treeDao.deleteById(id);
                break;
            case "decoration":
                decorationDao.deleteById(id);
                break;
            default:
                System.out.println("Invalid product type.");
        }
    }
}*/