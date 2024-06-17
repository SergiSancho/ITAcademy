package tasca2.n2exercici1;

public class Main {

    public static void main (String[] args){

        byte dies = Entrada.llegirByte("Introdueix els dies que has faltat a classe: ");
        System.out.println("Faltes d'assistència: " + dies);

        int hores = Entrada.llegirInt("Introdueix les hores que resten per a les vacances: ");
        System.out.println("Hores: " + hores);

        float preu = Entrada.llegirFloat("Introdueix quan t'ha costat aquesta computadora: ");
        System.out.println("Preu: " + preu);

        double tallat = Entrada.llegirDouble("Introdueix el preu d'un tallat: ");
        System.out.println("Preu: " + tallat);

        char inicial = Entrada.llegirChar("Introdueix la inicial del teu nom:");
        System.out.println("Inicial: " + inicial);

        String millor = Entrada.llegirString("Introdueix l'activitat que més t'agrada:");
        System.out.println("M'agrada molt: " + millor);

        boolean resposta = Entrada.llegirSiNo("Passo a la següent tasca? ");
        System.out.println("Resposta: " + resposta);


    }
}
