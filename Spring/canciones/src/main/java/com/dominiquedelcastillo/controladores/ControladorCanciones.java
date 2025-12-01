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
    
    @GetMapping("/canciones/formulario/editar/{idCancion}")
    public String formularioEditarCancion(Model model, @PathVariable Long idCancion) {
        if (!model.containsAttribute("cancion")) {
            Cancion cancion = servicioCanciones.obtenerCancionPorId(idCancion);
            if (cancion==null) {
                return "redirect:/canciones";
            }
            model.addAttribute("cancion", cancion);
        }
        return "editarCancion";
    }

    @PostMapping("/canciones/procesa/editar/{idCancion}")
    public String procesarEditarCancion(@PathVariable Long idCancion, @Valid @ModelAttribute Cancion cancion, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("cancion", cancion);
            return "editarCancion";
        }
        cancion.setId(idCancion);
        servicioCanciones.actualizaCancion(cancion);
        return "redirect:/canciones";
    }

    @PostMapping("/canciones/eliminar/{idCancion}")
    public String procesarEliminarCancion(@PathVariable Long idCancion) {
        servicioCanciones.eliminarCancion(idCancion);
        return "redirect:/canciones";
    }
}
