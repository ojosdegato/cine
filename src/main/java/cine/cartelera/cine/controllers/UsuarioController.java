package cine.cartelera.cine.controllers;

import cine.cartelera.cine.entities.Usuario;
import cine.cartelera.cine.repositories.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import java.util.Optional;

@RestController
@RequestMapping("api/usuarios")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {this.usuarioRepository = usuarioRepository; }

    // Obtener todos los usuarios
    @GetMapping
    public List<Usuario> listarUsuarios() { return usuarioRepository.findAll(); }

    // Obtener un usuario por ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerUsuario(@PathVariable Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        // Si el usuario existe, se devuelve;
        return usuario.map(ResponseEntity::ok)
                // si no existe, devuelve un 404 Not Found
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear un nuevo usuario
    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuario) { return usuarioRepository.save(usuario); }

    // Actualizar un usuario existente
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@PathVariable Long id, @RequestBody Usuario datosActualizados) {
        return usuarioRepository.findById(id)
                .map(usuarioExistente -> {
                    usuarioExistente.setUsername(datosActualizados.getUsername());
                    usuarioExistente.setPassword(datosActualizados.getPassword());
                    usuarioExistente.setEmail(datosActualizados.getEmail());
                    usuarioExistente.setIsActive(datosActualizados.getIsActive());
                    usuarioExistente.setRole(datosActualizados.getRole());
                    Usuario actualizado = usuarioRepository.save(usuarioExistente);
                    // Si el usuario existe, se actualiza y se devuelve;
                    return ResponseEntity.ok(actualizado);
                    // Si no existe, devuelve un 404 Not Found y no se actualiza
                }).orElse(ResponseEntity.notFound().build());
    }

    // Eliminar un usuario
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return ResponseEntity.noContent().build(); // Devuelve 204 No Content si se elimina correctamente
        } else {
            return ResponseEntity.notFound().build(); // Devuelve 404 Not Found si el usuario no existe
        }
    }

}







