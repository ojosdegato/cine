package cine.cartelera.cine.services.impl;

import cine.cartelera.cine.entities.Reserva;
import cine.cartelera.cine.repositories.ReservaRepository;
import cine.cartelera.cine.repositories.UsuarioRepository;
import cine.cartelera.cine.services.ReservaService;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservaServiceImpl implements ReservaService {

    private final ReservaRepository reservaRepository;
    private final UsuarioRepository usuarioRepository;

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
        // lógica de guardado
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
        return List.of();
    }

    @Override
    public List<Reserva> findBySalaId(Long salaId) {
        return List.of();
    }

    @Override
    public List<Reserva> findByPeliculaId(Long peliculaId) {
        return List.of();
    }

    @Override
    public List<Reserva> findByEstadoReserva(String estadoReserva) {
        return List.of();
    }

    @Override
    public List<Reserva> findByNumeroAsiento(String numeroAsiento) {
        return List.of();
    }

    @Override
    public List<Reserva> findByFechaProyeccionBetween(String fechaInicio, String fechaFin) {
        return List.of();
    }

    @Override
    public List<Reserva> findByFechaReservaBetween(String fechaInicio, String fechaFin) {
        return List.of();
    }

    @Override
    public List<Reserva> findByPrecioAndTipoEntrada(BigDecimal precio, String tipoEntrada) {
        return List.of();
    }

    @Override
    public Long countEntradasReservadasPorUsuario(Long usuarioId) {
        return 0L;
    }

    @Override
    public Long countEntradasPorMetodoPago(Long usuarioId, String metodoPago) {
        return 0L;
    }

    @Override
    public List<BigDecimal> countEntradasPorTipo(Long usuarioId) {
        return List.of();
    }


}