package doctor;

import java.util.ArrayList;
import java.util.List;

public class Paciente {

    private int id;
    private static int numPaciente = 1;
    private String dni;
    private String nombre;
    private List<Cita> citas;
    private List<String> diagnosticos;
    private static final String numHospital = "0098766H";

    public Paciente(String dni, String nombre) {
        this.id = numPaciente++;
        this.dni = dni;
        this.nombre = nombre;
        this.citas = new ArrayList<>();
        this.diagnosticos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getDni() {
        return dni;
    }

    public static int getNumPaciente() {
        return numPaciente;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Cita> getCitas() {
        return citas;
    }

    public List<String> getDiagnosticos() {
        return diagnosticos;
    }

    @Override
    public String toString() {
        return "doctor.Paciente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", citas=" + citas +
                ", diagnosticos=" + diagnosticos +
                '}';
    }
}
