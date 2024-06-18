package tasca6.n1exercici2;

public class GenericMethods {
    public static <T> void printArguments(T arg1, T arg2, T arg3){
        System.out.println("Arguments: ");
        System.out.println(arg1);
        System.out.println(arg2);
        System.out.println(arg3);
    }
}
