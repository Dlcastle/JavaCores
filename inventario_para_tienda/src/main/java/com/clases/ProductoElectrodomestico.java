package com.clases;

public class ProductoElectrodomestico {
    private String nombre;
    private Double precio;
    private Integer cantidadDisponible;

    public ProductoElectrodomestico(){
    }

    public ProductoElectrodomestico(String nombre, Double precio){
        this.nombre = nombre;
        this.precio = precio;
        this.cantidadDisponible = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(Integer cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public void mostrarInformacion(){
        System.out.println("-------------------------------");
        System.out.println("Nombre producto -> " + this.nombre);
        System.out.println("Precio producto -> " + this.precio);
        System.out.println("Cantidad disponible -> " + cantidadDisponible);
    }
}
