package cine.cartelera.cine.repositories;

import cine.cartelera.cine.entities.Sala;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaRepository extends JpaRepository<Sala, Long> {
}