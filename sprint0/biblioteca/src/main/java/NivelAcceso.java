public enum NivelAcceso {
    PUBLICO(1),
    PRIVADO(2),
    RESTRINGIDO(3);

    public final int valor;

    NivelAcceso(int valor) {
        this.valor = valor;
    }

    public int getValor(){
        return valor;
    }

    public static NivelAcceso fromInt(int valor){
        switch (valor){
            case 1:
                return PUBLICO;
            case 2:
                return PRIVADO;
            case 3:
                return RESTRINGIDO;
            default:
                throw new IllegalArgumentException("valor no válido");
        }
    }
}
