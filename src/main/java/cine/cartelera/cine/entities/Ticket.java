package cine.cartelera.cine.entities;

import jakarta.persistence.*; // o javax.persistence.* si usas Jakarta EE 8 o Java EE

@Entity // Indica que esta clase es una tabla
@Table(name = "TICKET") // Nombre de la tabla en H2
public class Ticket {

    @Id // Indica que este atributo es la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Generación automática de ID

    // Atributo para la clave primaria
    private Long id;

    // Atributos de la entidad Ticket
    @Column(nullable = false)
    private int aforoDeLaSala;
    private int AsientosOcupados;
    private Double PrecioDeLaEntrada;

    // Constructor vacío
    public Ticket() {
    }

    // Constructor con parámetros
    public Ticket(int aforoDeLaSala, int asientosOcupados, Double precioDeLaEntrada) {
        this.aforoDeLaSala = aforoDeLaSala;
        AsientosOcupados = asientosOcupados;
        PrecioDeLaEntrada = precioDeLaEntrada;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAforoDeLaSala() {
        return aforoDeLaSala;
    }

    public void setAforoDeLaSala(int aforoDeLaSala) {
        this.aforoDeLaSala = aforoDeLaSala;
    }

    public int getAsientosOcupados() {
        return AsientosOcupados;
    }

    public void setAsientosOcupados(int asientosOcupados) {
        AsientosOcupados = asientosOcupados;
    }

    public Double getPrecioDeLaEntrada() {
        return PrecioDeLaEntrada;
    }

    public void setPrecioDeLaEntrada(Double precioDeLaEntrada) {
        PrecioDeLaEntrada = precioDeLaEntrada;
    }

    // Método toString
    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", aforoDeLaSala=" + aforoDeLaSala +
                ", AsientosOcupados=" + AsientosOcupados +
                ", PrecioDeLaEntrada=" + PrecioDeLaEntrada +
                '}';
    }
}

