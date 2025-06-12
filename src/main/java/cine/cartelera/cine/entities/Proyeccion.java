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
    private LocalDateTime horaSesion;

    @ManyToOne
    @JoinColumn(name="Sala_id")
    private List<Sala> sala = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "Pelicula_id")
    private List<Pelicula> pelicula = new ArrayList<>();
}
