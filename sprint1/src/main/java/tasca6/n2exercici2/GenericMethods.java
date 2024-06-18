package tasca6.n2exercici2;

public class GenericMethods {

        public static <T> void printArguments (T... args){
            System.out.println("Arguments: ");
            for (T arg : args) {
                System.out.println(arg);
            }
        }
}
