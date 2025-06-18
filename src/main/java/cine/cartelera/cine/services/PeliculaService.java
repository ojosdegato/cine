package cine.cartelera.cine.services;

import cine.cartelera.cine.entities.Pelicula;
import cine.cartelera.cine.repositories.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public interface PeliculaService {
    List<Pelicula> listarTodas();

    Optional<Pelicula> buscarPorId(Long id);

    Pelicula guardar(Pelicula pelicula);

    void eliminar(Long id);



}

