package cine.cartelera.cine.repositories;

import cine.cartelera.cine.entities.Sala;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface SalaRepository extends JpaRepository<Sala, Long> {

    Optional<Sala> findByNombre(String nombre);

    boolean existsByNombre(String nombre);

    List<Sala> findByAforoGreaterThanEqual(int capacidadMinima);
}