package model;

public class Tree<ID> extends Product<ID> {
    private double height;

    public Tree(ID id, String name, int stock, double price, double height) {
        super(id, name, stock, price, Type.TREE);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }
}

