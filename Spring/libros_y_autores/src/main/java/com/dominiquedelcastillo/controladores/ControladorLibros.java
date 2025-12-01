package com.dominiquedelcastillo.controladores;

import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ControladorLibros {
    private static HashMap<String, String> listaLibros = new HashMap<String, String>();

    public ControladorLibros() {
        listaLibros.put("Odisea", "Homero");	
        listaLibros.put("Don Quijote de la Mancha", "Miguel de Cervantes");
        listaLibros.put("El Código Da Vinci", "Dan Brown");		
        listaLibros.put("Alicia en el país de las maravillas", "Lewis Carroll");
        listaLibros.put("El Hobbit", "J.R.R. Tolkien");	
        listaLibros.put("El alquimista", "Paulo Coelho");	
    }

    @GetMapping("/libros")
    public String obtenerTodosLosLibros(Model model) {
        model.addAttribute("libros", listaLibros);
        return "libros";
    }

    @GetMapping("/libros/{titulo}")
    public String obtenerInformacionDeLibro(@PathVariable String titulo, Model model) {
        String autor = listaLibros.get(titulo);
        if (autor == null) {
            model.addAttribute("mensaje", "El libro no se encuentra en nuestra lista.");
        } else {
            model.addAttribute("titulo", titulo);
            model.addAttribute("autor", autor);
        }
        return "detalleLibro";
    }

    @GetMapping("/libros/formulario")
    public String formularioLibro(Model model) {
        return "formularioLibros";
    }

    @PostMapping("/procesa/libro")
    public String procesaLibro(@RequestParam("nombreLibro") String nombreLibro,
                               @RequestParam("nombreAutor") String nombreAutor) {
        listaLibros.put(nombreLibro, nombreAutor);
        return "redirect:/libros";
    }
    
}
