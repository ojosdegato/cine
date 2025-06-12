package cine.cartelera.cine.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@ToString(exclude = {"sala","pelicula"})
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="Proyeccion")
public class Proyeccion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime fechaHora;

    @ManyToOne
    @JoinColumn(name = "Sala_id")
    private Sala sala;

    @ManyToOne
    @JoinColumn(name = "Pelicula_id")
    private Pelicula pelicula;

    public LocalDateTime getFechaHora() {
        return null;
    }
}