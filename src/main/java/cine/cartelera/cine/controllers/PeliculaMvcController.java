package cine.cartelera.cine.controllers;

import cine.cartelera.cine.entities.Pelicula;
import cine.cartelera.cine.services.PeliculaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/peliculas")
public class PeliculaMvcController {

    private final PeliculaService peliculaService;

    public PeliculaMvcController(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }

    // Mostrar todas las películas
    @GetMapping
    public String listarPeliculas(Model model) {
        model.addAttribute("peliculas", peliculaService.listarTodas());
        return "peliculas/listar";
    }

    // Formulario para nueva película
    @GetMapping("/nueva")
    public String mostrarFormulario(Model model) {
        model.addAttribute("pelicula", new Pelicula());
        return "peliculas/formulario";
    }

    // Guardar película nueva o editada
    @PostMapping("/guardar")
    public String guardarPelicula(@ModelAttribute Pelicula pelicula) {
        peliculaService.guardar(pelicula);
        return "redirect:/peliculas";
    }

    // Formulario para editar
    @GetMapping("/editar/{id}")
    public String editarPelicula(@PathVariable Long id, Model model) {
        peliculaService.buscarPorId(id).ifPresent(pelicula -> model.addAttribute("pelicula", pelicula));
        return "peliculas/formulario";
    }

    // Eliminar
    @GetMapping("/eliminar/{id}")
    public String eliminarPelicula(@PathVariable Long id) {
        peliculaService.eliminar(id);
        return "redirect:/peliculas";
    }
}