package cine.cartelera.cine.controllers;

import cine.cartelera.cine.entities.Proyeccion;
import cine.cartelera.cine.services.ProyeccionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/proyecciones")
public class ProyeccionController {

    private final ProyeccionService proyeccionService;

    public ProyeccionController(ProyeccionService proyeccionService) {
        this.proyeccionService = proyeccionService;
    }

    // Mostrar todas las proyecciones
    @GetMapping
    public String listarProyecciones(Model model) {
        List<Proyeccion> proyecciones = proyeccionService.findAll();
        model.addAttribute("proyecciones", proyecciones);
        return "proyecciones/listar";
    }

    // Buscar proyección por ID
    @GetMapping("/{id}")
    public String buscarProyeccionPorId(@PathVariable Long id, Model model) {
        proyeccionService.findById(id).ifPresent(proyeccion ->
                model.addAttribute("proyeccion", proyeccion));
        return "proyecciones/detalle";
    }

    // Formulario para una nueva proyección
    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("proyeccion", new Proyeccion());
        return "proyecciones/formulario";
    }

    // Guardar proyección nueva o editada
    @PostMapping("/guardar")
    public String guardarProyeccion(@ModelAttribute Proyeccion proyeccion) {
        proyeccionService.save(proyeccion);
        return "redirect:/proyecciones";
    }

    // Formulario para editar
    @GetMapping("/editar/{id}")
    public String editarProyeccion(@PathVariable Long id, Model model) {
        proyeccionService.findById(id).ifPresent(proyeccion ->
                model.addAttribute("proyeccion", proyeccion));
        return "proyecciones/formulario";
    }

    // Eliminar proyección
    @GetMapping("/eliminar/{id}")
    public String eliminarProyeccion(@PathVariable Long id) {
        proyeccionService.deleteById(id);
        return "redirect:/proyecciones";
    }
}