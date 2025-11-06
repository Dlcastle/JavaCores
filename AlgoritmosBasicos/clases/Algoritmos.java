package clases;

public class Algoritmos {

    public static boolean esPar(int numeroEntero){
        if (numeroEntero%2==0) {
            return true;            
        } else {
            return false;
        }
    }

    public static boolean esPrimo(int numeroEntero){
        if (numeroEntero<=1) return false; //En caso de que se ingrese 0 o negativos
        if (numeroEntero==2) return true; // Caso numero 2
        if (numeroEntero>2) { //Resto de casos
            for (int i = 2; i < numeroEntero-1; i++) {
                if (numeroEntero%i == 0) {
                    return false; //Si alguno lo divide, significa que no es primo
                }            
            }
        }

        return true;
    }

    public static String stringEnReversa(String cadena){
        int largoCadena = cadena.length();
        String cadenaReversa = "";
        for (int i = largoCadena - 1; i >= 0; i--) {
            cadenaReversa+=cadena.charAt(i);
        }

        return cadenaReversa;
    }

    public static boolean esPalindromo(String cadenaCombrobar){
        String cadenaReversa = stringEnReversa(cadenaCombrobar); // Reuso la funcion ant
        if (cadenaCombrobar.equalsIgnoreCase(cadenaReversa)) return true; 
        return false;
    }

    public static void secuenciaFizzBuzz(int numeroEntero){
        String mensaje;
        String mensajeCompleto = "";
        for (int i=1; i<=numeroEntero; i++) {
            mensaje = "";
            if (i%3==0) mensaje+="Fizz"; 
            if (i%5==0) mensaje+="Buzz";
            
            if (mensaje.equals("")) {
                mensajeCompleto += " " + i;
            } else {
                mensajeCompleto += " " + mensaje;
            }
        }

        System.out.println(mensajeCompleto.trim());
    }
}