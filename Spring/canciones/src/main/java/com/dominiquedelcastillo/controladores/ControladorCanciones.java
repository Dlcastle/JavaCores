package com.dominiquedelcastillo.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;

import com.dominiquedelcastillo.modelos.Cancion;
import com.dominiquedelcastillo.servicios.ServicioCanciones;

import org.springframework.ui.Model;

@Controller
public class ControladorCanciones {
    
    @Autowired
    private ServicioCanciones servicioCanciones;

    @GetMapping("/canciones")
    public String desplegarCanciones(Model model) {
        model.addAttribute("canciones", servicioCanciones.obtenerTodasLasCanciones());
        return "canciones";
    }

    @GetMapping("/canciones/detalle/{idCancion}")
    public String desplegarDetalleCancion(Model model, @PathVariable Long idCancion) {
        model.addAttribute("cancion", servicioCanciones.obtenerCancionPorId(idCancion));
        return "detalleCancion";
    }

    @GetMapping("/canciones/formulario/agregar")
    public String formularioAgregarCancion(Model model) {
        if (!model.containsAttribute("cancion")) {
            model.addAttribute("cancion", new Cancion());
        }
        return "agregarCancion";
    }

    @PostMapping("/canciones/procesa/agregar")
    public String procesarAgregarCancion(@Valid @ModelAttribute Cancion cancion, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("cancion", cancion);
            return "agregarCancion";
        }
        servicioCanciones.agregarCancion(cancion);
        return "redirect:/canciones";
    }
    
}
