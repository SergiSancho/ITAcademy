package tasca1.n3exercici1.herencia;

public class NoticiaBasquet extends Noticia {

    private String competicio;
    private String club;

    public NoticiaBasquet(String titular, String competicio, String club) {
        super(titular);
        this.competicio = competicio;
        this.club = club;
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

    @Override
    public void calcularPreu() {
        // TODO Auto-generated method stub
        int preu = 250;

        if (competicio.equalsIgnoreCase("Eurolliga")) {
            preu += 75;
        }

        if (club.equalsIgnoreCase("Barça") || club.equalsIgnoreCase("Madrid")) {
            preu += 75;
        }

        this.preu = preu;
    }

    @Override
    public void calcularPuntuacio() {
        // TODO Auto-generated method stub
        int puntuacio = 4;
        if (competicio.equalsIgnoreCase("Eurolliga")) {
            puntuacio += 3;
        } else if (competicio.equalsIgnoreCase("ACB")) {
            puntuacio += 2;
        }
        if (club.equalsIgnoreCase("Barça") || club.equalsIgnoreCase("Madrid")) {
            puntuacio += 1;
        }
        this.puntuacio = puntuacio;
    }

    @Override
    public String toString() {
        return "NoticiaBasquet [competicio=" + competicio + ", club=" + club + ", titular=" + titular + ", text=" + text
                + ", puntuacio=" + puntuacio + ", preu=" + preu + "]";
    }
}
