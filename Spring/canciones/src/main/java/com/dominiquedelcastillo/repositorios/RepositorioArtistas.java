package com.dominiquedelcastillo.repositorios;

import com.dominiquedelcastillo.modelos.Artista;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioArtistas extends CrudRepository<Artista, Long> {
    
    public List<Artista> findAll();
}
