package doctor;

public class Cita {

    private String hora;
    private String fecha;
    private Doctor doctor;
    private final int numCita;
    private static int contadorCitas = 1;

    public Cita(String fecha, String hora, Doctor doctor) {
        this.fecha = fecha;
        this.hora = hora;
        this.doctor = doctor;
        this.numCita = contadorCitas++;
    }

    public int getNumCita(){
        return numCita;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setMedico(Doctor doctor) {
        this.doctor = doctor;
    }

    @Override
    public String toString() {
        return "Cita{" +
                "numCita=" + numCita +  '\'' +
                ", hora='" + hora + '\'' +
                ", fecha='" + fecha + '\'' +
                ", medico='" + doctor;
    }
}
