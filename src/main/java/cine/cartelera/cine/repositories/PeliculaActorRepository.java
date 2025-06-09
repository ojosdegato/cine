package cine.cartelera.cine.repositories;

import cine.cartelera.cine.entities.PeliculaActor;
import cine.cartelera.cine.entities.PeliculaActorId; // Importa la clase de ID compuesto
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PeliculaActorRepository extends JpaRepository<PeliculaActor, PeliculaActorId> {
    // Aquí también se heredan los métodos CRUD básicos.
    // Para buscar por partes de la clave compuesta o por entidad:
    // List<PeliculaActor> findByPeliculaId(Long peliculaId);
    // List<PeliculaActor> findByActorId(Long actorId);
    // List<PeliculaActor> findByRol(PeliculaActor.UserRole rol);
}