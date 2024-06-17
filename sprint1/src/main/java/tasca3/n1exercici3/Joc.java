package tasca3.n1exercici3;

import java.util.*;

public class Joc {
    private GestorFitxers gestorFitxers;
    private Map<String, String> mapaPaisCapital;

    public Joc(GestorFitxers gestorFitxers) {
        this.gestorFitxers = gestorFitxers;
        this.mapaPaisCapital = gestorFitxers.carregarPaisosICapitals();
    }

    public void iniciar() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introdueix el teu nom: ");
        String nomUsuari = scanner.nextLine();

        Random random = new Random();
        List<String> paisos = new ArrayList<>(mapaPaisCapital.keySet());
        int puntuacio = 0;

        for (int i = 0; i < 10; i++) {
            String pais = paisos.get(random.nextInt(paisos.size()));
            System.out.println("Quina és la capital de " + pais + "?");
            String respostaUsuari = scanner.nextLine().trim();

            if (respostaUsuari.equalsIgnoreCase(mapaPaisCapital.get(pais))) {
                puntuacio++;
                System.out.println("Correcte!");
            } else {
                System.out.println("Incorrecte. La capital correcta és " + mapaPaisCapital.get(pais));
            }
        }
        System.out.println("Puntuació final:" + puntuacio);
        gestorFitxers.desarPuntuacio(nomUsuari, puntuacio);
        System.out.println("Puntuació guardada correctament. Ciao!");
    }
}

