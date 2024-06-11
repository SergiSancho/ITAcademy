package tasca1.n3exercici1;

import java.util.ArrayList;
import java.util.Scanner;

import tasca1.n3exercici1.herencia.*;

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        ArrayList<Redactor> redactors = new ArrayList<>();

        boolean sortir = false;

        do {
            switch (menu()) {
                case 1:
                    introduirRedactor(redactors);
                    break;
                case 2:
                    eliminarRedactor(redactors);
                    break;
                case 3:
                    introduirNoticia(redactors);
                    break;
                case 4:
                    eliminarNoticia(redactors);
                    break;
                case 5:
                    mostrarNoticiesRedactor(redactors);
                    break;
                case 6:
                    calcularPreuNoticia(redactors);
                    break;
                case 7:
                    calcularPuntuacioNoticia(redactors);
                    break;
                case 0:
                    System.out.println("Gràcies per utilitzar l'aplicació");
                    sortir = true;
                    break;
            }
        } while (!sortir);
    }

    public static byte menu() {
        Scanner sc = new Scanner(System.in);
        byte opcio;
        final byte MINIMO = 0;
        final byte MAXIMO = 7;

        do {
            System.out.println("\nMENú PRINCIPAL");
            System.out.println("1. Introduir redactor/a.");
            System.out.println("2. Eliminar redactor/a.");
            System.out.println("3. Introduir notícia a un redactor/a.");
            System.out.println("4. Eliminar notícia (ha de demanar redactor/a i titular de la notícia).");
            System.out.println("5. Mostrar totes les notícies per redactor/a.");
            System.out.println("6. Calcular puntuació de la notícia.");
            System.out.println("7. Calcular preu-notícia.");
            System.out.println("0. Sortir de l'aplicació.\n");
            System.out.println("Introdueixi un numero per l'opció:");
            opcio = sc.nextByte();
            sc.nextLine();
            if (opcio < MINIMO || opcio > MAXIMO) {
                System.out.println("Escull una opció vàlida");
            }
        } while (opcio < MINIMO || opcio > MAXIMO);

        return opcio;
    }

    public static void introduirRedactor(ArrayList<Redactor> redactors) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Bones! Introduirem un redactor.");
        System.out.print("Introdueixi el dni del redactor: ");
        String dni = sc.nextLine();

        Redactor redactor = buscarRedactor(redactors, dni);
        if (redactor == null) {

            System.out.print("Introdueixi el nom del redactor: ");
            String nom = sc.nextLine();

            redactors.add(new Redactor(dni, nom));

            System.out.println("Redactor introduit amb èxit");
        } else {
            System.out.println("Error. Aquest redactor ya existeix a la nostra base de dades");
        }


    }

    public static void eliminarRedactor(ArrayList<Redactor> redactors) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Bones! Eliminarem un redactor.");
        System.out.print("Introdueixi el dni del redactor: ");
        String dni = sc.nextLine();

        Redactor redactor = buscarRedactor(redactors, dni);

        if (redactor != null) {

            redactors.remove(redactor);

            System.out.println("Redactor eliminat amb èxit");
        } else {
            System.out.println("Error. Aquest redactor no existeix a la nostra base de dades");
        }

    }

    public static void introduirNoticia(ArrayList<Redactor> redactors) {
        Scanner sc = new Scanner(System.in);

        System.out.println("¡Hola! Anem a introduir una notícia a un redactor.");
        System.out.print("Introduixi el DNI del redactor: ");
        String dni = sc.nextLine();

        Redactor redactor = buscarRedactor(redactors, dni);

        if (redactor != null) {
            System.out.println("\nMENÚ Crear Notícia");
            System.out.println("1. Crear notícia de futbol.");
            System.out.println("2. Crear notícia de basquet.");
            System.out.println("3. Crear notícia de tenis.");
            System.out.println("4. Crear notícia de F1.");
            System.out.println("5. Crear notícia de motociclisme.\n");
            System.out.println("Introdueixi un número per al tipus de notícia:");
            int tipo = sc.nextInt();
            sc.nextLine();

            System.out.println("Introdueixi el titular de la notícia: ");
            String titular = sc.nextLine();

            switch (tipo) {
                case 1:
                    NoticiaFutbol noticiaFutbol = buscarNoticiaFutbol(redactor.getNoticies(), titular);
                    if (noticiaFutbol == null) {
                        noticiaFutbol = crearNoticiaFutbol(titular);
                        redactor.getNoticies().add(noticiaFutbol);
                        System.out.println("Noticia de Futbol afegida amb èxit");
                    } else {
                        System.out.println(
                                "Aquesta Noticia de Futbol no s'ha pogut crear perque ja estava a aquest redactor.");
                    }
                    break;
                case 2:
                    NoticiaBasquet noticiaBasquet = buscarNoticiaBasquet(redactor.getNoticies(), titular);
                    if (noticiaBasquet == null) {
                        noticiaBasquet = crearNoticiaBasquet(titular);
                        redactor.getNoticies().add(noticiaBasquet);
                        System.out.println("Noticia de Basquet afegida amb èxit");
                    } else {
                        System.out.println(
                                "Aquesta Noticia de Basquet no s'ha pogut crear perque ja estava a aquest redactor.");
                    }
                    break;
                case 3:
                    NoticiaTenis noticiaTenis = buscarNoticiaTenis(redactor.getNoticies(), titular);
                    if (noticiaTenis == null) {
                        noticiaTenis = crearNoticiaTenis(titular);
                        redactor.getNoticies().add(noticiaTenis);
                        System.out.println("Noticia de Tenis afegida amb èxit");
                    } else {
                        System.out.println(
                                "Aquesta Noticia de Tenis no s'ha pogut crear perque ja estava a aquest redactor.");
                    }
                    break;
                case 4:
                    NoticiaF1 noticiaF1 = buscarNoticiaF1(redactor.getNoticies(), titular);
                    if (noticiaF1 == null) {
                        noticiaF1 = crearNoticiaF1(titular);
                        redactor.getNoticies().add(noticiaF1);
                        System.out.println("Noticia de F1 afegida amb èxit");
                    } else {
                        System.out.println("Aquesta Noticia de F1 no s'ha pogut crear perque ja estava a aquest redactor.");
                    }
                    break;
                case 5:
                    NoticiaMotociclisme noticiaMotociclisme = buscarNoticiaMotociclisme(redactor.getNoticies(), titular);
                    if (noticiaMotociclisme == null) {
                        noticiaMotociclisme = crearNoticiaMotociclisme(titular);
                        redactor.getNoticies().add(noticiaMotociclisme);
                        System.out.println("Noticia de Motociclisme afegida amb èxit");
                    } else {
                        System.out.println(
                                "Aquesta Noticia de Motociclisme no s'ha pogut crear perque ja estava a aquest redactor.");
                    }
                    break;
                default:
                    System.out.println("Opció no vàlida.");
            }

        } else {
            System.out.println("Aquest redactor no es troba a la nostra base de dades");
        }

    }

    public static void eliminarNoticia(ArrayList<Redactor> redactors) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Hola! Anem a eliminar una notícia d'un redactor.");
        System.out.print("Introdueixi el DNI del redactor: ");
        String dni = sc.nextLine();

        Redactor redactor = buscarRedactor(redactors, dni);

        if (redactor != null) {
            System.out.println("\nMENÚ Eliminar Notícia");
            System.out.println("1. Eliminar notícia de futbol.");
            System.out.println("2. Eliminar notícia de bàsquet.");
            System.out.println("3. Eliminar notícia de tenis.");
            System.out.println("4. Eliminar notícia de F1.");
            System.out.println("5. Eliminar notícia de motociclisme.\n");
            System.out.println("Introdueix un número per al tipus de notícia:");
            int tipo = sc.nextInt();
            sc.nextLine();

            System.out.println("Introdueix el titular de la notícia: ");
            String titular = sc.nextLine();

            Noticia noticia = null;

            switch (tipo) {
                case 1:
                    noticia = buscarNoticiaFutbol(redactor.getNoticies(), titular);
                    break;
                case 2:
                    noticia = buscarNoticiaBasquet(redactor.getNoticies(), titular);
                    break;
                case 3:
                    noticia = buscarNoticiaTenis(redactor.getNoticies(), titular);
                    break;
                case 4:
                    noticia = buscarNoticiaF1(redactor.getNoticies(), titular);
                    break;
                case 5:
                    noticia = buscarNoticiaMotociclisme(redactor.getNoticies(), titular);
                    break;
                default:
                    System.out.println("Opció no vàlida.");
            }

            if (noticia != null) {
                redactor.getNoticies().remove(noticia);
                System.out.println("Notícia eliminada amb èxit.");
            } else {
                System.out.println("Aquesta notícia no existeix per aquest redactor.");
            }

        } else {
            System.out.println("Aquest redactor no està a la nostra base de dades");
        }

    }

    public static void mostrarNoticiesRedactor(ArrayList<Redactor> redactors) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Hola! Anem a mostrar les notícies d'un redactor.");
        System.out.print("Introdueixi el DNI del redactor: ");
        String dni = sc.nextLine();

        Redactor redactor = buscarRedactor(redactors, dni);

        if (redactor != null) {
            ArrayList<Noticia> noticies = redactor.getNoticies();

            if (!noticies.isEmpty()) {
                System.out.println("Notícies del redactor " + redactor.getNom() + ":");
                for (Noticia noticia : noticies) {
                    System.out.println(noticia);
                }
            } else {
                System.out.println("El redactor no té notícies.");
            }
        } else {
            System.out.println("Aquest redactor no està a la nostra base de dades");
        }

    }

    public static void calcularPreuNoticia(ArrayList<Redactor> redactors) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Hola! Anem a calcular el preu d'una notícia.");
        System.out.print("Introdueixi el DNI del redactor: ");
        String dni = sc.nextLine();

        Redactor redactor = buscarRedactor(redactors, dni);

        if (redactor != null) {
            System.out.println("\nMENÚ Calcular Preu Notícia");
            System.out.println("1. Calcular preu notícia de futbol.");
            System.out.println("2. Calcular preu notícia de bàsquet.");
            System.out.println("3. Calcular preu notícia de tenis.");
            System.out.println("4. Calcular preu notícia de F1.");
            System.out.println("5. Calcular preu notícia de motociclisme.\n");
            System.out.println("Introdueix un número per al tipus de notícia:");
            int tipo = sc.nextInt();
            sc.nextLine();

            System.out.println("Introdueixi el titular de la notícia: ");
            String titular = sc.nextLine();

            Noticia noticia = null;

            switch (tipo) {
                case 1:
                    noticia = buscarNoticiaFutbol(redactor.getNoticies(), titular);
                    break;
                case 2:
                    noticia = buscarNoticiaBasquet(redactor.getNoticies(), titular);
                    break;
                case 3:
                    noticia = buscarNoticiaTenis(redactor.getNoticies(), titular);
                    break;
                case 4:
                    noticia = buscarNoticiaF1(redactor.getNoticies(), titular);
                    break;
                case 5:
                    noticia = buscarNoticiaMotociclisme(redactor.getNoticies(), titular);
                    break;
                default:
                    System.out.println("Opció no vàlida.");
            }

            if (noticia != null) {
                noticia.calcularPreu();
                System.out.println("El preu de la notícia és: " + noticia.getPreu());
            } else {
                System.out.println("Aquesta notícia no existeix per aquest redactor.");
            }

        } else {
            System.out.println("Aquest redactor no està a la nostra base de dades");
        }

    }

    public static void calcularPuntuacioNoticia(ArrayList<Redactor> redactors) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Hola! Anem a calcular la puntuació d'una notícia.");
        System.out.print("Introdueixi el DNI del redactor: ");
        String dni = sc.nextLine();

        Redactor redactor = buscarRedactor(redactors, dni);

        if (redactor != null) {
            System.out.println("\nMENÚ Calcular Puntuació Notícia");
            System.out.println("1. Calcular puntuació notícia de futbol.");
            System.out.println("2. Calcular puntuació notícia de bàsquet.");
            System.out.println("3. Calcular puntuació notícia de tenis.");
            System.out.println("4. Calcular puntuació notícia de F1.");
            System.out.println("5. Calcular puntuació notícia de motociclisme.\n");
            System.out.println("Introdueixi un número per al tipus de notícia:");
            int tipo = sc.nextInt();
            sc.nextLine();

            System.out.println("Introdueixi el titular de la notícia: ");
            String titular = sc.nextLine();

            Noticia noticia = null;

            switch (tipo) {
                case 1:
                    noticia = buscarNoticiaFutbol(redactor.getNoticies(), titular);
                    break;
                case 2:
                    noticia = buscarNoticiaBasquet(redactor.getNoticies(), titular);
                    break;
                case 3:
                    noticia = buscarNoticiaTenis(redactor.getNoticies(), titular);
                    break;
                case 4:
                    noticia = buscarNoticiaF1(redactor.getNoticies(), titular);
                    break;
                case 5:
                    noticia = buscarNoticiaMotociclisme(redactor.getNoticies(), titular);
                    break;
                default:
                    System.out.println("Opció no vàlida.");
            }

            if (noticia != null) {
                noticia.calcularPuntuacio();
                System.out.println("La puntuació de la notícia és: " + noticia.getPuntuacio());
            } else {
                System.out.println("Aquesta notícia no existeix per aquest redactor.");
            }

        } else {
            System.out.println("Aquest redactor no està a la nostra base de dades");
        }

    }

    public static Redactor buscarRedactor(ArrayList<Redactor> redactors, String dni) {
        Redactor redactor = null;
        int i = 0;

        while (i < redactors.size() && redactor == null) {
            if (dni.equalsIgnoreCase(redactors.get(i).getDni())) {
                redactor = redactors.get(i);
            } else {
                i++;
            }
        }
        return redactor;
    }

    public static NoticiaFutbol buscarNoticiaFutbol(ArrayList<Noticia> noticies, String titular) {
        NoticiaFutbol noticiaFutbol = null;
        int i = 0;

        while (noticiaFutbol == null && i < noticies.size()) {
            if (noticies.get(i) instanceof NoticiaFutbol && noticies.get(i).getTitular().equalsIgnoreCase(titular)) {
                noticiaFutbol = (NoticiaFutbol) noticies.get(i);
            }
            i++;
        }

        return noticiaFutbol;
    }

    public static NoticiaBasquet buscarNoticiaBasquet(ArrayList<Noticia> noticies, String titular) {
        NoticiaBasquet noticiaBasquet = null;
        int i = 0;

        while (noticiaBasquet == null && i < noticies.size()) {
            if (noticies.get(i) instanceof NoticiaBasquet && noticies.get(i).getTitular().equalsIgnoreCase(titular)) {
                noticiaBasquet = (NoticiaBasquet) noticies.get(i);
            }
            i++;
        }

        return noticiaBasquet;
    }

    public static NoticiaTenis buscarNoticiaTenis(ArrayList<Noticia> noticies, String titular) {
        NoticiaTenis noticiaTenis = null;
        int i = 0;

        while (noticiaTenis == null && i < noticies.size()) {
            if (noticies.get(i) instanceof NoticiaTenis && noticies.get(i).getTitular().equalsIgnoreCase(titular)) {
                noticiaTenis = (NoticiaTenis) noticies.get(i);
            }
            i++;
        }

        return noticiaTenis;
    }

    public static NoticiaF1 buscarNoticiaF1(ArrayList<Noticia> noticies, String titular) {
        NoticiaF1 noticiaF1 = null;
        int i = 0;

        while (noticiaF1 == null && i < noticies.size()) {
            if (noticies.get(i) instanceof NoticiaF1 && noticies.get(i).getTitular().equalsIgnoreCase(titular)) {
                noticiaF1 = (NoticiaF1) noticies.get(i);
            }
            i++;
        }

        return noticiaF1;
    }

    public static NoticiaMotociclisme buscarNoticiaMotociclisme(ArrayList<Noticia> noticies, String titular) {
        NoticiaMotociclisme noticiaMotociclisme = null;
        int i = 0;

        while (noticiaMotociclisme == null && i < noticies.size()) {
            if (noticies.get(i) instanceof NoticiaMotociclisme
                    && noticies.get(i).getTitular().equalsIgnoreCase(titular)) {
                noticiaMotociclisme = (NoticiaMotociclisme) noticies.get(i);
            }
            i++;
        }

        return noticiaMotociclisme;
    }

    public static NoticiaFutbol crearNoticiaFutbol(String titular) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introdueixi la competició: ");
        String competicio = sc.nextLine();
        System.out.println("Introdueixi el club: ");
        String club = sc.nextLine();
        System.out.println("Introdueixi el jugador: ");
        String jugador = sc.nextLine();

        NoticiaFutbol noticiaFutbol = new NoticiaFutbol(titular, competicio, club, jugador);

        return noticiaFutbol;
    }

    public static NoticiaBasquet crearNoticiaBasquet(String titular) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introdueixi la competició: ");
        String competicio = sc.nextLine();
        System.out.println("Introdueixi el club: ");
        String club = sc.nextLine();

        NoticiaBasquet noticiaBasquet = new NoticiaBasquet(titular, competicio, club);

        return noticiaBasquet;
    }

    public static NoticiaTenis crearNoticiaTenis(String titular) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introduixi la competició: ");
        String competicio = sc.nextLine();
        System.out.println("Introdueixi el tenista: ");
        String tenista = sc.nextLine();

        NoticiaTenis noticiaTenis = new NoticiaTenis(titular, competicio, tenista);

        return noticiaTenis;
    }

    public static NoticiaF1 crearNoticiaF1(String titular) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introdueixi l'escuderia: ");
        String escuderia = sc.nextLine();

        NoticiaF1 noticiaF1 = new NoticiaF1(titular, escuderia);

        return noticiaF1;
    }

    public static NoticiaMotociclisme crearNoticiaMotociclisme(String titular) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Introdueixi l'equip: ");
        String equip = sc.nextLine();

        NoticiaMotociclisme noticiaMotociclisme = new NoticiaMotociclisme(titular, equip);

        return noticiaMotociclisme;
    }
}
