package cine.cartelera.cine.repositories;

import cine.cartelera.cine.entities.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {

    // añadir consultas personalizadas.
    List<Pelicula> findByGeneroIgnoreCase(String genero);
}

