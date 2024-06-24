package tasca8.n1exercici8;

public class Main {
    public static void main(String[] args) {
        StringReves instancia = (String str) -> {
            StringBuilder sb = new StringBuilder(str);
            return sb.reverse().toString();
        };

        /*StringReves instancia = str -> {
            String resultat="";
            for (int i = str.length() -1; i >= 0; i --){
                resultat +=  str.charAt(i);
            }
            return resultat;
        };*/

        String palindromo = "in girum imus nocte et consumimur igni";
        System.out.println(palindromo);
        System.out.println(instancia.reverse(palindromo));
    }
}
