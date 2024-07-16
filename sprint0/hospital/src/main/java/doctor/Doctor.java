package doctor;

import java.util.ArrayList;
import java.util.List;

public abstract class Doctor {

    private static int idContador = 1;
    protected int id;
    protected String nombre;
    protected TipoEspecialidad especialidad;
    protected int numeroSala;
    protected List<Cita> citasDoctor;

    public Doctor(String nombre, TipoEspecialidad especialidad, int numeroSala) {
        this.id = idContador++;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.numeroSala = numeroSala;
        this.citasDoctor = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public TipoEspecialidad getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(TipoEspecialidad especialidad) {
        this.especialidad = especialidad;
    }

    public int getNumeroSala() {
        return numeroSala;
    }

    public void setNumeroSala(int numeroSala) {
        this.numeroSala = numeroSala;
    }

    public List<Cita> getCitas() {
        return citasDoctor;
    }

    public void agregarCita(Cita cita) {
        this.citasDoctor.add(cita);
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", especialidad=" + especialidad +
                ", numeroSala=" + numeroSala +
                '}';
    }

    public abstract void diagnostico(Paciente paciente, String diagnostico);
}
