package doctor;

import java.util.ArrayList;
import java.util.List;

public class GestionHospital {

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
                    Paciente paciente = buscarPaciente(dni);
                    if (paciente != null){
                        mostraCitasPaciente(paciente);
                    } else {
                        System.out.println("Este paciente no está registrado en la app");
                    }

                    break;
                case 5:
                    Doctor doctor = elegirDoctor();
                    if (doctor != null) {
                        mostraCitasDoctor(doctor);
                    } else {
                        System.out.println("Este doctor no está registrado en la app");
                    }
                    break;
                case 6:
                    System.out.println("Hasta luego, Salud!");
                    salir = true;
                    break;
            }
        } while (!salir);
    }

    public static void afegirPaciente() {
        String dni = Entrada.llegirString("Introduce Dni del paciente a añadir: ");
        if (buscarPaciente(dni) == null) {
            String nombre = Entrada.llegirString("Introduce nombre del paciente: ");
            pacientes.add(new Paciente(dni, nombre));
            System.out.println("Paciente añadido correctamente");
        } else {
            System.out.println("Ya existe un paciente con este Dni");
        }
    }

    public static void asignarCita() {
        String dni = Entrada.llegirString("Asignaremos una cita.\nIntroduce Dni del paciente: ");
        Paciente paciente = buscarPaciente(dni);
        if (paciente != null) {
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

        } else {
            System.out.println("Este paciente no está registrado en la app");
        }
    }

    public static void eliminarCita() {
        String dni = Entrada.llegirString("Eliminaremos una cita.\nIntroduce Dni del paciente: ");
        Paciente paciente = buscarPaciente(dni);
        if (paciente != null) {
            mostraCitasPaciente(paciente);
            if (!paciente.getCitas().isEmpty()){
                int numCita = Entrada.llegirInt("Introduce numero de cita a eliminar: ");
                Cita cita = buscarCitaPorNumCita(numCita, paciente);
                if (cita != null){
                    paciente.getCitas().remove(cita);
                    cita.getDoctor().getCitas().remove(cita);
                } else {
                    System.out.println("Numero de cita incorrecto");
                }
            }
        } else {
            System.out.println("Este paciente no está registrado en la app");
        }
    }

    public static Paciente buscarPaciente(String dni) {
        Paciente paciente = null;
        int i = 0;
        while (i < pacientes.size() && paciente == null) {
            if (dni.equalsIgnoreCase(pacientes.get(i).getDni())) {
                paciente = pacientes.get(i);
            }
            i++;
        }
        return paciente;
    }

    public static Doctor elegirDoctor() {
        if (doctores.isEmpty()) {
            System.out.println("No hay docotores en este hospital");
            return null;
        } else {
            System.out.println("Lista de doctores: ");
            for (Doctor doctor : doctores) {
                System.out.println(doctor);
            }
            int id = Entrada.llegirInt("Introduce id del doctor: ");
            return buscarDoctorPorId(id);
        }
    }

    public static Doctor buscarDoctorPorId(int id) {
        Doctor doctor = null;
        int i = 0;
        while (i < doctores.size() && doctor == null) {
            if (id == (doctores.get(i).getId())) {
                doctor = doctores.get(i);
            }
            i++;
        }
        return doctor;
    }

    public static Cita buscarCitaPorNumCita(int numCita, Paciente paciente) {
        Cita cita = null;
        int i = 0;
        while (i < paciente.getCitas().size() && cita == null) {
            if (numCita == (paciente.getCitas().get(i).getNumCita())) {
                cita = paciente.getCitas().get(i);
            }
            i++;
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
