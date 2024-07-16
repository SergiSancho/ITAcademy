package doctor;

import java.util.ArrayList;
import java.util.List;

public class Gestion {

    private static List<Paciente> pacientes = new ArrayList<>();
    private static List<Doctor> doctores = new ArrayList<>();

    static {
        doctores.add(new General("Laura", TipoEspecialidad.GENERAL, 1));
        doctores.add(new Neurologo("Marta", TipoEspecialidad.NEUROLOGIA, 2));
        doctores.add(new Traumatologo("Sandra", TipoEspecialidad.TRAUMATOLOGIA, 3));
    }

    public void inicio() {
        boolean salir = false;
        do {
            switch (Entrada.menu()) {
                case 1:
                    afegirPaciente();
                    break;
                case 2:
                    asignarCita();
                    break;
                case 3:
                    eliminarCita();
                    break;
                case 4:
                    String dni = Entrada.llegirString("Introduce dni paciente para ver sus citas: ");
                    try {
                        Paciente paciente = buscarPaciente(dni);
                        mostraCitasPaciente(paciente);
                    } catch (PacienteNoEncontradoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    Doctor doctor = elegirDoctor();
                    if (doctor != null) {
                        mostraCitasDoctor(doctor);
                    }
                    break;
                case 6:
                    System.out.println("Hasta luego, ¡Salud!");
                    salir = true;
                    break;
            }
        } while (!salir);
    }

    public static void afegirPaciente() {
        String dni = Entrada.llegirString("Introduce Dni del paciente a añadir: ");
        try {
            buscarPaciente(dni);
            System.out.println("Ya existe un paciente con este Dni");
        } catch (PacienteNoEncontradoException e) {
            String nombre = Entrada.llegirString("Introduce nombre del paciente: ");
            pacientes.add(new Paciente(dni, nombre));
            System.out.println("Paciente añadido correctamente");
        }
    }

    public static void asignarCita() {
        String dni = Entrada.llegirString("Asignaremos una cita.\nIntroduce Dni del paciente: ");
        try {
            Paciente paciente = buscarPaciente(dni);
            String fecha = Entrada.llegirString("Introduce fecha de la cita: ");
            String hora = Entrada.llegirString("Introduce hora de la cita: ");
            Doctor doctor = elegirDoctor();
            if (doctor != null) {
                Cita cita = new Cita(fecha, hora, doctor);
                paciente.getCitas().add(cita);
                doctor.agregarCita(cita);
                System.out.println("Cita asignada correctamente");
            } else {
                System.out.println("Cita no asignada. No se asignó un doctor válido");
            }
        } catch (PacienteNoEncontradoException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void eliminarCita() {
        String dni = Entrada.llegirString("Eliminaremos una cita.\nIntroduce Dni del paciente: ");
        try {
            Paciente paciente = buscarPaciente(dni);
            mostraCitasPaciente(paciente);
            if (!paciente.getCitas().isEmpty()) {
                int numCita = Entrada.llegirInt("Introduce numero de cita a eliminar: ");
                Cita cita = buscarCitaPorNumCita(numCita, paciente);
                paciente.getCitas().remove(cita);
                cita.getDoctor().getCitas().remove(cita);
                System.out.println("Cita eliminada correctamente");
            }
        } catch (PacienteNoEncontradoException | CitaNoEncontradaException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Paciente buscarPaciente(String dni) throws PacienteNoEncontradoException {
        Paciente paciente = null;
        int i = 0;
        while (i < pacientes.size() && paciente == null) {
            if (dni.equalsIgnoreCase(pacientes.get(i).getDni())) {
                paciente = pacientes.get(i);
            }
            i++;
        }
        if (paciente == null) {
            throw new PacienteNoEncontradoException("Este paciente no está registrado en la app");
        }
        return paciente;
    }

    public static Doctor elegirDoctor() {
        if (doctores.isEmpty()) {
            System.out.println("No hay doctores en este hospital");
            return null;
        } else {
            System.out.println("Lista de doctores: ");
            for (Doctor doctor : doctores) {
                System.out.println(doctor);
            }
            int id = Entrada.llegirInt("Introduce id del doctor: ");
            try {
                return buscarDoctorPorId(id);
            } catch (DoctorNoEncontradoException e) {
                System.out.println(e.getMessage());
                return null;
            }
        }
    }

    public static Doctor buscarDoctorPorId(int id) throws DoctorNoEncontradoException {
        Doctor doctor = null;
        int i = 0;
        while (i < doctores.size() && doctor == null) {
            if (id == (doctores.get(i).getId())) {
                doctor = doctores.get(i);
            }
            i++;
        }
        if (doctor == null) {
            throw new DoctorNoEncontradoException("Este doctor no está registrado en la app");
        }
        return doctor;
    }

    public static Cita buscarCitaPorNumCita(int numCita, Paciente paciente) throws CitaNoEncontradaException {
        Cita cita = null;
        int i = 0;
        while (i < paciente.getCitas().size() && cita == null) {
            if (numCita == (paciente.getCitas().get(i).getNumCita())) {
                cita = paciente.getCitas().get(i);
            }
            i++;
        }
        if (cita == null) {
            throw new CitaNoEncontradaException("Número de cita incorrecto");
        }
        return cita;
    }

    public static void mostraCitasPaciente(Paciente paciente) {
        if (paciente.getCitas().isEmpty()) {
            System.out.println("Este paciente no tiene citas asignadas.");
        } else {
            for (Cita cita : paciente.getCitas()) {
                System.out.println(cita);
            }
        }
    }

    public static void mostraCitasDoctor(Doctor doctor) {
        if (doctor.getCitas().isEmpty()) {
            System.out.println("El doctor no tiene citas asignadas.");
        } else {
            for (Cita cita : doctor.getCitas()) {
                System.out.println(cita);
            }
        }
    }
}

