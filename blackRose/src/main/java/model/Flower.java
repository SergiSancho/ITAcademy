package model;

public class Flower<ID> extends Product<ID> {
    private String colour;

    public Flower(ID id, String name, int stock, double price, String colour) {
        super(id, name, stock, price, Type.FLOWER);
        this.colour = colour;
    }

    public Flower() {
        super();
        // Puedes inicializar los valores por defecto aquí, si es necesario
        this.colour = "";
    }


    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public String toString() {
        return "Flower{" +
                "colour='" + colour + '\'' +
                "} " + super.toString();
    }
}
