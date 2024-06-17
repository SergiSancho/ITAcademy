package tasca3.n1exercici3;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        GestorFitxers gestorFitxers = new GestorFitxers();
        Joc joc = new Joc(gestorFitxers);
        joc.iniciar();
    }
}