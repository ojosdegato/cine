package cine.cartelera.cine.controllers;

import cine.cartelera.cine.entities.Reserva;
import cine.cartelera.cine.repositories.ReservaRepository;
import cine.cartelera.cine.repositories.ReservaRepository;
import cine.cartelera.cine.services.ReservaService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/reservas")
public class ReservaController {


    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    // Mostrar todas las reservas
    @GetMapping
    public String listarReservas(Model model) {
        List<Reserva> reservas = reservaService.listarTodas();
        model.addAttribute("reservas", reservas);
        return "reservas/listar";
    }

    // Formulario para una nueva reserva
    @GetMapping("/nueva")
    public String mostrarFormulario(Model model) {
        model.addAttribute("reserva", new Reserva());
        return "reservas/formulario";
    }
    // Guardar reserva nueva o editada
    @PostMapping("/guardar")
    public String guardarReserva(@Valid @ModelAttribute Reserva reserva, BindingResult result) {
        if (result.hasErrors()) {
            return "reservas/formulario"; // Volver al formulario si hay errores
        }
        reservaService.save(reserva);
        return "redirect:/reservas";
    }

    // Formulario para editar una reserva
    @GetMapping("/editar/{id}")
    public String editarReserva(@PathVariable Long id, Model model) {
        Reserva reserva = reservaService.buscarPorId(id);
        model.addAttribute("reserva", reserva);
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









}



