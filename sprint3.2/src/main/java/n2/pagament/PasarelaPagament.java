package n2.pagament;

public class PasarelaPagament {

    public void procesarPagament(MetodePagament metodePagament, double preu) {
        metodePagament.pagar(preu);
    }
}
