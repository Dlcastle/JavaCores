package com.dominiquedelcastillo.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.dominiquedelcastillo.modelos.Cancion;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioCanciones extends CrudRepository<Cancion, Long> {
    
    public List<Cancion> findAll();
}
