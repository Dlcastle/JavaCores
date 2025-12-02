package com.dominiquedelcastillo.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;

import com.dominiquedelcastillo.modelos.Cancion;
import com.dominiquedelcastillo.modelos.Artista;
import com.dominiquedelcastillo.servicios.ServicioCanciones;
import com.dominiquedelcastillo.servicios.ServicioArtistas;

import org.springframework.ui.Model;

@Controller
public class ControladorCanciones {
    
    @Autowired
    private ServicioCanciones servicioCanciones;
    @Autowired
    private ServicioArtistas servicioArtistas;

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

        model.addAttribute("artistas", servicioArtistas.obtenerTodosLosArtistas());
        return "agregarCancion";
    }

    @PostMapping("/canciones/procesa/agregar")
    public String procesarAgregarCancion(
            @Valid @ModelAttribute Cancion cancion,
            BindingResult result,
            @RequestParam(name = "artistaId", required = false) Long artistaId,
            Model model) {

        // Validar que se haya seleccionado artista
        if (artistaId == null || artistaId <= 0) {
            result.rejectValue("artista", "required", "Debes seleccionar un artista");
        }

        if (result.hasErrors()) {
            model.addAttribute("cancion", cancion);
            model.addAttribute("artistas", servicioArtistas.obtenerTodosLosArtistas());
            return "agregarCancion";
        }

        Artista artista = servicioArtistas.obtenerArtistaPorId(artistaId);
        if (artista == null) {
            result.rejectValue("artista", "invalid", "Artista no válido");
            model.addAttribute("artistas", servicioArtistas.obtenerTodosLosArtistas());
            return "agregarCancion";
        }

        cancion.setArtista(artista);
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
        model.addAttribute("artistas", servicioArtistas.obtenerTodosLosArtistas());
        return "editarCancion";
    }

    @PostMapping("/canciones/procesa/editar/{idCancion}")
    public String procesarEditarCancion(
            @PathVariable Long idCancion,
            @Valid @ModelAttribute Cancion cancion,
            BindingResult result,
            @RequestParam(name = "artistaId", required = false) Long artistaId,
            Model model) {

        if (result.hasErrors()) {
            model.addAttribute("cancion", cancion);
            model.addAttribute("artistas", servicioArtistas.obtenerTodosLosArtistas());
            return "editarCancion";
        }

        if (artistaId != null && artistaId > 0) {
            Artista artista = servicioArtistas.obtenerArtistaPorId(artistaId);
            if (artista == null) {
                model.addAttribute("artistas", servicioArtistas.obtenerTodosLosArtistas());
                return "editarCancion";
            }
            cancion.setArtista(artista);
        } else {
            result.rejectValue("artista", "required", "Debes seleccionar un artista");
            model.addAttribute("artistas", servicioArtistas.obtenerTodosLosArtistas());
            return "editarCancion";
        }

        cancion.setId(idCancion);
        servicioCanciones.actualizaCancion(cancion);
        return "redirect:/canciones";
    }

    @DeleteMapping("/canciones/eliminar/{idCancion}")
    public String procesarEliminarCancion(@PathVariable Long idCancion) {
        servicioCanciones.eliminarCancion(idCancion);
        return "redirect:/canciones";
    }
}
