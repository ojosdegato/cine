package cine.cartelera.cine.repositories;

import cine.cartelera.cine.entities.Proyeccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProyeccionRepository extends JpaRepository<Proyeccion, Long> {
}