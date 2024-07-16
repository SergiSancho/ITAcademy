public enum FormatoDigital {
    AUDIO(1),
    VIDEO(2),
    PDF(3);

    private final int valor;

    FormatoDigital(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public static FormatoDigital fromInt(int valor) {
        switch (valor) {
            case 1:
                return AUDIO;
            case 2:
                return VIDEO;
            case 3:
                return PDF;
            default:
                throw new IllegalArgumentException("Valor no válido para FormatoDigital: " + valor);
        }
    }
}
