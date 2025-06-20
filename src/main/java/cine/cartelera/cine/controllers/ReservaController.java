package cine.cartelera.cine.controllers;

import cine.cartelera.cine.entities.Reserva;
import cine.cartelera.cine.enums.Precio_Entrada;
import cine.cartelera.cine.services.ReservaService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/reservas")
public class ReservaController {

    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    // Endpoint para obtener los precios de las entradas
    @GetMapping("/precios")
    @ResponseBody
    public ResponseEntity<Map<String, Double>> obtenerPrecios() {
        Map<String, Double> precios = new HashMap<>();
        for (Precio_Entrada precio : Precio_Entrada.values()) {
            precios.put(precio.name(), precio.getPrecio());
        }

        return ResponseEntity.ok(precios);
    }

    // Mostrar todas las reservas
    @GetMapping
    public String listarReservas(Model model) {
        List<Reserva> reservas = reservaService.findAll();
        model.addAttribute("reservas", reservas);

        return "reservas/listar";
    }

    // Formulario para una nueva reserva
    @GetMapping("/nueva")
    public String mostrarFormulario(Model model) {
        model.addAttribute("reserva", new Reserva());
        model.addAttribute("precioNormal", Precio_Entrada.NORMAL.getPrecio());
        model.addAttribute("precioDiaEspectador", Precio_Entrada.DIA_ESPECTADOR.getPrecio());
        model.addAttribute("tiposEntrada", List.of("NORMAL", "DIA_ESPECTADOR"));
        model.addAttribute("diaEspectador", "MIÉRCOLES");
        model.addAttribute("metodosPago", List.of("TARJETA", "EFECTIVO"));
        model.addAttribute("estadosReserva", List.of("PENDIENTE", "CONFIRMADA", "CANCELADA"));

        return "reservas/formulario";
    }

    // Guardar reserva nueva o editada
    @PostMapping("/guardar")
    public String guardarReserva(@Valid @ModelAttribute Reserva reserva, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("precioNormal", Precio_Entrada.NORMAL.getPrecio());
            model.addAttribute("precioDiaEspectador", Precio_Entrada.DIA_ESPECTADOR.getPrecio());
            model.addAttribute("tiposEntrada", List.of("NORMAL", "DIA_ESPECTADOR"));
            model.addAttribute("diaEspectador", "MIÉRCOLES");
            model.addAttribute("metodosPago", List.of("TARJETA", "EFECTIVO"));
            model.addAttribute("estadosReserva", List.of("PENDIENTE", "CONFIRMADA", "CANCELADA"));

            return "reservas/formulario";
        }

