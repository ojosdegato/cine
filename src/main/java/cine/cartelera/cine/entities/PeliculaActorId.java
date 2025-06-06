package cine.cartelera.cine.entities;

import java.io.Serializable;
import java.util.Objects;

// Clase para la clave primaria compuesta de PeliculaActor
public class PeliculaActorId implements Serializable {

    private Long idPelicula;
    private Long idActor;

    // Constructor(es)
    public PeliculaActorId() {}

    public PeliculaActorId(Long idPelicula, Long idActor) {
        this.idPelicula = idPelicula;
        this.idActor = idActor;
    }

    // Implementación de equals() y hashCode() es OBLIGATORIA para claves compuestas
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PeliculaActorId that = (PeliculaActorId) o;
        return idPelicula.equals(that.idPelicula) && idActor.equals(that.idActor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPelicula, idActor);
    }
}

//Resumen del propósito de PeliculaActor:
//        * Conecta Películas con Actores: Permite saber qué actores participaron en qué película.
//        * Almacena Atributos de la Relación: El campo rol es un excelente ejemplo de un atributo que describe la participación del actor en esa película específica, no una propiedad de la película ni del actor por separado.
//        * Permite Consultas Bidireccionales: Puedes encontrar todos los actores de una película o todas las películas de un actor de manera eficiente.
//Recuerda que también necesitarás la entidad Pelicula y Actor correctamente definidas con @Entity y @Table para que esto funcione en H2 con JPA.