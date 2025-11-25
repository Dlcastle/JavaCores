package com.dominique_del_castillo.controladores;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;


@Controller
public class ControladorRecetas {
    private static String[] listaRecetas = {"Pizza", "Espagueti", "Lasaña"};
    private static HashMap<String, String []> recetasConIngredientes = new HashMap<String, String[]>();

    public ControladorRecetas() {
        String [] pizza = {"Pan", "Salsa de tomate", "Queso", "Pepperoni"};
        recetasConIngredientes.put("Pizza", pizza);
        String [] espagueti = {"Pasta", "Salsa de tomate", "Carne molida", "Queso parmesano"};
        recetasConIngredientes.put("Espagueti", espagueti);
        String [] lasaña = {"Pasta", "Salsa de tomate", "Queso", "Albahaca", "Espinaca", "Champiñones"};
        recetasConIngredientes.put("Lasaña", lasaña);
    }

    @GetMapping("/recetas")
    public String obtenerTodasLasReceta(Model model) {
        model.addAttribute("listaRecetas", listaRecetas);
        return "recetas";        
    }
    
    @GetMapping("/recetas/{nombre}")
    public String obtenerRecetaPorNombre(@PathVariable String nombre, Model model){
        String[] ingredientes = recetasConIngredientes.get(nombre);
        model.addAttribute("recetaIngredientes", ingredientes);
        return "detalleReceta";        
    }
}
