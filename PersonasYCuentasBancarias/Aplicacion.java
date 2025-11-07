import clases.Persona;
import clases.CuentaBancaria;

public class Aplicacion {
    public static void main(String[] args) {
        Persona persona1 = new Persona("Dominique Del Castillo", 23);
        Persona persona2 = new Persona("Maria Jose Cisterna", 23);
        Persona persona3 = new Persona("Camilo Perez", 25);

        CuentaBancaria cuenta1 = new CuentaBancaria(100, persona1);
        CuentaBancaria cuenta2 = new CuentaBancaria(200, persona2);
        CuentaBancaria cuenta3 = new CuentaBancaria(50, persona3);
        CuentaBancaria cuenta4 = new CuentaBancaria(300, persona3);

        double monto1 = 100;
        double monto2 = 300;
        double monto3 = 20;

        System.out.println("<- Movimientos en las cuentas -> ");

        System.out.println("Saldo antes de deposito de " + monto1 + " cuenta 1 -> " + cuenta1.getSaldo());
        cuenta1.depositar(monto1);
        System.out.println("Saldo luego de deposito cuenta 1 -> " + cuenta1.getSaldo() + "\n");

        System.out.println("Saldo antes de retiro de " + monto2 + " cuenta 2 -> " + cuenta2.getSaldo());
        cuenta2.retirar(monto2);
        System.out.println("Saldo luego de retiro cuenta 2 -> " + cuenta2.getSaldo() + "\n");
        
        System.out.println("Saldo antes de retiro de " + monto3 + " cuenta 3 -> " + cuenta3.getSaldo());
        cuenta3.retirar(monto3);
        System.out.println("Saldo luego de retiro cuenta 3 -> " + cuenta3.getSaldo() + "\n");

        System.out.println("<- Informacion de todas las cuentas -> ");

        CuentaBancaria.imprimeInformacionDeTodasLasCuentas();
    }
}
