package cine.cartelera.cine.services;


import cine.cartelera.cine.entities.Reserva;
import cine.cartelera.cine.repositories.ReservaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;

    public List<Reserva> listarTodas() {
        return reservaRepository.findAll();
    }

    public Reserva buscarPorId(Long id) {
        return reservaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reserva no encontrada"));
    }

    public Reserva save(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    public void deleteById(Long id) {
        reservaRepository.deleteById(id);
    }

    // Método para buscar reservas por usuario
    public List<Reserva> findByUsuarioId(Long usuarioId) {
        return reservaRepository.findByUsuarioId(usuarioId);
    }

    // Método para buscar reservas por proyeccion
    public List<Reserva> findByProyeccionId(Long proyeccionId) {
        return reservaRepository.findByProyeccion_Id(proyeccionId);
    }

    // Método para buscar reservas por sala
    public List<Reserva> findBySalaId(Long salaId) {
        return reservaRepository.findByProyeccion_Sala_Id(salaId);
    }

    // Método para buscar reservas por película
    public List<Reserva> findByPeliculaId(Long peliculaId) {
        return reservaRepository.findByProyeccion_Pelicula_Id(peliculaId);
    }

    // Método para buscar reservas por estado
    public List<Reserva> findByEstadoReserva(String estadoReserva) {
        return reservaRepository.findByEstadoReserva(estadoReserva);
    }

    // Método para buscar reservas por número de asiento
    public List<Reserva> findByNumeroAsiento(String numeroAsiento) {
        return reservaRepository.findByNumeroAsiento(numeroAsiento);
    }

    // Método para buscar reservas por fecha de proyección
    public List<Reserva> findByFechaProyeccionBetween(String fechaInicio, String fechaFin) {
        return reservaRepository.findByFechaProyeccionBetween(fechaInicio, fechaFin);
    }

    // Método para buscar reservas por fecha de reserva
    public List<Reserva> findByFechaReservaBetween(String fechaInicio, String fechaFin) {
        return reservaRepository.findByFechaReservaBetween(fechaInicio, fechaFin);
    }

    // Método para buscar reservas por precio y tipo de entrada
    public List<Reserva> findByPrecioAndTipoEntrada(BigDecimal precio, String tipoEntrada) {
        return reservaRepository.findByPrecioAndTipoEntrada(precio, tipoEntrada);
    }

    // Método para contar entradas reservadas por usuario
    public Long countEntradasReservadasPorUsuario(Long usuarioId) {
        return reservaRepository.countEntradasReservadasPorUsuario(usuarioId);
    }

    // Método para contar entradas por método de pago (efectivo o tarjeta)
    public Long countEntradasPorMetodoPago(Long usuarioId, String metodoPago) {
        return reservaRepository.countEntradasPorMetodoPago(usuarioId, metodoPago);
    }

    // Método para contar entradas por tipo (normal o día del espectador)
    public List<BigDecimal> countEntradasPorTipo(Long usuarioId) {
        return reservaRepository.countEntradasPorTipo(usuarioId);
    }




}

