package cine.cartelera.cine.services;

import cine.cartelera.cine.entities.Reserva;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface ReservaService {

    List<Reserva> findAll();
    Optional<Reserva> findById(Long id);
    Reserva save(Reserva reserva);
    void deleteById(Long id);

    // Métodos de consulta personalizados
    List<Reserva> findByUsuarioId(Long usuarioId);
    List<Reserva> findByProyeccionId(Long proyeccionId);
    List<Reserva> findBySalaId(Long salaId);
    List<Reserva> findByPeliculaId(Long peliculaId);
    List<Reserva> findByEstadoReserva(String estadoReserva);
    List<Reserva> findByNumeroAsiento(String numeroAsiento);
    List<Reserva> findByFechaProyeccionBetween(String fechaInicio, String fechaFin);
    List<Reserva> findByFechaReservaBetween(String fechaInicio, String fechaFin);
    List<Reserva> findByPrecioAndTipoEntrada(BigDecimal precio, String tipoEntrada);
    Long countEntradasReservadasPorUsuario(Long usuarioId);
    Long countEntradasPorMetodoPago(Long usuarioId, String metodoPago);
    List<BigDecimal> countEntradasPorTipo(Long usuarioId);
}

