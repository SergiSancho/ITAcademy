package doctor;

public class General extends Doctor{
    public General(String nombre, TipoEspecialidad especialidad, int numeroSala) {
        super(nombre, especialidad, numeroSala);
    }

    @Override
    public void diagnostico(Paciente paciente, String diagnostico) {
        String diagnosticoFinal = "Diagnóstico: " + diagnostico;
        paciente.getDiagnosticos().add(diagnosticoFinal);
    }
}
