package cine.cartelera.cine.services; // Ajusta el paquete según tu estructura

import cine.cartelera.cine.entities.Actor;
import java.util.List;
import java.util.Optional;

/**
 * Interfaz para el servicio de gestión de Actores.
 * Define las operaciones de negocio que se pueden realizar sobre la entidad Actor.
 */
public interface ActorService {

    /**
     * Guarda un nuevo actor o actualiza uno existente.
     * @param actor El objeto Actor a guardar.
     * @return El actor guardado, con su ID asignado si era nuevo.
     */
    Actor guardarActor(Actor actor);

    /**
     * Busca un actor por su ID.
     * @param id El ID del actor a buscar.
     * @return Un Optional que contendrá el Actor si se encuentra, o estará vacío si no.
     */
    Optional<Actor> buscarActorPorId(Long id);

    /**
     * Obtiene una lista de todos los actores.
     * @return Una lista de objetos Actor.
     */
    List<Actor> obtenerTodosLosActores();

    /**
     * Elimina un actor por su ID.
     * @param id El ID del actor a eliminar.
     */
    void eliminarActor(Long id);

    /**
     * Busca actores por su nacionalidad.
     * @param nacionalidad La nacionalidad por la que buscar.
     * @return Una lista de actores que coinciden con la nacionalidad.
     */
    List<Actor> buscarActoresPorNacionalidad(String nacionalidad);

    Actor saveActor(Actor actor);

    Optional<Actor> getActorById(Long id);

    List<Actor> getAllActors();

    void deleteActor(Long id);

    List<Actor> findActorsByNombre(String nombre);

    List<Actor> findActorsByApellido(String apellido);

    List<Actor> findActorsByNacionalidad(String nacionalidad);

    // Puedes añadir más métodos según las necesidades de tu aplicación
    // Por ejemplo:
    // List<Actor> buscarActoresPorNombreYApellido(String nombre, String apellido);
}