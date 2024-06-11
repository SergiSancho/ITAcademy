package tasca1.n3exercici1.herencia;

public class NoticiaMotociclisme extends Noticia {

    private String equip;

    public NoticiaMotociclisme(String titular, String equip) {
        super(titular);
        this.equip = equip;
    }

    public String getEquip() {
        return equip;
    }

    public void setEquip(String equip) {
        this.equip = equip;
    }

    @Override
    public void calcularPreu() {
        int preu = 100;
        if (equip.equalsIgnoreCase("Honda") || equip.equalsIgnoreCase("Yamaha")) {
            preu += 50;
        }
        this.preu = preu;
    }

    public void calcularPuntuacio() {
        int puntuacio = 3;
        if (equip.equalsIgnoreCase("Honda") || equip.equalsIgnoreCase("Yamaha")) {
            puntuacio += 3;
        }
        this.puntuacio = puntuacio;
    }

    public String toString() {
        return "NoticiaMotociclisme [equip=" + equip + ", titular=" + titular + ", text=" + text + ", puntuacio="
                + puntuacio + ", preu=" + preu + "]";
    }

}
