package tasca1.n1exercici2;

public class Cotxe {

    private static final String MARCA = "Seat";
    private static String model;
    private final int potencia;

	/*El millor seria només inicialitzar al constructor la potència, perquè es
	l'únic camp que pertany a cada objecte o instància*/

    public Cotxe(int potencia) {

        this.potencia = potencia;
    }

	/*També es podria inicialitzar al constructor el model, però es estàtic (pertany a la classe)
	 per tant, cada cop que introduim un model es canviarà també el model de tots els objectes creats
	 anteriorment*/

    public Cotxe(String model, int potencia) {

        Cotxe.model = model;
        this.potencia = potencia;
    }

    //També es podria establir o canviar el model amb un mètode setter
    public static void setModel(String model) {
        Cotxe.model = model;
    }

    public static String getModel() {
        return model;
    }


    public static String getMarca() {
        return MARCA;
    }

    public int getPotencia() {
        return potencia;
    }

    public static void frenar() {
        System.out.println("El vehicle està frenant");
    }

    public void accelerar() {
        System.out.println("El vehicle està accelerant");
    }

    @Override
    public String toString() {
        return "Cotxe [marca=" + MARCA + " model=" + model + " potencia=" + potencia + "]";
    }

}
