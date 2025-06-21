package cine.cartelera.cine.entities;


import cine.cartelera.cine.enums.Estado_Reserva;
import cine.cartelera.cine.enums.Metodo_Pago;
import cine.cartelera.cine.enums.Precio_Entrada;
import cine.cartelera.cine.enums.Tipo_Entrada;
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
    private String numeroAsiento;

    @Column(nullable = false)
    private Precio_Entrada precioEntrada; // Precio de la entrada, puede ser diferente para "DIA_ESPECTADOR"

    @Column(nullable = false)
    private Estado_Reserva estadoReserva; // Puede ser "PENDIENTE", "CONFIRMADA", "CANCELADA"

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Metodo_Pago metodoPago; // Puede ser "TARJETA", "EFECTIVO", etc.

    @Column(nullable = false)
    private String fechaReserva; // Fecha en formato "YYYY-MM-DD HH:MM:SS" o similar para evitar problemas de zona horaria

    @Column(nullable = false)
    private Tipo_Entrada tipoEntrada; // Puede ser "NORMAL" o "DIA_ESPECTADOR"

    public LocalDateTime getFechaProyeccion() {
        return null;
    }

    public void setPrecioEntrada(BigDecimal bigDecimal) {}
}
