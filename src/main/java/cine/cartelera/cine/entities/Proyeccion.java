package cine.cartelera.cine.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="Proyeccion")
public class Proyeccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime horaSesion;

    @OneToMany
    @JoinColumn(name="Proyeccion_id")
    private List<Sala> salas = new ArrayList<>();

    public Proyeccion(){}

    public Proyeccion(Long id, LocalDateTime horaSesion, List<Sala> salas) {
        this.id = id;
        this.horaSesion = horaSesion;
        this.salas = salas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getHoraSesion() {
        return horaSesion;
    }

    public void setHoraSesion(LocalDateTime horaSesion) {
        this.horaSesion = horaSesion;
    }

    public List<Sala> getSalas() {
        return salas;
    }

    public void setSalas(List<Sala> salas) {
        this.salas = salas;
    }

    @Override
    public String toString() {
        return "Proyeccion{" +
                "id=" + id +
                ", horaSesion=" + horaSesion +
                ", salas=" + salas +
                '}';
    }
}
