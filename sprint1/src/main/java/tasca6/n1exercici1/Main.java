package tasca6.n1exercici1;

public class Main {
    public static void main(String[] args) {
      NoGenericMethods exemple1 = new NoGenericMethods("arg1", "arg2", "arg3");
      NoGenericMethods exemple2 = new NoGenericMethods("arg3", "arg1", "arg2");

        System.out.println("Instancia exemple1:");
        System.out.println("arg1: " + exemple1.getArg1());
        System.out.println("arg2: " + exemple1.getArg2());
        System.out.println("arg3: " + exemple1.getArg3());
        System.out.println("Instancia exemple2: ");
        System.out.println("arg1: " + exemple2.getArg1());
        System.out.println("arg2: " + exemple2.getArg2());
        System.out.println("arg3: " + exemple2.getArg3());
    }
}
