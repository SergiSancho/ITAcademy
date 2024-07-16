public enum Categoria {
    FICCION(1),
    NO_FICCION(2),
    HISTORIA(3),
    ARTE(4),
    OTRAS(5);

    private final int valor;

    Categoria(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public static Categoria fromInt(int valor) {
        switch (valor) {
            case 1:
                return FICCION;
            case 2:
                return NO_FICCION;
            case 3:
                return HISTORIA;
            case 4:
                return ARTE;
            case 5:
                return OTRAS;
            default:
                throw new IllegalArgumentException("Valor no válido para Categoria: " + valor);
        }
    }
}

