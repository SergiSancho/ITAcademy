package model;

public class Decoration<ID> extends Product<ID> {
    private String material;

    public Decoration(ID id, String name, int stock, double price, String material) {
        super(id, name, stock, price, Type.DECORATION);
        this.material = material;
    }

    public Decoration() {
        super();
        // Puedes inicializar los valores por defecto aquí, si es necesario
        this.material = "";
    }

    public enum Material {
        WOOD,
        PLASTIC
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}

