public enum TipoDificultad {
    FACIL(1),
    MEDIA(2),
    DIFICIL(3);

    private int nivel;

    TipoDificultad(int nivel) {
        this.nivel = nivel;
    }

    public int getNivel() {
        return nivel;
    }

    public static TipoDificultad fromInt (int nivel){
        switch (nivel){
            case 1:
                return FACIL;
            case 2:
                return MEDIA;
            case 3:
                return DIFICIL;
            default:
                throw new IllegalArgumentException("Valor no válido para Tipo dificultad");
        }
    }
}
