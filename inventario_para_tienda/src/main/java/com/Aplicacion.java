package com;

import com.clases.ComputadoraPortatil;
import com.clases.Televisor;
import com.clases.TiendaElectronica;

public class Aplicacion {
    public static void main(String[] args) {
        //Mi tienda
        TiendaElectronica myTienda = new TiendaElectronica();

        //Productos
        Televisor tele1 = new Televisor("AOC-2025", 300.0, 10.0, 1080, 1920);
        Televisor tele2 = new Televisor("Samsung-Ultra", 500.0, 15.0, 2160, 3840);
        ComputadoraPortatil compu1 = new ComputadoraPortatil("HP-15", 700.0, "HP", 512.0, 1345216);
        ComputadoraPortatil compu2 = new ComputadoraPortatil("MacBook-Air", 1200.0, "Apple", 256.0, 9876543);

        // Agregar a tienda
        myTienda.agregarProducto(tele1);
        myTienda.agregarProducto(tele1);
        myTienda.agregarProducto(tele2);
        myTienda.agregarProducto(compu1);
        myTienda.agregarProducto(compu2);

        // Mostrar si se agregaron
        System.out.println("Productos disponibles en la tienda:");
        myTienda.mostrarProductosDisponibles();
        System.out.println("\n");

        // Buscar un producto
        myTienda.buscarProducto("MacBook-Air");
        myTienda.buscarProducto("AOC-2025");
        myTienda.buscarProducto("sjdksjl"); //no existe
        System.out.println("\n");

        //Vender
        myTienda.venderProducto(tele1);
        myTienda.venderProducto(compu2);
        myTienda.venderProducto(compu2);

        // Mostrar productos despues de la venta
        System.out.println("\n");
        System.out.println("Productos disponibles en la tienda despues de la venta:");
        myTienda.mostrarProductosDisponibles();

    }
}
