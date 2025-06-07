package cine.cartelera.cine.entities;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.JoinColumn;

@Entity // Indica que esta clase es una entidad
public class PeliculaActor {

    @EmbeddedId // Marca que la clave primaria es una clase embebida
    private PeliculaActorId id; // Clave primaria compuesta

    @ManyToOne // Relación muchos-a-uno con Pelicula
    @MapsId("idPelicula") // Mapea la parte 'idPelicula' de PeliculaActorId a la clave foránea
    @JoinColumn(name = "pelicula_id") // Nombre de la columna de clave foránea
    private Pelicula pelicula; // Suponiendo que tienes una entidad Pelicula

    @ManyToOne // Relación muchos-a-uno con Actor
    @MapsId("idActor") // Mapea la parte 'idActor' de PeliculaActorId a la clave foránea
    @JoinColumn(name = "actor_id") // Nombre de la columna de clave foránea
    private Actor actor;

    @Enumerated(EnumType.STRING) // Persiste el enum como String en la BD
    private UserRole rol; // El rol del actor en la película (ej. PROTAGONISTA, SECUNDARIO)

    // Enum para los roles
    public enum UserRole {
        PROTAGONISTA,
        SECUNDARIO,
        CAMEOS,
        VOZ,
        EXTRA
    }

    // Constructor vacío (necesario para JPA)
    public PeliculaActor() {
    }

    // Constructor con campos
    public PeliculaActor(Pelicula pelicula, Actor actor, UserRole rol) {
        this.pelicula = pelicula;
        this.actor = actor;
        this.rol = rol;
        this.id = new PeliculaActorId(pelicula.getId(), actor.getId());
    }

    // Getters y Setters
    public PeliculaActorId getId() {
        return id;
    }

    public void setId(PeliculaActorId id) {
        this.id = id;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public UserRole getRol() {
        return rol;
    }

    public void setRol(UserRole rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "PeliculaActor{" +
                "id=" + id +
                ", pelicula=" + (pelicula != null ? pelicula.getId() : "null") +
                ", actor=" + (actor != null ? actor.getId() : "null") +
                ", rol=" + rol +
                '}';
    }
}

