import clases.Algoritmos;

public class Aplicacion {
    public static void main(String[] args) {
        int pruebaEsPar1 = 13;
        int pruebaEsPar2 = 2;
        int pruebaEsPrimo1 = 7;
        int pruebaEsPrimo2 = 20;
        String pruebaStringEnReversa = "Hola";
        String pruebaEsPalindromo1 = "Reconocer";
        String pruebaEsPalindromo2 = "Rubi";
        int pruebaSecuenciaFizzBuzz = 30;

        // Vemos esPar
        System.out.println(pruebaEsPar1+", es par? " + Algoritmos.esPar(pruebaEsPar1));
        System.out.println(pruebaEsPar2+", es par? " + Algoritmos.esPar(pruebaEsPar2));

        //Vemos esPrimo
        System.out.println(pruebaEsPrimo1+", es primo? " + Algoritmos.esPrimo(pruebaEsPrimo1));
        System.out.println(pruebaEsPrimo2+", es primo? " + Algoritmos.esPrimo(pruebaEsPrimo2));

        //stringEnReversa
        System.out.println(pruebaStringEnReversa + " en reversa: " + Algoritmos.stringEnReversa(pruebaStringEnReversa));

        //esPalindromo
        System.out.println(pruebaEsPalindromo1 + ", es palindromo? " + Algoritmos.esPalindromo(pruebaEsPalindromo1)); //Aplique .toLowerCase para aceptar casos con mayusculas
        System.out.println(pruebaEsPalindromo2 + ", es palindromo? " + Algoritmos.esPalindromo(pruebaEsPalindromo2));

        //secuenciaFizzBuzz
        Algoritmos.secuenciaFizzBuzz(pruebaSecuenciaFizzBuzz);
    }
}
