package tasca8.n2exercici3;

public class Main {
    public static void main(String[] args) {
        Operador suma = (a, b) -> a + b;
        Operador resta = (a, b) -> a - b;
        Operador multiplicacio = (a, b) -> a * b;
        Operador divisio = (a, b) -> a / b;

        float a = 3.0f;
        float b = 1.5f;

        System.out.println(a + " + " + b + " es: " + suma.operacio(a, b));
        System.out.println(a + " - " + b + " es: " + resta.operacio(a, b));
        System.out.println(a + " x " + b + " es: " + multiplicacio.operacio(a, b));
        System.out.println(a + " / " + b + " es: " + divisio.operacio(a, b));
    }
}
