package tasca1.n1exercici2;

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        Cotxe cotxe1 = new Cotxe("Panda", 45);
        System.out.println(cotxe1.toString());

        //Métode estàtic, l'invoquem amb la classe
        Cotxe.frenar();

        //Mètode no estàtic, l'invoquem amb l'objecte o instància de classe
        cotxe1.accelerar();

        //Si introduim un altre model, al ser un camp estàtic (de classe) l'instància anterior tambè canviarà el model
        Cotxe cotxe2 = new Cotxe("600", 19);
        System.out.println(cotxe1.toString());
        System.out.println(cotxe2.toString());
    }
}
