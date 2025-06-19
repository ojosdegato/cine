package cine.cartelera.cine.repositories; // Ajusta el paquete si es necesario

import cine.cartelera.cine.entities.PeliculaActor;
import cine.cartelera.cine.entities.PeliculaActorId; // Importa la clave compuesta
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface PeliculaActorRepository extends JpaRepository<PeliculaActor, PeliculaActorId> {
    // Nota: El segundo parámetro de JpaRepository es el tipo de la clave primaria.

    // Métodos personalizados de consulta:

    // 1. Buscar por el ID de la película (parte de la clave compuesta)
    // Spring Data JPA puede inferir esto de la relación @ManyToOne y @MapsId en PeliculaActor
    List<PeliculaActor> findByPeliculaId_PeliculaId(Long peliculaId);
    // Alternativa con @Query si lo anterior no funciona bien o para mayor claridad:
    // @Query("SELECT pa FROM PeliculaActor pa WHERE pa.pelicula.id = :peliculaId")
    // List<PeliculaActor> findByPeliculaId(@Param("peliculaId") Long peliculaId);

    // 2. Buscar por el ID del actor (parte de la clave compuesta)
    List<PeliculaActor> findByActorId_ActorId(Long actorId);
    // Alternativa con @Query:
    // @Query("SELECT pa FROM PeliculaActor pa WHERE pa.actor.id = :actorId")
    // List<PeliculaActor> findByActorId(@Param("actorId") Long actorId);

    // 3. Buscar por el rol, ignorando mayúsculas/minúsculas
    List<PeliculaActor> findByRolIgnoreCase(String rol);

    // 4. Buscar una asociación específica por ambos IDs (película y actor)
    // Cuando la clave primaria es compuesta (PeliculaActorId), puedes buscar por sus componentes directamente:
    Optional<PeliculaActor> findByIdPeliculaIdAndIdActorId(Long peliculaId, Long actorId);
}