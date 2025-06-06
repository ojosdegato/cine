package cine.cartelera.cine.entities;

        import jakarta.persistence.*; // o javax.persistence.* si usas Jakarta EE 8 o Java EE
        import java.io.Serializable; // Necesario para claves compuestas

// Enum para el rol del actor
public enum UserRole {
    PROTAGONISTA,
    SECUNDARIO,
    CAMEOS,
    VOZ,
    EXTRA // Puedes expandir estos roles según necesites
}

// Representa la tabla de unión Pelicula_Actor
@Entity
@Table(name = "PELICULA_ACTOR") // Nombre de la tabla en H2
@IdClass(PeliculaActorId.class) // Declara la clase que manejará la clave compuesta
public class PeliculaActor implements Serializable {

    // Clave primaria compuesta, referenciando a Pelicula
    @Id
    @Column(name = "ID_PELICULA")
    private Long idPelicula;

    // Clave primaria compuesta, referenciando a Actor
    @Id
    @Column(name = "ID_ACTOR")
    private Long idActor;

    // Campo adicional para el rol del actor en esa película
    @Enumerated(EnumType.STRING) // Almacena el nombre del enum como String en la BD
    @Column(name = "ROL")
    private UserRole rol;

    // Relaciones (Opcional pero muy útil para navegación en el código)
    // Con @ManyToOne, puedes cargar la Pelicula y el Actor completos
    @ManyToOne
    @JoinColumn(name = "ID_PELICULA", insertable = false, updatable = false)
    private Pelicula pelicula; // Objeto Pelicula asociado

    @ManyToOne
    @JoinColumn(name = "ID_ACTOR", insertable = false, updatable = false)
    private Actor actor; // Objeto Actor asociado

    // --- Constructor(es) ---
    public PeliculaActor() {}

    public PeliculaActor(Long idPelicula, Long idActor, UserRole rol) {
        this.idPelicula = idPelicula;
        this.idActor = idActor;
        this.rol = rol;
    }

    // --- Getters y Setters ---
    public Long getIdPelicula() {
        return idPelicula;
    }

    Javier Íñigo Lamadrid, [06/06/2025 18:20]
    public void setIdPelicula(Long idPelicula) {
        this.idPelicula = idPelicula;
    }

    public Long getIdActor() {
        return idActor;
    }

    public void setIdActor(Long idActor) {
        this.idActor = idActor;
    }

    public UserRole getRol() {
        return rol;
    }

    public void setRol(UserRole rol) {
        this.rol = rol;
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

    // --- Implementación de equals() y hashCode() para claves compuestas ---
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PeliculaActor that = (PeliculaActor) o;
        return idPelicula.equals(that.idPelicula) && idActor.equals(that.idActor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPelicula, idActor);
    }
}

