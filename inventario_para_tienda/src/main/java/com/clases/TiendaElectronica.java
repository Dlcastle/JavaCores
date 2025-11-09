package com.clases;

import java.util.ArrayList;

public class TiendaElectronica {
    private ArrayList<ProductoElectrodomestico> listaDeProductos;

    public TiendaElectronica(){
        this.listaDeProductos = new ArrayList<ProductoElectrodomestico>();
    }

    public void agregarProducto(ProductoElectrodomestico producto){
        // Asumo que si un producto ya esta en inventario, solo se aumenta su cantidad
        if (!listaDeProductos.contains(producto)){
            listaDeProductos.add(producto);
        }
        Integer cantidadProducto = producto.getCantidadDisponible();
        producto.setCantidadDisponible(cantidadProducto+1);
    }

    public void mostrarProductosDisponibles(){
        for (ProductoElectrodomestico productoElectrodomestico : listaDeProductos) {
            productoElectrodomestico.mostrarInformacion();
        }
    }

    public void buscarProducto(String nombre){
        Boolean encontrado = false;
        for (ProductoElectrodomestico productoElectrodomestico : listaDeProductos) {
            if (productoElectrodomestico.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("-------------------------------");
                System.out.println("Producto encontrado:");
                productoElectrodomestico.mostrarInformacion();
                System.out.println("-------------------------------");
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("Producto no encontrado: " + nombre);
        }
    }
    
    public void venderProducto(ProductoElectrodomestico producto){
        Integer cantidadDisponible = producto.getCantidadDisponible();
        if (cantidadDisponible>0){
            producto.setCantidadDisponible(cantidadDisponible-1);
            System.out.println("Producto vendido: " + producto.getNombre() + ". Cantidad restante en inventario: " + producto.getCantidadDisponible());
        } else{
            System.out.println("Producto agotado: " + producto.getNombre() );
        }
    }
}
