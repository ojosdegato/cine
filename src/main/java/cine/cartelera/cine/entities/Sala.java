package cine.cartelera.cine.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private int aforoMaximo;
    private int asientosDisponibles;
    private String tipoSala;

    public Sala() {}

        public Sala(Long id, String nombre, int aforoMaximo, int asientosDisponibles, String tipoSala) {
        this.id = id;
        this.nombre = nombre;
        this.aforoMaximo = aforoMaximo;
        this.asientosDisponibles = asientosDisponibles;
        this.tipoSala = tipoSala;
    }

    // Getters y Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAforoMaximo() {
        return aforoMaximo;
    }

    public void setAforoMaximo(int aforoMaximo) {
        this.aforoMaximo = aforoMaximo;
    }

    public int getAsientosDisponibles() {
        return asientosDisponibles;
    }

    public void setAsientosDisponibles(int asientosDisponibles) {
        this.asientosDisponibles = asientosDisponibles;
    }

    public String getTipoSala() {
        return tipoSala;
    }

    public void setTipoSala(String tipoSala) {
        this.tipoSala = tipoSala;
    }

    @Override
    public String toString() {
        return "Sala{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", aforoMaximo=" + aforoMaximo +
                ", asientosDisponibles=" + asientosDisponibles +
                ", tipoSala='" + tipoSala + '\'' +
                '}';
    }
}
