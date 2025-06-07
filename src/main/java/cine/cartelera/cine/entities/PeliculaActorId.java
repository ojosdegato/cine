package cine.cartelera.cine.entities;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable // Indica que esta clase puede ser embebida como parte de una clave primaria
public class PeliculaActorId implements Serializable {

    private Long idPelicula; // Parte de la clave primaria compuesta
    private Long idActor;    // Parte de la clave primaria compuesta

    // Constructor vacío (necesario para JPA)
    public PeliculaActorId() {
    }

    // Constructor con campos
    public PeliculaActorId(Long idPelicula, Long idActor) {
        this.idPelicula = idPelicula;
        this.idActor = idActor;
    }

    // Getters y Setters
    public Long getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(Long idPelicula) {
        this.idPelicula = idPelicula;
    }

    public Long getIdActor() {
        return idActor;
    }

    public void setIdActor(Long idActor) {
        this.idActor = idActor;
    }

    // Sobreescritura de equals() y hashCode() es CRÍTICA para claves compuestas
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PeliculaActorId that = (PeliculaActorId) o;
        return Objects.equals(idPelicula, that.idPelicula) &&
                Objects.equals(idActor, that.idActor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPelicula, idActor);
    }

    @Override
    public String toString() {
        return "PeliculaActorId{" +
                "idPelicula=" + idPelicula +
                ", idActor=" + idActor +
                '}';
    }
}
//Resumen del propósito de PeliculaActor:
//        * Conecta Películas con Actores: Permite saber qué actores participaron en qué película.
//        * Almacena Atributos de la Relación: El campo rol es un excelente ejemplo de un atributo que describe la participación del actor en esa película específica, no una propiedad de la película ni del actor por separado.
//        * Permite Consultas Bidireccionales: Puedes encontrar todos los actores de una película o todas las películas de un actor de manera eficiente.
//Recuerda que también necesitarás la entidad Pelicula y Actor correctamente definidas con @Entity y @Table para que esto funcione en H2 con JPA.