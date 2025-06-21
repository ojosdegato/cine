package cine.cartelera.cine.controllers;


import cine.cartelera.cine.entities.Usuario;
import cine.cartelera.cine.services.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;


@Controller
@RequestMapping("/usuarios")
public class UsuarioMvcController {

    private final UsuarioService usuarioService;

    public UsuarioMvcController(UsuarioService usuarioService) { this.usuarioService = usuarioService; }

    // Mostrar todos los usuarios
    @GetMapping
    public String listarUsuarios(Model model) {
        model.addAttribute("usuarios", usuarioService.findAll());
        return "usuarios/usuario-lista";
    }

    // Mostrar detalles de un usuario
    @GetMapping("/detalle/{id}")
    public String mostrarDetallesUsuario(@PathVariable Long id, Model model) {
        Optional<Usuario> usuario = usuarioService.findById(id);
        if (usuario.isPresent()) {
            model.addAttribute("usuario", usuario.get());
            return "usuarios/usuario-detalle";
        } else {
            return "redirect:/usuarios";
        }
    }

    // Formulario para nuevo usuario
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevoUsuario(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "usuarios/usuario-formulario";
    }

    // Guardar usuario nuevo o editado
    @GetMapping("/guardar")
    public String guardarUsuario(@ModelAttribute Usuario usuario) {
        usuarioService.save(usuario);
        return "redirect:/usuarios";
    }

    // Formulario para editar usuario
    @GetMapping("/editar/{id}")
    public String editarUsuario(@PathVariable Long id, Model model) {
        usuarioService.findById(id).ifPresent(usuario -> model.addAttribute("usuario", usuario));
        return "usuarios/usuario-formulario";
    }

    // Eliminar usuario
    @GetMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable Long id) {
        usuarioService.deleteById(id);
        return "redirect:/usuarios";
    }







}
