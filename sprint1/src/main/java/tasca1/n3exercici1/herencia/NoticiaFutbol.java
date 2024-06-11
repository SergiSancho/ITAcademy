package tasca1.n3exercici1.herencia;

public class NoticiaFutbol extends Noticia {

    private String competicio;
    private String club;
    private String jugador;

    public NoticiaFutbol(String titular, String competicio, String club, String jugador) {
        super(titular);
        this.competicio = competicio;
        this.club = club;
        this.jugador = jugador;
    }

    public String getCompeticio() {
        return competicio;
    }

    public void setCompeticio(String competicio) {
        this.competicio = competicio;
    }

    public String getClub() {
        return club;
    }

    public void setClub(String club) {
        this.club = club;
    }

    public String getJugador() {
        return jugador;
    }

    public void setJugador(String jugador) {
        this.jugador = jugador;
    }

    @Override
    public void calcularPreu() {
        // TODO Auto-generated method stub
        int preu = 300;

        if (competicio.equalsIgnoreCase("Lliga de Campions")) {
            preu += 100;
        }

        if (club.equalsIgnoreCase("Barça") || club.equalsIgnoreCase("Madrid")) {
            preu += 100;
        }
        if (jugador.equalsIgnoreCase("Ferran Torres") || jugador.equalsIgnoreCase("Benzema")) {
            preu += 50;
        }
        this.preu = preu;
    }

    @Override
    public void calcularPuntuacio() {
        // TODO Auto-generated method stub
        int puntuacio = 5;
        if (competicio.equalsIgnoreCase("Lliga de Campions")) {
            puntuacio += 3;
        }
        if (competicio.equalsIgnoreCase("Lliga")) {
            puntuacio += 2;
        }
        if (club.equalsIgnoreCase("Barça") || club.equalsIgnoreCase("Madrid")) {
            puntuacio += 1;
        }
        if (jugador.equalsIgnoreCase("Ferran Torres") || jugador.equalsIgnoreCase("Benzema")) {
            puntuacio += 1;
        }
        this.puntuacio = puntuacio;
    }

    @Override
    public String toString() {
        return "NoticiaFutbol [competicio=" + competicio + ", club=" + club + ", jugador=" + jugador + ", titular="
                + titular + ", text=" + text + ", puntuacio=" + puntuacio + ", preu=" + preu + "]";
    }
}
