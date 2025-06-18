package cine.cartelera.cine.entities;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString (exclude = {"proyeccion", "usuario"}) //
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
    private Integer numeroAsiento;

    @Column(nullable = false)
    private Double precioEntrada; // Precio de la entrada, puede ser diferente para "DIA_ESPECTADOR"

    @Column(nullable = false)
    private Integer cantidadEntradas;

    @Column(nullable = false)
    private String estadoReserva; // Puede ser "PENDIENTE", "CONFIRMADA", "CANCELADA"

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private String metodoPago; // Puede ser "TARJETA", "EFECTIVO", etc.

    @Column(nullable = false)
    private String fechaReserva; // Fecha en formato "YYYY-MM-DD HH:MM:SS" o similar para evitar problemas de zona horaria

    @Column(nullable = false)
    private String tipoEntrada; // Puede ser "NORMAL" o "DIA_ESPECTADOR"

    public LocalDateTime getFechaProyeccion() {
        return null;
    }

    public void setPrecioEntrada(BigDecimal bigDecimal) {}
}
