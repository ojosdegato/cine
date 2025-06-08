package cine.cartelera.cine.services;

import cine.cartelera.cine.entities.Pelicula;

import java.util.List;
import java.util.Optional;

public interface PeliculaService {
    List<Pelicula> listarTodas();

    Optional<Pelicula> buscarPorId(Long id);

    Pelicula guardar(Pelicula pelicula);

    void eliminar(Long id);
}