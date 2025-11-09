package com.clases;

public class Televisor extends ProductoElectrodomestico {
    private Double tamanoPantalla;
    //Resolucion como (px ancho) X (px alto)
    private Integer pixelesAlto;
    private Integer pixelesAncho;

    public Televisor(String nombre, Double precio, Double tamanoPantalla, Integer pixelesAlto, Integer pixelesAncho) {
        super(nombre, precio);
        this.tamanoPantalla = tamanoPantalla;
        this.pixelesAlto = pixelesAlto;
        this.pixelesAncho = pixelesAncho;
    }

    public void mostrarInformacion(){
        super.mostrarInformacion();
        System.out.println("Tamano pantalla (Inches) -> " + this.tamanoPantalla);
        System.out.println("Resolucion -> " + this.pixelesAncho + "X" + this.pixelesAlto);
    }
}
