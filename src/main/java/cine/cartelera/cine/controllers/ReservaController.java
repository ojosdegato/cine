package cine.cartelera.cine.controllers;

import cine.cartelera.cine.entities.Reserva;
import cine.cartelera.cine.repositories.ReservaRepository;
import cine.cartelera.cine.services.ReservaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    private final ReservaService reservaService;
    private final ReservaRepository reservaRepository;

    public ReservaController(ReservaService reservaService,
                             ReservaRepository reservaRepository) {
        this.reservaService = reservaService;
        this.reservaRepository = reservaRepository;
    }

    // Devuelve los precios de los distintos tipos de entrada en formato JSON
    @GetMapping("/precios")
    public ResponseEntity<Map<String, BigDecimal>> obtenerPrecios() {
        Map<String, BigDecimal> precios = new HashMap<>();
        precios.put("NORMAL", new BigDecimal("7.50"));
        precios.put("DIA_ESPECTADOR", new BigDecimal("3.00"));
        return ResponseEntity.ok(precios);
    }

    // Devuelve la lista de todas las reservas
    @GetMapping
    public List<Reserva> listarReservas() {
        return reservaService.findAll();
    }

    // Devuelve una reserva por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Reserva> obtenerReserva(@PathVariable Long id) {
        return reservaService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Crea una nueva reserva
    @PostMapping
    public Reserva crearReserva(@RequestBody Reserva reserva) {
        return reservaService.save(reserva);
    }

    // Actualiza una reserva existente
    @PutMapping("/{id}")
    public ResponseEntity<Reserva> actualizarReserva(@PathVariable Long id, @RequestBody Reserva datosActualizados) {
        return reservaService.findById(id)
                .map(reservaExistente -> {
                    reservaExistente.setProyeccion(datosActualizados.getProyeccion());
                    reservaExistente.setUsuario(datosActualizados.getUsuario());
                    reservaExistente.setNumeroAsiento(datosActualizados.getNumeroAsiento());
                    reservaExistente.setPrecioEntrada(datosActualizados.getPrecioEntrada());
                    reservaExistente.setEstadoReserva(datosActualizados.getEstadoReserva());
                    reservaExistente.setMetodoPago(datosActualizados.getMetodoPago());
                    reservaExistente.setFechaReserva(datosActualizados.getFechaReserva());
                    reservaExistente.setTipoEntrada(datosActualizados.getTipoEntrada());
                    Reserva actualizado = reservaService.save(reservaExistente);
                    return ResponseEntity.ok(actualizado);
                }).orElse(ResponseEntity.notFound().build());
    }

    // Elimina una reserva por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarReserva(@PathVariable Long id) {
        if (reservaRepository.existsById(id)) {
            reservaRepository.deleteById(id);
            return ResponseEntity.noContent().build(); // Devuelve 204 No Content si se elimina correctamente
        } else {
            return ResponseEntity.notFound().build(); // Devuelve 404 Not Found si la reserva no existe
        }
    }

    // Contar entradas reservadas por usuario
    @GetMapping("/countEntradasReservadasPorUsuario/{usuarioId}")
    public ResponseEntity<Long> countEntradasReservadasPorUsuario(@PathVariable Long usuarioId) {
        Long count = reservaService.countEntradasReservadasPorUsuario(usuarioId);
        return ResponseEntity.ok(count);
    }

    // Contar entradas por método de pago
    @GetMapping("/countEntradasPorMetodoPago/{usuarioId}/{metodoPago}")
    public ResponseEntity<Long> countEntradasPorMetodoPago(@PathVariable Long usuarioId, @PathVariable String metodoPago) {
        Long count = reservaService.countEntradasPorMetodoPago(usuarioId, metodoPago);
        return ResponseEntity.ok(count);
    }

    // Contar entradas por tipo
    @GetMapping("/countEntradasPorTipo/{usuarioId}")
    public ResponseEntity<List<BigDecimal>> countEntradasPorTipo(@PathVariable Long usuarioId) {
        List<BigDecimal> counts = reservaService.countEntradasPorTipo(usuarioId);
        return ResponseEntity.ok(counts);
    }
}


