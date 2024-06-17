package tasca4.n1exercici3;

public class ArcSantMarti {
    private String[] colors;

    public ArcSantMarti() {
        colors =  new String []{"Vermell", "Taronja", "Groc", "Verd", "Cian", "Blau", "Violeta"};
    }

    public String getColor(int index) throws ArrayIndexOutOfBoundsException {
        if (index < 0 || index >= colors.length) {
            throw new ArrayIndexOutOfBoundsException("Index fora dels límits de l'array colors");
        }
        return colors[index];
    }

    /*public String getColor(int index) {
        try{
            if (index < 0 || index >= colors.length) {
                throw new ArrayIndexOutOfBoundsException("Index fora dels limits de l'array colors");
            }
            return colors[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Excepcio: " + e.getMessage());
            return null;
        }
    }*/
}
