package model;


public class Product<ID> {
    private ID id;
    private String name;
    private int stock;
    private double price;
    private Type type;

    public Product(ID id, String name, int stock, double price, Type type) {
        this.id = id;
        this.name = name;
        this.stock = stock;
        this.price = price;
        this.type = type;
    }

    // Constructor sin parámetros
    public Product() {
        // Valores por defecto, si es necesario
        this.id = null;
        this.name = "";
        this.stock = 0;
        this.price = 0.0;
        this.type = null;
    }

    public enum Type {
        FLOWER,
        TREE,
        DECORATION
    }

    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", stock=" + stock +
                ", price=" + price +
                ", type=" + type +
                '}';
    }
}
