package cine.cartelera.cine.services.impl;

import cine.cartelera.cine.entities.Reserva;
import cine.cartelera.cine.enums.Estado_Reserva;
import cine.cartelera.cine.enums.Tipo_Entrada;
import cine.cartelera.cine.repositories.ReservaRepository;
import cine.cartelera.cine.repositories.UsuarioRepository;
import cine.cartelera.cine.services.ReservaService;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservaServiceImpl implements ReservaService {

    private final ReservaRepository reservaRepository;
    private final UsuarioRepository usuarioRepository; // Aunque no se usa directamente en ReservaService, está inyectado.

    @Override
    public List<Reserva> findAll() {
        return reservaRepository.findAll();
    }

    @Override
    public Optional<Reserva> findById(Long id) {
        return reservaRepository.findById(id);
    }

    @Override
    public Reserva save(Reserva reserva) {
        return reservaRepository.save(reserva);
    }

    @Override
    public void deleteById(Long id) {
        reservaRepository.deleteById(id);
    }

    @Override
    public List<Reserva> findByUsuarioId(Long usuarioId) {
        return reservaRepository.findByUsuarioId(usuarioId);
    }

    @Override
    public List<Reserva> findByProyeccionId(Long proyeccionId) {
        return reservaRepository.findByProyeccion_Id(proyeccionId);
    }

    @Override
    public List<Reserva> findBySalaId(Long salaId) {
        return reservaRepository.findByProyeccion_Sala_Id(salaId);
    }

    @Override
    public List<Reserva> findByPeliculaId(Long peliculaId) {
        return reservaRepository.findByProyeccion_Pelicula_Id(peliculaId);
    }

    @Override
    public List<Reserva> findByEstadoReserva(String estadoReserva) {
        Estado_Reserva estado = Estado_Reserva.valueOf(estadoReserva.toUpperCase()); // Asegurar mayúsculas
        return reservaRepository.findByEstadoReserva(estado);
    }

    @Override
    public List<Reserva> findByNumeroAsiento(String numeroAsiento) {
        return reservaRepository.findByNumeroAsiento(numeroAsiento);
    }

    @Override
    public List<Reserva> findByFechaProyeccionBetween(String fechaInicio, String fechaFin) {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME; // O el formato que estés usando (ej. "yyyy-MM-dd'T'HH:mm:ss")
        LocalDateTime inicio = LocalDateTime.parse(fechaInicio, formatter);
        LocalDateTime fin = LocalDateTime.parse(fechaFin, formatter);
        return reservaRepository.findByFechaProyeccionBetween(inicio, fin);
    }

    @Override
    public List<Reserva> findByFechaReservaBetween(String fechaInicio, String fechaFin) {
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME; // O el formato que estés usando
        LocalDateTime inicio = LocalDateTime.parse(fechaInicio, formatter);
        LocalDateTime fin = LocalDateTime.parse(fechaFin, formatter);
        return reservaRepository.findByFechaReservaBetween(inicio, fin);
    }

    @Override
    public List<Reserva> findByPrecioAndTipoEntrada(String precioEntrada, String tipoEntrada) {
        Tipo_Entrada tipo = Tipo_Entrada.valueOf(tipoEntrada.toUpperCase()); // Asegurar mayúsculas
        BigDecimal precio = new BigDecimal(precioEntrada);
        return reservaRepository.findByPrecioEntradaAndTipoEntrada(precio, tipo);
    }

    @Override
    public Long countEntradasReservadasPorUsuario(Long usuarioId) {
        return reservaRepository.countEntradasReservadasPorUsuario(usuarioId);
    }

    @Override
    public Long countEntradasPorMetodoPago(Long usuarioId, String metodoPago) {
        return reservaRepository.countEntradasPorMetodoPago(usuarioId, metodoPago);
    }

    @Override
    public Long countEntradasPorTipo(Long usuarioId, Tipo_Entrada tipoEntrada) {
        return reservaRepository.countEntradasPorTipo(usuarioId, tipoEntrada);
    }
}