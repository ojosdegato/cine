package cine.cartelera.cine.controllers;

import cine.cartelera.cine.entities.Pelicula;
import cine.cartelera.cine.services.PeliculaService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

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

    @GetMapping("/detalles/{id}")
    public String mostrarDetalles(@PathVariable Long id, Model model) {
        Optional<Pelicula> pelicula = peliculaService.buscarPorId(id);
        if (pelicula.isPresent()) {
            model.addAttribute("pelicula", pelicula.get());
            return "peliculas/detalles";
        } else {
            return "redirect:/peliculas";
        }
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

    // Mostrar formulario de confirmación para eliminar
    @GetMapping("/eliminar/{id}")
    public String mostrarConfirmacionEliminar(@PathVariable Long id, Model model) {
        Pelicula pelicula = peliculaService.buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Película no encontrada"));
        model.addAttribute("pelicula", pelicula);
        return "peliculas/eliminar"; // este es tu eliminar.html
    }

    // Procesar la eliminación (POST)
    @PostMapping("/eliminar/{id}")
    public String eliminarPelicula(@PathVariable Long id, RedirectAttributes redirectAttrs) {
        peliculaService.eliminar(id);
        redirectAttrs.addFlashAttribute("mensaje", "Película eliminada correctamente ✅");
        return "redirect:/peliculas";
    }
}