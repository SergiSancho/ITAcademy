package doctor;

public class Traumatologo extends Doctor {

    public Traumatologo(String nombre, TipoEspecialidad especialidad, int numeroSala) {
        super(nombre, especialidad, numeroSala);
    }

    @Override
    public void diagnostico(Paciente paciente, String radiografia) {
        String diagnostico = "radriografia: " + radiografia;
        paciente.getDiagnosticos().add(diagnostico);
    }
}
