package tasca6.n2exercici1;

public class GenericMethods {
    public static <T> void printArguments (T arg1, T arg2, String arg3){
        System.out.println("Arguments: ");
        System.out.println(arg1);
        System.out.println(arg2);
        System.out.println(arg3);
    }

    public static <T, U> void printArguments2 (T arg1, U arg2, String arg3){
        System.out.println("Arguments: ");
        System.out.println(arg1);
        System.out.println(arg2);
        System.out.println(arg3);
    }
}
