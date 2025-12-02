package com.dominiquedelcastillo.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;

import com.dominiquedelcastillo.modelos.Artista;
import com.dominiquedelcastillo.servicios.ServicioArtistas;

import org.springframework.ui.Model;

@Controller
public class ControladorArtistas {
    
    @Autowired
    private ServicioArtistas servicioArtistas;

    @GetMapping("/artistas")
    public String desplegarArtistas(Model model) {
        model.addAttribute("artistas", servicioArtistas.obtenerTodosLosArtistas());
        return "artistas";
    }

    @GetMapping("/artistas/detalle/{idArtista}")
    public String desplegarDetalleArtista(Model model, @PathVariable Long idArtista){
        model.addAttribute("artista", servicioArtistas.obtenerArtistaPorId(idArtista));
        return "detalleArtista";
    }

    @GetMapping("/artistas/formulario/agregar")
    public String formularioAgregarArtista(Model model) {
        if (!model.containsAttribute("artista")) {
            model.addAttribute("artista", new Artista());
        }
        return "agregarArtista";
    }

    @PostMapping("/artistas/procesa/agregar")
    public String procesarAgregarArtista(@Valid @ModelAttribute Artista artista, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("artista", artista);
            return "agregarArtista";
        }
        servicioArtistas.agregarArtista(artista);
        return "redirect:/artistas";
    }

}
