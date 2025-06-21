package cine.cartelera.cine.controllers;

import cine.cartelera.cine.entities.Reserva;
import cine.cartelera.cine.enums.Precio_Entrada;
import cine.cartelera.cine.services.ReservaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/reservas")
public class ReservaMvcController {

    private final ReservaService reservaService;

    // Constructor que inyecta el servicio de reservas
    public ReservaMvcController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    // Muestra la lista de todas las reservas en la vista 'reservas/listar'
    @GetMapping
    public String listarReservas(Model model) {
        model.addAttribute("reservas", reservaService.findAll());
        return "reservas/reserva-lista";
    }

    // Muestra el formulario para crear una nueva reserva
    @GetMapping("/nueva")
    public String mostrarFormulario(Model model) {
        model.addAttribute("reserva", new Reserva());
        model.addAttribute("precioNormal", Precio_Entrada.NORMAL.getPrecio());
        model.addAttribute("precioDiaEspectador", Precio_Entrada.DIA_ESPECTADOR.getPrecio());
        model.addAttribute("tiposEntrada", List.of("NORMAL", "DIA_ESPECTADOR"));
        model.addAttribute("diaEspectador", "MIÉRCOLES");
        model.addAttribute("metodosPago", List.of("TARJETA", "EFECTIVO"));
        model.addAttribute("estadosReserva", List.of("PENDIENTE", "CONFIRMADA", "CANCELADA"));
        return "reservas/reserva-formulario";
    }

    // Guarda una reserva nueva o editada, validando los datos del formulario
    @PostMapping("/guardar")
    public String guardarReserva(@Valid @ModelAttribute Reserva reserva, BindingResult result, Model model) {
        if (result.hasErrors()) {
            // Si hay errores de validación, vuelve al formulario con los datos necesarios
            model.addAttribute("precioNormal", Precio_Entrada.NORMAL.getPrecio());
            model.addAttribute("precioDiaEspectador", Precio_Entrada.DIA_ESPECTADOR.getPrecio());
            model.addAttribute("tiposEntrada", List.of("NORMAL", "DIA_ESPECTADOR"));
            model.addAttribute("diaEspectador", "MIÉRCOLES");
            model.addAttribute("metodosPago", List.of("TARJETA", "EFECTIVO"));
            model.addAttribute("estadosReserva", List.of("PENDIENTE", "CONFIRMADA", "CANCELADA"));
            return "reservas/reserva-formulario";
        }
        try {
            reservaService.save(reserva);
            return "redirect:/reservas";
        } catch (IllegalArgumentException e) {
            // Si ocurre un error al guardar, muestra el mensaje de error en el formulario
            model.addAttribute("error", "Error al guardar la reserva: " + e.getMessage());
            model.addAttribute("precioNormal", Precio_Entrada.NORMAL.getPrecio());
            model.addAttribute("precioDiaEspectador", Precio_Entrada.DIA_ESPECTADOR.getPrecio());
            model.addAttribute("diaEspectador", "MIÉRCOLES");
            model.addAttribute("tiposEntrada", List.of("NORMAL", "DIA_ESPECTADOR"));
            model.addAttribute("metodosPago", List.of("TARJETA", "EFECTIVO"));
            model.addAttribute("estadosReserva", List.of("PENDIENTE", "CONFIRMADA", "CANCELADA"));
            return "reservas/reserva-formulario";
        }
    }

    // Muestra el formulario para editar una reserva existente
    @GetMapping("/editar/{id}")
    public String editarReserva(@PathVariable Long id, Model model) {
        Optional<Reserva> reserva = reservaService.findById(id);
        model.addAttribute("reserva", reserva.orElse(new Reserva()));
        model.addAttribute("precioNormal", Precio_Entrada.NORMAL.getPrecio());
        model.addAttribute("precioDiaEspectador", Precio_Entrada.DIA_ESPECTADOR.getPrecio());
        model.addAttribute("diaEspectador", "MIÉRCOLES");
        model.addAttribute("tiposEntrada", List.of("NORMAL", "DIA_ESPECTADOR"));
        model.addAttribute("metodosPago", List.of("TARJETA", "EFECTIVO"));
        model.addAttribute("estadosReserva", List.of("PENDIENTE", "CONFIRMADA", "CANCELADA"));
        return "reservas/reserva-formulario";
    }

    // Elimina una reserva por su ID y redirige a la lista de reservas
    @GetMapping("/eliminar/{id}")
    public String eliminarReserva(@PathVariable Long id) {
        reservaService.deleteById(id);
        return "redirect:/reservas";
    }

    // Busca reservas por el ID del usuario y las muestra en la vista de lista
    @GetMapping("/usuario/{usuarioId}")
    public String buscarPorUsuario(@PathVariable Long usuarioId, Model model) {
        model.addAttribute("reservas", reservaService.findByUsuarioId(usuarioId));
        return "reservas/reserva-lista";
    }

    // Busca reservas por el ID de la proyección
    @GetMapping("/proyeccion/{proyeccionId}")
    public String buscarPorProyeccion(@PathVariable Long proyeccionId, Model model) {
        model.addAttribute("reservas", reservaService.findByProyeccionId(proyeccionId));
        return "reservas/reserva-lista";
    }

    // Busca reservas por el ID de la sala
    @GetMapping("/sala/{salaId}")
    public String buscarPorSala(@PathVariable Long salaId, Model model) {
        model.addAttribute("reservas", reservaService.findBySalaId(salaId));
        return "reservas/reserva-lista";
    }

    // Busca reservas por el ID de la película
    @GetMapping("/pelicula/{peliculaId}")
    public String buscarPorPelicula(@PathVariable Long peliculaId, Model model) {
        model.addAttribute("reservas", reservaService.findByPeliculaId(peliculaId));
        return "reservas/reserva-lista";
    }

    // Busca reservas por el estado de la reserva
    @GetMapping("/estado/{estadoReserva}")
    public String buscarPorEstado(@PathVariable String estadoReserva, Model model) {
        model.addAttribute("reservas", reservaService.findByEstadoReserva(estadoReserva));
        return "reservas/reserva-lista";
    }

    // Busca reservas por el número de asiento
    @GetMapping("/asiento/{numeroAsiento}")
    public String buscarPorNumeroAsiento(@PathVariable String numeroAsiento, Model model) {
        model.addAttribute("reservas", reservaService.findByNumeroAsiento(numeroAsiento));
        return "reservas/reserva-lista";
    }

    // Busca reservas por un rango de fechas de proyección
    @GetMapping("/fechaProyeccion")
    public String buscarPorFechaProyeccion(@RequestParam String fechaInicio, @RequestParam String fechaFin, Model model) {
        model.addAttribute("reservas", reservaService.findByFechaProyeccionBetween(fechaInicio, fechaFin));
        return "reservas/reserva-lista";
    }

    // Busca reservas por un rango de fechas de reserva
    @GetMapping("/fechaReserva")
    public String buscarPorFechaReserva(@RequestParam String fechaInicio, @RequestParam String fechaFin, Model model) {
        model.addAttribute("reservas", reservaService.findByFechaReservaBetween(fechaInicio, fechaFin));
        return "reservas/reserva-lista";
    }

    // Busca reservas por precio y tipo de entrada
    @GetMapping("/precioTipoEntrada")
    public String buscarPorPrecioYTipoEntrada(@RequestParam BigDecimal precio, @RequestParam String tipoEntrada, Model model) {
        model.addAttribute("reservas", reservaService.findByPrecioAndTipoEntrada(precio, tipoEntrada));
        return "reservas/reserva-lista";
    }
}