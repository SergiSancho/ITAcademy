package tasca4.n1exercici2;

public class CalculoDni {
    private int dni;
    private char lletra;

    public CalculoDni(int dni){
        this.dni = dni;
        this.lletra = calculaLletraDni(dni);
    }

    public char getLletra() {
        return lletra;
    }

    private char calculaLletraDni(int dni) {
        int resto = dni % 23;
        String lletres = "TRWAGMYFPDXBNJZSQVHLCKE";

        return lletres.charAt(resto);
    }
}
