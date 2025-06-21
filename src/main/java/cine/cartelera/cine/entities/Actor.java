package cine.cartelera.cine.entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import java.time.LocalDate; // Para manejar fechas

@Entity // Indica que esta clase es una entidad persistente
public class Actor {

    @Id // Marca el campo como clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Configura la generación automática del ID
    private Long id;

    @Column(nullable = false) // Indica que la columna no puede ser nula
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(name = "fecha_nacimiento") // Mapea a un nombre de columna específico
    private LocalDate fechaNacimiento;

    @Column(nullable = false)
    private String nacionalidad;

    // Constructor vacío (necesario para JPA)
    public Actor() {
    }

    // Constructor con campos
    public Actor(String nombre, String apellido, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
    }

    // Getters y Setters (necesarios para acceder y modificar los campos)
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNacionalidad() { return nacionalidad;}

    public void setNacionalidad(String nacionalidad) { this.nacionalidad = nacionalidad; }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Actor{");
        sb.append("id=").append(id);
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", apellido='").append(apellido).append('\'');
        sb.append(", fechaNacimiento=").append(fechaNacimiento);
        sb.append(", nacionalidad='").append(nacionalidad).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
