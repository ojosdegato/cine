package cine.cartelera.cine.repositories;

import cine.cartelera.cine.entities.Proyeccion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ProyeccionRepository extends JpaRepository<Proyeccion, Long> {

    List<Proyeccion> findByPelicula_Id(Long peliculaId);

    List<Proyeccion> findBySala_Id(Long salaId);

    List<Proyeccion> findByFechaHoraBetween(LocalDateTime inicio, LocalDateTime fin);

    boolean existsBySala_IdAndFechaHora(Long salaId, LocalDateTime fechaHora);

    List<Proyeccion> findByFechaHoraAfter(LocalDateTime fecha);
}