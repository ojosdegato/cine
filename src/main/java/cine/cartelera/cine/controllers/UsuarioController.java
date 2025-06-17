package cine.cartelera.cine.controllers;

import cine.cartelera.cine.entities.Usuario;
import cine.cartelera.cine.enums.UserRole;
import cine.cartelera.cine.services.UsuarioService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {


    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // Mostrar todos los usuarios
    @GetMapping
    public String listarUsuarios(Model model) {
        List<Usuario> usuarios = usuarioService.findAll();
        model.addAttribute("usuarios", usuarios);

        return "usuarios/listar";
    }

    // Buscar usuario por ID
    @GetMapping("/{id}")
    public String buscarUsuarioPorId(@PathVariable Long id, Model model) {
        usuarioService.finById(id).ifPresent(usuario -> model.addAttribute("usuario", usuario));

        return "usuarios/detalle";
    }


    // Formulario para un nuevo usuario
    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("usuario", new Usuario()); // Crear un nuevo objeto Usuario
        model.addAttribute("roles", UserRole.values()); // Enum para los roles de usuario

        return "usuarios/formulario";
    }

    // Guardar usuario nuevo o editado
    @PostMapping("/guardar")
    public String guardarUsuario(@ModelAttribute Usuario usuario) {
        usuarioService.save(usuario);

        return "redirect:/usuarios";
    }

    // Formulario para editar
    @GetMapping("/editar/{id}")
    public String editarUsuario(@PathVariable Long id, Model model) {
        usuarioService.finById(id).ifPresent(usuario -> model.addAttribute("usuario", usuario)); // Buscar el usuario por ID
        model.addAttribute("roles", UserRole.values());

        return "usuarios/formulario";
    }

    // Eliminar usuario
    @GetMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable Long id) {
        usuarioService.deleteById(id);

        return "redirect:/usuarios";
    }

}





