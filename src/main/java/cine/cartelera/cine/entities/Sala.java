package cine.cartelera.cine.entities;
import jakarta.persistence.*;
import lombok.*;




@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="Sala")
public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private int aforoMaximo;
    private int asientosDisponibles;
    private String tipoSala;
}
