package com.clases;

public class ComputadoraPortatil extends ProductoElectrodomestico {
    private String marca;
    private Double memoriaRam;
    private Integer numeroSerie;

    public ComputadoraPortatil(String nombre, Double precio, String marca, Double memoriaRam, Integer numeroSerie) {
        super(nombre, precio);
        this.marca = marca;
        this.memoriaRam = memoriaRam;
        this.numeroSerie = numeroSerie;
    }

    public void mostrarInformacion(){
        super.mostrarInformacion();
        System.out.println("Marca -> " + this.marca);
        System.out.println("Memoria RAM (GB) -> " + this.memoriaRam);
        System.out.println("Numero serie -> " + this.numeroSerie);
    }    
}
