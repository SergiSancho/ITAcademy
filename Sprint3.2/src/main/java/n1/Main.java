package n1;

import n1.observable.*;
import n1.observador.*;

public class Main {
    public static void main(String[] args) {
        AgentBorsa agentBorsa = new AgentBorsa();

        AgenciaMartesNegro agenciaMartesNegro = new AgenciaMartesNegro(agentBorsa);
        AgenciaCrack agenciaCrack = new AgenciaCrack(agentBorsa);

        System.out.println("    1. Canviant l'estat del subjecte a 10...");
        agentBorsa.setEstat(10);

        System.out.println("    2. Canviant l'estat del subjecte a 5...");
        agentBorsa.setEstat(5);

        System.out.println("    3. Eliminant AgenciaMartesNegro de la llista d'observadors...");
        agentBorsa.eliminarObservador(agenciaMartesNegro);

        System.out.println("    4. Canviant l'estat del subjecte a 0...");
        agentBorsa.setEstat(0);
    }
}
