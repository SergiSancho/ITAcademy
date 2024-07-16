import java.util.ArrayList;
import java.util.List;

public class GestorMercado {

    private static List<Vendedor> vendedores = new ArrayList<>();

    public void inicio() {
        boolean salir = false;
        do {
            switch (Entrada.menu()) {
                case 1:
                    crearVendedor();
                    break;
                case 2:
                    afegirItemVendedor();
                    break;
                case 3:
                    mostrarItemsVendedor();
                    break;
                case 4:
                    realizarVenta();
                    break;
                case 5:
                    System.out.println("Gracias por su visita. No se admiten devoluciones... ");
                    salir = true;
                    break;
            }
        } while (!salir);
    }

    public static void crearVendedor() {
        String nombre = Entrada.llegirString("Crearemos un nuevo Vendedor. Introduce su nombre: ");
        Vendedor vendedor = buscarVendedor(nombre);
        if (vendedor == null) {
            String ciudad = Entrada.llegirString("Introduce la ciudad del vendedor: ");
            boolean salir = false;
            do {
                int opcion = Entrada.llegirInt("1.Campesino 2.Ladron 3.Mercader\n" +
                        "Introduce un número para el tipo de vendedor: ");
                switch (opcion) {
                    case 1:
                        vendedores.add(new Campesino(nombre, ciudad));
                        salir = true;
                        break;
                    case 2:
                        vendedores.add(new Ladron(nombre, ciudad));
                        salir = true;
                        break;
                    case 3:
                        vendedores.add(new Mercader(nombre, ciudad));
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no valida");
                        break;
                }
            } while (!salir);
            System.out.println("Vendedor creado correctamente");
        } else {
            System.out.println("Ya existe un vendedor con este nombre");
        }
    }

    public static void afegirItemVendedor() {
        String nombre = Entrada.llegirString("Introduce el nombre del vendedor al que añadir item: ");
        Vendedor vendedor = buscarVendedor(nombre);
        if (vendedor != null) {
            String nombreItem = Entrada.llegirString("Introduce nombre del item: ");
            Item item = buscarItemVendedor(nombreItem, vendedor);
            if (item == null){
                String tipo = Entrada.llegirString("Introduce tipo del item: ");
                double precio = Entrada.llegirDouble("Introduce precio del item: ");
                boolean creado = vendedor.afegirItemInventario(new Item(nombreItem, tipo, precio));
                if (creado){
                    System.out.println("Item añadido correctamente al vendedor");
                } else {
                    System.out.println("No se pudo crear item. No hay espacio en la lista de items del vendedor.");
                }
            } else {
                System.out.println("Ya existe un item con este nombre en este vendedor");
            }
        } else {
            System.out.println("No existe este vendedor");
        }
    }

    public static void mostrarItemsVendedor() {
        System.out.println("Lista de vendedores: ");
        if (vendedores != null && !vendedores.isEmpty()) {
            for (Vendedor vendedor : vendedores) {
                System.out.println(vendedor);
            }
            String nombre = Entrada.llegirString("Introduce nombre del vendedor: ");
            Vendedor vendedor = buscarVendedor(nombre);
            if (vendedor != null) {
                System.out.println("Lista de items de " + vendedor.getNombre() + ":");
                if (vendedor.getInventario() != null && !vendedor.getInventario().isEmpty()){
                    for (Item item : vendedor.getInventario()) {
                        System.out.println(item);
                    }
                } else {
                    System.out.println("No tiene items");
                }
            } else {
                System.out.println("No existe un vendedor con este nombre");
            }
        } else {
            System.out.println("No hay vendedores");
        }
    }

    public static void realizarVenta() {
        String nombre = Entrada.llegirString("Introduce nombre del vendedor: ");
        Vendedor vendedor = buscarVendedor(nombre);
        if (vendedor != null) {
            String nombreItem = Entrada.llegirString("Introduce nombre del item a comprar: ");
            Item item = buscarItemVendedor(nombreItem, vendedor);
            if (item != null) {
                List<Item> ticket = new ArrayList<>();
                vendedor.getInventario().remove(item);
                System.out.println("Ha comprado el item:");
                System.out.println(item);
            } else {
                System.out.println("No existe este item en este vendedor");
            }
        } else {
            System.out.println("No existe este vendedor");
        }

    }


    public static Vendedor buscarVendedor(String nombre){
        Vendedor vendedor = null;
        int i = 0;
        while (i < vendedores.size() && vendedor == null){
            if(nombre.equalsIgnoreCase(vendedores.get(i).getNombre())){
                vendedor = vendedores.get(i);
            }
            i++;
        }
        return vendedor;
    }

    public static Item buscarItemVendedor (String nombre, Vendedor vendedor) {
        Item item = null;
        int i = 0;
        while (i < vendedor.getInventario().size() && item == null){
            if(nombre.equalsIgnoreCase(vendedor.getInventario().get(i).getNombre())){
                item = vendedor.getInventario().get(i);
            }
            i++;
        }
        return item;
    }
}
