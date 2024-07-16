public enum Iva {
    LIBRO(0.10),
    RECURSODIGITAL(0.21);

    private final double valor;

    Iva(double valor) {
        this.valor = valor;
    }

    public double getValor() {
        return valor;
    }
}
