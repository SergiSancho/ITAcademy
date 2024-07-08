package tasca1.n2.agenda;

import java.util.ArrayList;
import java.util.List;
import tasca1.n2.fabrica.*;
import tasca1.n2.adreca.*;
import tasca1.n2.telefon.*;
import static tasca1.n2.Entrada.*;

public class Agenda {

    private final List<Contacte> contactes;

    public Agenda() {
        this.contactes = new ArrayList<>();
    }

    public void afegirContacte() {

        String tipusFabrica = llegirString("Selecciona país del contacte (espanya o italia): ");
        FabricaAbstracta fabrica = FabricaProductor.getFabrica(tipusFabrica);
        if (fabrica == null) {
            System.out.println("País encara no vàlid");
            return;
        }

        String nom = llegirString("Introdueix el nom del contacte: ");
        String carrer = llegirString("Introdueix el carrer: ");
        String numero = llegirString("Introdueix el numero del carrer: ");
        String codiPostal = llegirString("Introdueix el codi postal: ");
        String ciutat = llegirString("Introdueix la ciutat: ");
        String numeroTelefon = llegirString("Introdueix el número de telèfon: ");

        Adreca adreca = fabrica.crearAdreca(carrer, numero, codiPostal, ciutat);
        Telefon telefon = fabrica.crearTelefon(numeroTelefon);
        Contacte contacte = new Contacte(nom, adreca, telefon);
        contactes.add(contacte);
        System.out.println("Contacte afegit a l'agenda: " + contacte);
    }

    public void eliminarContacte() {
        if (contactes.isEmpty()) {
            System.out.println("L'agenda està buida");
        } else {
            int index = llegirInt("Introdueix índex del contacte a eliminar: ") - 1;
            if (index >= 0 && index < contactes.size()) {
                Contacte contacteEliminat = contactes.remove(index);
                System.out.println("Contacte eliminat de l'agenda: " + contacteEliminat);
            } else {
                System.out.println("Índex de contacte no vàlid");
            }
        }
    }

    public void llistarContactes() {
        if (contactes.isEmpty()) {
            System.out.println("L'agenda està buida");
        } else {
            System.out.println("Contactes a l'agenda:");
            for (int i = 0; i < contactes.size(); i++) {
                System.out.println((i + 1) + ". " + contactes.get(i).getNom());
                System.out.println("   Telèfon: " + contactes.get(i).getTelefonContacte().getTelefon());
                System.out.println("   Adreça: " + contactes.get(i).getAdrecaContacte().getAdreca());
            }
        }
    }
}