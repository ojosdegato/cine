package cine.cartelera.cine.entities;

import jakarta.persistence.*; // o javax.persistence.* si usas Jakarta EE 8 o Java EE

@Entity // Indica que esta clase es una tabla
@Table(name = "TICKET") // Nombre de la tabla en H2

public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Capacidad total de la sala para esta proyección
    private int aforoDeLaSala;

    // Número de asientos ocupados con este ticket
    private int asientosOcupados;

    // Precio de la entrada
    private double PrecioDeLaEntrada;

    // Relación con la proyección a la que pertenece este ticket
    @ManyToOne
    @JoinColumn(name = "proyeccion_id")
    private Proyeccion proyeccion;

    // Constructor vacío
    public Ticket() {}

    // Constructor con parámetros
    public Ticket(int aforoDeLaSala, int asientosOcupados, double PrecioDeLaEntrada, Proyeccion proyeccion) {
        this.aforoDeLaSala = aforoDeLaSala;
        this.asientosOcupados = asientosOcupados;
        this.PrecioDeLaEntrada = PrecioDeLaEntrada;
        this.proyeccion = proyeccion;
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
        return asientosOcupados;
    }

    public void setAsientosOcupados(int asientosOcupados) {
        this.asientosOcupados = asientosOcupados;
    }

    public double getPrecioDeLaEntrada() {
        return PrecioDeLaEntrada;
    }

    public void setPrecioDeLaEntrada(double precioDeLaEntrada) {
        PrecioDeLaEntrada = precioDeLaEntrada;
    }

    public Proyeccion getProyeccion() {
        return proyeccion;
    }

    public void setProyeccion(Proyeccion proyeccion) {
        this.proyeccion = proyeccion;
    }

    // Método toString
    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", aforoDeLaSala=" + aforoDeLaSala +
                ", asientosOcupados=" + asientosOcupados +
                ", PrecioDeLaEntrada=" + PrecioDeLaEntrada +
                ", proyeccion=" + (proyeccion != null ? proyeccion.getId() : "null") +
                '}';
    }

}

