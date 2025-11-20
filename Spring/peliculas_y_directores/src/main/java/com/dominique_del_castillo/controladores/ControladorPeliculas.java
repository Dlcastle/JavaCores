package com.dominique_del_castillo.controladores;

import java.util.HashMap;

import org.springframework.http.MediaType; // Para que se vea mas "bonito"
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControladorPeliculas {
    private static HashMap<String, String> listaPeliculas = new HashMap<String, String>();

    public ControladorPeliculas() {
        listaPeliculas.put("Winnie the Pooh", "Don Hall");	
        listaPeliculas.put("El zorro y el sabueso", "Ted Berman");
        listaPeliculas.put("Tarzán", "Kevin Lima");		
        listaPeliculas.put("Mulán", "Barry Cook");
        listaPeliculas.put("Oliver", "Kevin Lima");	
        listaPeliculas.put("Big Hero 6", "Don Hall");	
    }

    @GetMapping(value = "/peliculas", produces = MediaType.TEXT_PLAIN_VALUE) //Ahora toma los saltos de linea
    public String obtenerTodasLasPeliculas(){
        String peliculas = "";
        for (HashMap.Entry<String, String> entrada : listaPeliculas.entrySet()) {
            peliculas += "La película '" + entrada.getKey() + "' fue dirigida por " + entrada.getValue() + ".\n";
        }
        return peliculas;
    }

    @GetMapping(value = "/peliculas/{nombre}", produces = MediaType.TEXT_PLAIN_VALUE)
    public String obtenerPeliculaPorNombre(@PathVariable String nombre){
        String director = listaPeliculas.get(nombre);
        if (director != null) {
            return "La película '" + nombre + "' fue dirigida por " + director + ".";
        } else {
            return "La película no se encuentra en nuestra lista.";
        }
    }

    @GetMapping(value = "peliculas/director/{nombre}", produces = MediaType.TEXT_PLAIN_VALUE)
    public String obtenerPeliculasPorDirector(@PathVariable String nombre){
        String resultados = "";
        for (HashMap.Entry<String, String> entrada : listaPeliculas.entrySet()) {
            if (entrada.getValue().equalsIgnoreCase(nombre)) {
                resultados += "El director " + nombre + " dirigió la película '" + entrada.getKey() + "'.\n";
            }
        }
        if (!resultados.isEmpty()) {
            return resultados;
        } else {
            return "No contamos con películas con ese director en nuestra lista.";
        }
    }

}
