package cine.cartelera.cine.services; // Ajusta el paquete si es necesario


import cine.cartelera.cine.entities.PeliculaActor;
import cine.cartelera.cine.entities.PeliculaActorId; // Necesitamos la clase de la clave compuesta
import java.util.List;
import java.util.Optional;

public interface PeliculaActorService {

    /**
     * Guarda una nueva asociación Pelicula-Actor o actualiza una existente.
     * @param peliculaActor El objeto PeliculaActor a guardar o actualizar.
     * @return La asociación PeliculaActor guardada/actualizada.
     */
    PeliculaActor savePeliculaActor(PeliculaActor peliculaActor);

    /**
     * Busca una asociación Pelicula-Actor por su clave primaria compuesta.
     * @param id La clave primaria compuesta (PeliculaActorId).
     * @return Un Optional que contiene la asociación si se encuentra, o vacío si no.
     */
    Optional<PeliculaActor> getPeliculaActorById(PeliculaActorId id);

    /**
     * Obtiene todas las asociaciones Pelicula-Actor.
     * @return Una lista de todas las asociaciones PeliculaActor.
     */
    List<PeliculaActor> getAllPeliculaActores();

    /**
     * Elimina una asociación Pelicula-Actor por su clave primaria compuesta.
     * @param id La clave primaria compuesta (PeliculaActorId).
     */
    void deletePeliculaActor(PeliculaActorId id);

    /**
     * Busca todas las asociaciones para una película específica.
     * Esto mostrará qué actores están en esa película y su rol.
     * @param peliculaId El ID de la película.
     * @return Una lista de asociaciones PeliculaActor para esa película.
     */
    List<PeliculaActor> findByPeliculaId(Long peliculaId);

    /**
     * Busca todas las asociaciones para un actor específico.
     * Esto mostrará en qué películas está ese actor y su rol en cada una.
     * @param actorId El ID del actor.
     * @return Una lista de asociaciones PeliculaActor para ese actor.
     */
    List<PeliculaActor> findByActorId(Long actorId);

    /**
     * Busca asociaciones por el rol específico del actor en la película.
     * @param rol El rol a buscar (ej. "Protagonista", "Secundario").
     * @return Una lista de asociaciones PeliculaActor con ese rol.
     */
    List<PeliculaActor> findByRol(String rol);

    /**
     * Busca la asociación específica entre una película y un actor.
     * @param peliculaId El ID de la película.
     * @param actorId El ID del actor.
     * @return Un Optional que contiene la asociación si existe, o vacío.
     */
    Optional<PeliculaActor> findByPeliculaIdAndActorId(Long peliculaId, Long actorId);
}