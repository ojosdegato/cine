package cine.cartelera.cine.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "peliculas")
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private String genero;

    private int duracion; // en minutos

    @Column(name = "clasificacion_edad")
    private int clasificacionEdad;

    @Column(length = 1000)
    private String sinopsis;

    private String trailer;

    // Constructores
    public Pelicula() {
    }

    public Pelicula(String titulo, String genero, int duracion, int clasificacionEdad, String sinopsis, String trailer) {
        this.titulo = titulo;
        this.genero = genero;
        this.duracion = duracion;
        this.clasificacionEdad = clasificacionEdad;
        this.sinopsis = sinopsis;
        this.trailer = trailer;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getClasificacionEdad() {
        return clasificacionEdad;
    }

    public void setClasificacionEdad(int clasificacionEdad) {
        this.clasificacionEdad = clasificacionEdad;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", genero='" + genero + '\'' +
                ", duracion=" + duracion +
                ", clasificacionEdad=" + clasificacionEdad +
                ", sinopsis='" + sinopsis + '\'' +
                ", trailer='" + trailer + '\'' +
                '}';
    }
}