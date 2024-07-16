import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GestionEscape {

    private static List<Sala> salas = new ArrayList<>();
    private static List<Objeto> objetosInventario = new ArrayList<>();

    public void inicio() {
        boolean salir = false;
        do {
            switch (Entrada.menu()) {
                case 1:
                    crearSala();
                    break;
                case 2:
                    afegirPistaSala();
                    break;
                case 3:
                    introducirObjeto();
                    break;
                case 4:
                    mostrarInventario();
                    break;
                case 5:
                    int id = Entrada.llegirInt("Introduce id del elemento a eliminar");
                    eliminarElementoPorId(id);
                    break;
                case 6:
                    System.out.println("Escapa, mientras puedas... ");
                    salir = true;
                    break;
            }
        } while (!salir);
    }

    private static void crearSala() {
        String nombre = Entrada.llegirString("Introduce nombre de la sala a crear: ");
        if (buscarSala(nombre) == null) {
            TipoDificultad tipoDificultad = null;
            do {
                try{
                    int nivel= Entrada.llegirInt("Introduce un número para tipo de dificultad" +
                            "\n1.Facil 2.Media 3.Dificil:  ");
                    tipoDificultad = TipoDificultad.fromInt(nivel);
                } catch (IllegalArgumentException e){
                    System.out.println(e.getMessage());
                }
            } while(tipoDificultad == null);
            salas.add(new Sala(nombre, tipoDificultad));
            System.out.println("Sala creada correctamente");
        } else {
            System.out.println("Ya existe un sala con este nombre");
        }
    }

    public static void afegirPistaSala() {
        System.out.println("Añadiremos una pista a una sala");
        Sala sala = elegirSala();
        if (sala != null) {
            String nombre = Entrada.llegirString("Introduce nombre de la pista: ");
            double precio = Entrada.llegirDouble("Introduce precio de la pista: ");
            int minutosEstimados = Entrada.llegirInt("Introduce minutos estimados para resolver: ");
            String tematica = Entrada.llegirString("Introduce temática de la pista: ");

            sala.getPistas().add(new Pista(nombre, precio, minutosEstimados, tematica));
            System.out.println("Pista añadida correctamente");
        } else {
            System.out.println("Pista no añadida. No se asignó una sala válida");
        }
    }

    public static void introducirObjeto() {
      boolean salir = false;
      do {
          int opcion = Entrada.llegirInt("1. Crear nuevo objeto\n" +
                  "2. Añadir objeto a sala\n3. Volver al menú principal\nIntroduce una opción");
          switch (opcion){
              case 1:
                  crearObjeto();
                  break;
              case 2:
                  afegirObjetoSala();
                  break;
              case 3:
                  salir = true;
                  break;
              default:
                  System.out.println("Opción no válida");
                  break;
          }
      } while (!salir);
    }

    public static void afegirObjetoSala(){
        System.out.println("Añadiremos un objeto a una sala");
        Sala sala = elegirSala();
        if (sala != null) {
            Objeto objeto = elegirObjeto();
            if (objeto != null) {
                boolean eliminado = objetosInventario.remove(objeto);
                if (eliminado) {
                    sala.getObjetos().add(objeto);
                    System.out.println("Objeto añadido a la sala correctamente.");
                } else {
                    System.out.println("Objeto no añadido a la sala");
                }
            } else {
                System.out.println("Selección no válida.");
            }
        } else {
            System.out.println("Objeto no añadido. No se asignó una sala válida");
        }
    }

    public static void mostrarInventario () {
        double valorTotal = 0.0;
        for (Sala sala : salas) {
            sala.mostrarPistasSala();
            sala.mostrarObjetosSala();
            valorTotal+= sala.calculaPrecioTotal();
        }
        System.out.println("Objetos sin asignar a salas: ");
        if (objetosInventario != null && !objetosInventario.isEmpty()) {
            for (Objeto objeto : objetosInventario) {
                System.out.println(objeto);
                valorTotal += objeto.getPrecioConIva();
            }
        } else {
            System.out.println("No hay objetos sin asignar");
        }
        System.out.println("Valor total: " + valorTotal);
    }

    public static void eliminarElementoPorId(int id) {
        Elemento elementoEliminado = null;
        Iterator<Objeto> inventarioIterator = objetosInventario.iterator();
        while (inventarioIterator.hasNext() && elementoEliminado == null) {
            Objeto objeto = inventarioIterator.next();
            if (objeto.getId() == id) {
                elementoEliminado = objeto;
                inventarioIterator.remove();
            }
        }
        if (elementoEliminado == null) {
            Iterator<Sala> salaIterator = salas.iterator();
            while (salaIterator.hasNext() && elementoEliminado == null) {
                Sala sala = salaIterator.next();
                Iterator<Objeto> objetoIterator = sala.getObjetos().iterator();
                while (objetoIterator.hasNext() && elementoEliminado == null) {
                    Objeto objeto = objetoIterator.next();
                    if (objeto.getId() == id) {
                        elementoEliminado = objeto;
                        objetoIterator.remove();
                    }
                }
                if (elementoEliminado == null) {
                    Iterator<Pista> pistaIterator = sala.getPistas().iterator();
                    while (pistaIterator.hasNext() && elementoEliminado == null) {
                        Pista pista = pistaIterator.next();
                        if (pista.getId() == id) {
                            elementoEliminado = pista;
                            pistaIterator.remove();
                        }
                    }
                }
            }
        }
        if (elementoEliminado != null) {
            System.out.println("Se eliminó el elemento:");
            System.out.println(elementoEliminado.toString());
        } else {
            System.out.println("No se encontró ningún elemento con ese id.");
        }
    }

    public static void crearObjeto() {
        System.out.println("Añadiremos un nuevo objeto al inventario");
        String nombre = Entrada.llegirString("Introduce nombre del objeto: ");
        double precio = Entrada.llegirDouble("Introduce precio del objeto: ");
        String tipoMaterial = Entrada.llegirString("Introduce tipo de material: ");
        objetosInventario.add(new Objeto(nombre, precio, tipoMaterial));
        System.out.println("Objeto añadido a inventario correctamente");
    }

    public static Sala buscarSala(String nombre) {
        Sala sala = null;
        int i = 0;
        while (i < salas.size() && sala == null) {
            if (nombre.equalsIgnoreCase(salas.get(i).getNombre())) {
                sala = salas.get(i);
            }
            i++;
        }
        return sala;
    }

    public static Objeto buscarObjeto(int id) {
        Objeto objeto = null;
        int i = 0;
        while (i < objetosInventario.size() && objeto == null) {
            if (id == objetosInventario.get(i).getId()) {
                objeto = objetosInventario.get(i);
            }
            i++;
        }
        return objeto;
    }

    public static Sala elegirSala() {
        if (salas.isEmpty()) {
            System.out.println("No hay ninguna sala disponible");
            return null;
        } else {
            System.out.println("Lista de salas: ");
            for (Sala sala : salas) {
                System.out.println(sala);
            }
            String nombre = Entrada.llegirString("Introduce nombre de la sala: ");
            return buscarSala(nombre);
        }
    }

    public static Objeto elegirObjeto() {
        if (objetosInventario.isEmpty()) {
            System.out.println("No hay objetos en el inventario.");
            return null;
        } else {
            System.out.println("Lista de objetos en el inventario:");
            for (Objeto objeto : objetosInventario) {
                System.out.println(objeto);
            }
            int id = Entrada.llegirInt("Introduce el ID del objeto a añadir a la sala: ");
            return buscarObjeto(id);
        }
    }
}
