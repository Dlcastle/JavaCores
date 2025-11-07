package clases;

import java.util.ArrayList;
import java.util.Random;

public class CuentaBancaria {
    private double saldo;
    private Persona titular;
    private int numeroCuenta;
    private static ArrayList<CuentaBancaria> listaDeCuentasBancarias = new ArrayList<>();

    public CuentaBancaria(double saldo, Persona titular){
        this.saldo = saldo;
        this.titular = titular;

        // GEneramos cuenta con Random
        // fuente:
        // https://chuidiang.org/index.php?title=Generar_n%C3%BAmeros_aleatorios_en_Java

        Random rand = new Random();
        int rango = 900_000;
        this.numeroCuenta = rand.nextInt(rango) + 100_000 ;

        if (listaDeCuentasBancarias.size() > 0){
            for (CuentaBancaria cuenta: listaDeCuentasBancarias){
                while (cuenta.getNumeroCuenta() == this.numeroCuenta){
                    this.numeroCuenta = rand.nextInt(rango) + 100_000 ;
                }
            }
        }

        listaDeCuentasBancarias.add(this);
    }

    //No deberia poder setear numero de cuenta ni lista de cuentas

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setTitular(Persona titular) {
        this.titular = titular;
    }

    // Si podría obtenerlas
    public Persona getTitular() {
        return titular;
    }
    
    public double getSaldo() {
        return saldo;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public static ArrayList<CuentaBancaria> getListaDeCuentasBancarias() {
        return listaDeCuentasBancarias;
    }

    public void depositar(double monto){
        this.saldo += monto;
    }

    public void retirar(double monto){
        if (this.saldo>=monto) this.saldo -= monto;
        if (this.saldo<monto) System.out.println("Error, la cuenta no dispone de esa cantidad de dinero");
    }

    public void despliegaInformacion(){
        System.out.println("-------- Informacion de cuenta -----");
        System.out.println("Numero de cuenta -> " + this.numeroCuenta);
        System.out.println("Titular de cuenta -> " + this.titular.getNombre());
        System.out.println("Saldo de cuenta -> " + this.saldo + "\n");
    }

    public static void imprimeInformacionDeTodasLasCuentas(){
        for (CuentaBancaria cuenta: listaDeCuentasBancarias){
            cuenta.despliegaInformacion();
        }
    }

}