        try {
            Reserva reservaGuardada = reservaService.save(reserva);
            return "redirect:/reservas";
        } catch (IllegalArgumentException e) {
            model.addAttribute("error", "Error al guardar la reserva: " + e.getMessage());
            model.addAttribute("precioNormal", Precio_Entrada.NORMAL.getPrecio());
            model.addAttribute("precioDiaEspectador", Precio_Entrada.DIA_ESPECTADOR.getPrecio());
            model.addAttribute("diaEspectador", "MIÉRCOLES");
            model.addAttribute("tiposEntrada", List.of("NORMAL", "DIA_ESPECTADOR"));
            model.addAttribute("metodosPago", List.of("TARJETA", "EFECTIVO"));
            model.addAttribute("estadosReserva", List.of("PENDIENTE", "CONFIRMADA", "CANCELADA"));

            return "reservas/formulario";
        }

    }

    // Formulario para editar una reserva
    @GetMapping("/editar/{id}")
    public String editarReserva(@PathVariable Long id, Model model) {
        Optional<Reserva> reserva = reservaService.findById(id);
        model.addAttribute("reserva", reserva);
        model.addAttribute("precioNormal", Precio_Entrada.NORMAL.getPrecio());
        model.addAttribute("precioDiaEspectador", Precio_Entrada.DIA_ESPECTADOR.getPrecio());
        model.addAttribute("diaEspectador", "MIÉRCOLES");
        model.addAttribute("tiposEntrada", List.of("NORMAL", "DIA_ESPECTADOR"));
        model.addAttribute("metodosPago", List.of("TARJETA", "EFECTIVO"));
        model.addAttribute("estadosReserva", List.of("PENDIENTE", "CONFIRMADA", "CANCELADA"));

        return "reservas/formulario";
    }

    // Eliminar una reserva
    @GetMapping("/eliminar/{id}")
    public String eliminarReserva(@PathVariable Long id) {
        reservaService.deleteById(id);

        return "redirect:/reservas";
    }

    // Buscar reservas por usuario
    @GetMapping("/usuario/{usuarioId}")
    public String buscarPorUsuario(@PathVariable Long usuarioId, Model model) {
        List<Reserva> reservas = reservaService.findByUsuarioId(usuarioId);
        model.addAttribute("reservas", reservas);

        return "reservas/listar";
    }

    // Buscar reservas por proyección
    @GetMapping("/proyeccion/{proyeccionId}")
    public String buscarPorProyeccion(@PathVariable Long proyeccionId, Model model) {
        List<Reserva> reservas = reservaService.findByProyeccionId(proyeccionId);
        model.addAttribute("reservas", reservas);

        return "reservas/listar";
    }

    // Buscar reservas por sala
    @GetMapping("/sala/{salaId}")
    public String buscarPorSala(@PathVariable Long salaId, Model model) {
        List<Reserva> reservas = reservaService.findBySalaId(salaId);
        model.addAttribute("reservas", reservas);

        return "reservas/listar";
    }

    // Buscar reservas por película
    @GetMapping("/pelicula/{peliculaId}")
    public String buscarPorPelicula(@PathVariable Long peliculaId, Model model) {
        List<Reserva> reservas = reservaService.findByPeliculaId(peliculaId);
        model.addAttribute("reservas", reservas);

        return "reservas/listar";
    }

    // Buscar reservas por estado
    @GetMapping("/estado/{estadoReserva}")
    public String buscarPorEstado(@PathVariable String estadoReserva, Model model) {
        List<Reserva> reservas = reservaService.findByEstadoReserva(estadoReserva);
        model.addAttribute("reservas", reservas);

        return "reservas/listar";
    }

    // Buscar reservas por número de asiento
    @GetMapping("/asiento/{numeroAsiento}")
    public String buscarPorNumeroAsiento(@PathVariable String numeroAsiento, Model model) {
        List<Reserva> reservas = reservaService.findByNumeroAsiento(numeroAsiento);
        model.addAttribute("reservas", reservas);

        return "reservas/listar";
    }

    // Buscar reservas por fecha de proyección
    @GetMapping("/fechaProyeccion")
    public String buscarPorFechaProyeccion(@RequestParam String fechaInicio, @RequestParam String fechaFin, Model model) {
        List<Reserva> reservas = reservaService.findByFechaProyeccionBetween(fechaInicio, fechaFin);
        model.addAttribute("reservas", reservas);

        return "reservas/listar";
    }

    // Buscar reservas por fecha de reserva
    @GetMapping("/fechaReserva")
    public String buscarPorFechaReserva(@RequestParam String fechaInicio, @RequestParam String fechaFin, Model model) {
        List<Reserva> reservas = reservaService.findByFechaReservaBetween(fechaInicio, fechaFin);
        model.addAttribute("reservas", reservas);

        return "reservas/listar";
    }

    // Buscar reservas por precio y tipo de entrada
    @GetMapping("/precioTipoEntrada")
    public String buscarPorPrecioYTipoEntrada(@RequestParam BigDecimal precio, @RequestParam String tipoEntrada, Model model) {
        List<Reserva> reservas = reservaService.findByPrecioAndTipoEntrada(precio, tipoEntrada);
        model.addAttribute("reservas", reservas);

        return "reservas/listar";
    }

    // Contar entradas reservadas por usuario
    @GetMapping("/countEntradasReservadasPorUsuario/{usuarioId}")
    public ResponseEntity<Long> countEntradasReservadasPorUsuario(@PathVariable Long usuarioId) {
        Long count = reservaService.countEntradasReservadasPorUsuario(usuarioId);

        return ResponseEntity.ok(count);
    }

    // Contar entradas por método de pago (efectivo o tarjeta)
    @GetMapping("/countEntradasPorMetodoPago/{usuarioId}/{metodoPago}")
    public ResponseEntity<Long> countEntradasPorMetodoPago(@PathVariable Long usuarioId, @PathVariable String metodoPago) {
        Long count = reservaService.countEntradasPorMetodoPago(usuarioId, metodoPago);

        return ResponseEntity.ok(count);
    }

    // Contar entradas por tipo (normal y día del espectador)
    @GetMapping("/countEntradasPorTipo/{usuarioId}")
    public ResponseEntity<List<BigDecimal>> countEntradasPorTipo(@PathVariable Long usuarioId) {
        List<BigDecimal> counts = reservaService.countEntradasPorTipo(usuarioId);

        return ResponseEntity.ok(counts);
    }

}



