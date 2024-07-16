public enum Iva {
    IVA_PISTA(0.10),
    IVA_OBJETO(0.21);

    private double porcentaje;

    Iva(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public double getPorcentaje() {
        return porcentaje;
    }
}
