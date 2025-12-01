package com.dominiquedelcastillo.servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.dominiquedelcastillo.modelos.Cancion;
import com.dominiquedelcastillo.repositorios.RepositorioCanciones;

@Service
public class ServicioCanciones {
    
    @Autowired
    private RepositorioCanciones repositorioCanciones;

    public List<Cancion> obtenerTodasLasCanciones() {
        return repositorioCanciones.findAll();
    }

    public Cancion obtenerCancionPorId(Long id) {
        return repositorioCanciones.findById(id).orElse(null);
    }

    public Cancion agregarCancion(Cancion cancion) {
        return repositorioCanciones.save(cancion);
    }

    public Cancion actualizaCancion(Cancion cancion) {
        if (cancion.getId() == null) {
            return null;
        }
        Cancion existente = repositorioCanciones.findById(cancion.getId()).orElse(null);
        if (existente == null) {
            return null;
        }
        
        existente.setTitulo(cancion.getTitulo());
        existente.setArtista(cancion.getArtista());
        existente.setAlbum(cancion.getAlbum());
        existente.setGenero(cancion.getGenero());
        existente.setIdioma(cancion.getIdioma());
        return repositorioCanciones.save(existente);
    }

    public void eliminarCancion(Long id) {
        repositorioCanciones.deleteById(id);
    }
}
