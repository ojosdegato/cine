package cine.cartelera.cine.entities;

import cine.cartelera.cine.enums.Estado_Reserva;
import cine.cartelera.cine.enums.Metodo_Pago;
import cine.cartelera.cine.enums.Tipo_Entrada;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString (exclude = {"proyeccion", "usuario"})
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="reservas")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "Proyeccion_id", nullable = false)
    private Proyeccion proyeccion;

    @ManyToOne
    @JoinColumn(name = "Usuario_id", nullable = false)
    private Usuario usuario;

    @Column(nullable = false, unique = true)
    private String numeroAsiento;

    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal precioEntrada;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Estado_Reserva estadoReserva;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Metodo_Pago metodoPago;

    @Column(nullable = false)
    private String fechaReserva;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Tipo_Entrada tipoEntrada;

    public LocalDateTime getFechaProyeccion() { return null; }

    public void setPrecioEntrada(BigDecimal precioEntrada) {
        this.precioEntrada = precioEntrada;
    }
}