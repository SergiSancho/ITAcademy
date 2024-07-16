package doctor;

public class Neurologo extends Doctor{

    public Neurologo(String nombre, TipoEspecialidad especialidad, int numeroSala) {
        super(nombre, especialidad, numeroSala);
    }

    @Override
    public void diagnostico(Paciente paciente, String tomografia) {
        String diagnostico = "Tomografia: " + tomografia;
        paciente.getDiagnosticos().add(diagnostico);
    }
}
