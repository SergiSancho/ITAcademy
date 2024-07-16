import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GestionBiblioteca {

    private static List<RecursoDigital> recursosDigitales = new ArrayList<>();
    private static List<Coleccion> colecciones = new ArrayList<>();

    public void inicio() {
        boolean salir = false;
        do {
            switch (Entrada.menu()) {
                case 1:
                    crearColeccion();
                    break;
                case 2:
                    afegirLibroColeccion();
                    break;
                case 3:
                    introducirRecursoDigital();
                    break;
                case 4:
                    mostrarInventario();
                    break;
                case 5:
                    int id = Entrada.llegirInt("Introduce id del documento a eliminar");
                    eliminarDocumentoPorId(id);
                    break;
                case 6:
                    System.out.println("Hasta luego, ¡Disfruta de la lectura!");
                    salir = true;
                    break;
            }
        } while (!salir);
    }

    public static void crearColeccion() {
        String nombre = Entrada.llegirString("Introduce nombre de la colección a crear: ");
        if (buscarColeccion(nombre) == null) {
            NivelAcceso nivelAcceso = null;
            do {
                try{
                    int nivel= Entrada.llegirInt("Introduce un número para nivel de acceso\n1.Publico 2.Privado 3.Restringido:  ");
                    nivelAcceso = NivelAcceso.fromInt(nivel);
                } catch (IllegalArgumentException e){
                    System.out.println(e.getMessage());
                }
            } while(nivelAcceso == null);
            colecciones.add(new Coleccion(nombre, nivelAcceso));
            System.out.println("Colección creada correctamente");
        } else {
            System.out.println("Ya existe un colección con este nombre");
        }
    }

    public static void afegirLibroColeccion() {
        System.out.println("Añadiremos un libro a una colección.");
        Coleccion coleccion = elegirColeccion();
        if (coleccion != null) {
            String titulo = Entrada.llegirString("Introduce titulo del libro: ");
            double precio = Entrada.llegirDouble("Introduce precio del libro: ");
            double tiempoDeLectura = Entrada.llegirDouble("Introduce horas de lecturas estimada: ");
            Categoria categoria = null;
            do {
                try {
                    int numero = Entrada.llegirInt("Introduce un número para la categoria" +
                            "\n1.Ficción 2.No Ficción 3.Historia 4.Arte 5.Otras:  ");
                    categoria = Categoria.fromInt(numero);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            } while (categoria == null);
            coleccion.getDocumentos().add(new Libro(titulo, precio, tiempoDeLectura, categoria));
            System.out.println("Libro añadido correctamente");
        } else {
            System.out.println("Libro no añadido. No se asignó una colección válida");
        }
    }

    public static void introducirRecursoDigital() {
        System.out.println("Añadiremos un nuevo recurso digital");
        String titulo = Entrada.llegirString("Introduce titulo del recurso digital: ");
        double precio = Entrada.llegirDouble("Introduce precio del recurso digital: ");
        FormatoDigital formatoDigital = null;
        do {
            try {
                int numero = Entrada.llegirInt("Introduce un número para el formato: " +
                        "\n1.Audio 2.Video 3.PDF:  ");
                formatoDigital = FormatoDigital.fromInt(numero);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (formatoDigital == null);
        recursosDigitales.add(new RecursoDigital(titulo, precio, formatoDigital));
        System.out.println("Recurso digital añadido correctamente");
    }

    public static Coleccion buscarColeccion(String nombre) {
        Coleccion coleccion = null;
        int i = 0;
        while (i < colecciones.size() && coleccion == null) {
            if (nombre.equalsIgnoreCase(colecciones.get(i).getNombre())) {
                coleccion = colecciones.get(i);
            }
            i++;
        }
        return coleccion;
    }

    public static Coleccion elegirColeccion() {
        if (colecciones.isEmpty()) {
            System.out.println("No hay ninguna colección disponible");
            return null;
        } else {
            System.out.println("Lista de colecciones: ");
            for (Coleccion coleccion : colecciones) {
                System.out.println(coleccion);
            }
            String nombre = Entrada.llegirString("Introduce nombre de la colección: ");
            return buscarColeccion(nombre);
        }
    }

    public static void mostrarInventario() {
        double valorTotal = 0.0;
        int numeroDocumentos = 0;

        for (Coleccion coleccion : colecciones) {
            System.out.println("Colección: " + coleccion.getNombre());

            for (Documento documento : coleccion.getDocumentos()) {
                valorTotal += documento.getPrecioConIva();
                numeroDocumentos++;
                System.out.println("ID: " + documento.getId());
                System.out.println("Titulo: " + documento.getTitulo());
                System.out.println("Precio con IVA: " + documento.getPrecioConIva());
                System.out.println("---------------------------------------");
            }
        }
        System.out.println("Recursos Digitales: ");
        for (RecursoDigital recursoDigital : recursosDigitales){
            valorTotal += recursoDigital.getPrecioConIva();
            numeroDocumentos++;
            System.out.println("ID: " + recursoDigital.getId());
            System.out.println("Titulo: " + recursoDigital.getTitulo());
            System.out.println("Precio con IVA: " + recursoDigital.getPrecioConIva());
            System.out.println("---------------------------------------");
        }
        System.out.println("Numero total de documentos: " + numeroDocumentos);
        System.out.println("Valor total del inventario: " + valorTotal);
    }

    public static void eliminarDocumentoPorId(int id) {
        Documento documentoEliminado = null;
        Iterator<Coleccion> coleccionIterator = colecciones.iterator();
        while (coleccionIterator.hasNext() && documentoEliminado == null) {
            Coleccion coleccion = coleccionIterator.next();
            Iterator<Documento> documentoIterator = coleccion.getDocumentos().iterator();
            while (documentoIterator.hasNext() && documentoEliminado == null) {
                Documento documento = documentoIterator.next();
                if (documento.getId() == id) {
                    documentoEliminado = documento;
                    documentoIterator.remove();
                }
            }
        }
        if (documentoEliminado == null) {
            Iterator<RecursoDigital> recursoDigitalIterator = recursosDigitales.iterator();
            while (recursoDigitalIterator.hasNext() && documentoEliminado == null) {
                RecursoDigital recursoDigital = recursoDigitalIterator.next();
                if (recursoDigital.getId() == id) {
                    documentoEliminado = recursoDigital;
                    recursoDigitalIterator.remove();
                }
            }
        }
        if (documentoEliminado != null) {
            System.out.println("Se eliminó el documento:");
            System.out.println(documentoEliminado.toString());
        } else {
            System.out.println("No se encontró ningún documento con ese id");
        }
    }
}
