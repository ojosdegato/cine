package cine.cartelera.cine.services;

import cine.cartelera.cine.entities.Reserva;
import cine.cartelera.cine.enums.PrecioEntrada;
import cine.cartelera.cine.repositories.ReservaRepository;
import cine.cartelera.cine.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
@Validated
public class ReservaService {
    // Constante que define el día del espectador
    private static final DayOfWeek DIA_ESPECTADOR = DayOfWeek.WEDNESDAY;

    private final ReservaRepository reservaRepository;
    private final UsuarioRepository usuarioRepository;

    // Calcular el precio de la entrada según el día
    private double calcularPrecioEntrada(LocalDateTime fechaReserva) {

        return fechaReserva.getDayOfWeek() == DIA_ESPECTADOR
                ? PrecioEntrada.DIA_ESPECTADOR.getPrecio()
                : PrecioEntrada.NORMAL.getPrecio();
    }

    // Listar todas las reservas
    public List<Reserva> findAll() {

        return reservaRepository.findAll();
    }

    // Buscar una reserva por su ID
    public Reserva findById(@NotNull(message = "El ID de la reserva no puede ser nulo") Long id) {

        return reservaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));
    }

    // Guardar una reserva
    public Reserva save(@Valid Reserva reserva) {
        double precio = calcularPrecioEntrada(reserva.getFechaProyeccion());
        reserva.setPrecioEntrada(BigDecimal.valueOf(precio));

        return reservaRepository.save(reserva);
    }

    // Eliminar una reserva por su ID
    public void deleteById(@NotNull(message = "El ID de la reserva no puede ser nulo") Long id) {

        reservaRepository.deleteById(id);
    }

    // Encontrar reservas por ID de usuario
    public List<Reserva> findByUsuarioId(@NotNull(message = "El ID de usuario no puede ser nulo") Long usuarioId) {

        return reservaRepository.findByUsuarioId(usuarioId);
    }

    // Encontrar reservas por ID de proyección
    public List<Reserva> findByProyeccionId(@NotNull(message = "El ID de proyección no puede ser nulo") Long proyeccionId) {

        return reservaRepository.findByProyeccion_Id(proyeccionId);
    }

    // Encontrar reservas por ID de sala
    public List<Reserva> findBySalaId(@NotNull(message = "El ID de sala no puede ser nulo") Long salaId) {

        return reservaRepository.findByProyeccion_Sala_Id(salaId);
    }

    // Encontrar reservas por ID de película
    public List<Reserva> findByPeliculaId(@NotNull(message = "El ID de película no puede ser nulo") Long peliculaId) {

        return reservaRepository.findByProyeccion_Pelicula_Id(peliculaId);
    }

    // Encontrar reservas por estado
    public List<Reserva> findByEstadoReserva(@NotBlank(message = "El estado de reserva no puede estar vacío") String estadoReserva) {

        return reservaRepository.findByEstadoReserva(estadoReserva);
    }

    // Encontrar reservas por número de asiento
    public List<Reserva> findByNumeroAsiento(@NotBlank(message = "El número de asiento no puede estar vacío") String numeroAsiento) {

        return reservaRepository.findByNumeroAsiento(Integer.valueOf(numeroAsiento));
    }

    // Encontrar reservas entre fechas de proyección
    public List<Reserva> findByFechaProyeccionBetween(
            @NotBlank(message = "La fecha de inicio no puede estar vacía") String fechaInicio,
            @NotBlank(message = "La fecha de fin no puede estar vacía") String fechaFin) {

        return reservaRepository.findByFechaProyeccionBetween(fechaInicio, fechaFin);
    }

    // Encontrar reservas entre fechas de reserva
    public List<Reserva> findByFechaReservaBetween(
            @NotBlank(message = "La fecha de inicio no puede estar vacía") String fechaInicio,
            @NotBlank(message = "La fecha de fin no puede estar vacía") String fechaFin) {

        return reservaRepository.findByFechaReservaBetween(fechaInicio, fechaFin);
    }

    // Encontrar reservas por precio y tipo de entrada
    public List<Reserva> findByPrecioAndTipoEntrada(
            @NotNull(message = "El precio no puede ser nulo") BigDecimal precio,
            @NotBlank(message = "El tipo de entrada no puede estar vacío") String tipoEntrada) {

        return reservaRepository.findByPrecioAndTipoEntrada(precio, tipoEntrada);
    }

    // Contar entradas reservadas por usuario
    public Long countEntradasReservadasPorUsuario(@NotNull(message = "El ID de usuario no puede ser nulo") Long usuarioId) {

        return reservaRepository.countEntradasReservadasPorUsuario(usuarioId);
    }

    // Contar entradas por método de pago
    public Long countEntradasPorMetodoPago(
            @NotNull(message = "El ID de usuario no puede ser nulo") Long usuarioId,
            @NotBlank(message = "El método de pago no puede estar vacío") String metodoPago) {

        return reservaRepository.countEntradasPorMetodoPago(usuarioId, metodoPago);
    }

    // Contar entradas por tipo
    public List<BigDecimal> countEntradasPorTipo(@NotNull(message = "El ID de usuario no puede ser nulo") Long usuarioId) {

        return reservaRepository.countEntradasPorTipo(usuarioId);
    }
}

