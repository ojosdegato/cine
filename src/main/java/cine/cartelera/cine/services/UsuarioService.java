package cine.cartelera.cine.services;

import cine.cartelera.cine.entities.Usuario;
import cine.cartelera.cine.repositories.ReservaRepository;
import cine.cartelera.cine.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Validated
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final ReservaRepository reservaRepository;

    public Optional<Object> finById(Long id) {
        return Optional.empty();
    }

    // Listar todos los usuarios
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    // Buscar usuario por ID
    public Usuario findById(@NotNull(message = "El ID del usuario no puede ser nulo") Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    // Guardar un usuario
    public Usuario save(@Valid Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Eliminar un usuario por ID
    public void deleteById(@NotNull(message = "El ID del usuario no puede ser nulo") Long id) {
        usuarioRepository.deleteById(id);
    }

    // Buscar usuarios por nombre de usuario
    public List<Usuario> findByUsername(@NotBlank(message = "El nombre de usuario no puede estar vacío") String username) {
        return usuarioRepository.findByUsername(username);
    }

    // Buscar usuarios por email
    public List<Usuario> findByEmail(@NotBlank(message = "El email no puede estar vacío") String email) {
        return usuarioRepository.findByEmail(email);
    }

    // Buscar usuarios por estado de cuenta
    public List<Usuario> findByActivo(@NotNull(message = "El estado activo no puede ser nulo") Boolean activo) {
        return usuarioRepository.findByActivo(activo);
    }

    // Buscar usuarios por rol
    public List<Usuario> findByRol(@NotBlank(message = "El rol no puede estar vacío") String rol) {
        return usuarioRepository.findByRol(rol);
    }

    // Contar usuarios activos
    public Long contarUsuariosActivos() {
        return usuarioRepository.contarUsuariosActivos();
    }

    // Actualizar estado de cuenta del usuario
    public Usuario actualizarEstadoCuenta(
            @NotNull(message = "El ID del usuario no puede ser nulo") Long id,
            @NotNull(message = "El estado activo no puede ser nulo") Boolean activo) {
        Usuario usuario = findById(id);
        usuario.setActivo(activo);
        return usuarioRepository.save(usuario);
    }

    // Actualizar rol de usuario
    public Usuario actualizarRolUsuario(
            @NotNull(message = "El ID del usuario no puede ser nulo") Long id,
            @NotBlank(message = "El rol no puede estar vacío") String rol) {
        Usuario usuario = findById(id);
        usuario.setRol(rol);
        return usuarioRepository.save(usuario);
    }

    // Actualizar información básica del usuario
    public Usuario actualizarInformacionUsuario(
            @NotNull(message = "El ID del usuario no puede ser nulo") Long id,
            @NotBlank(message = "El nombre de usuario no puede estar vacío") String username,
            @NotBlank(message = "El email no puede estar vacío") String email) {
        Usuario usuario = findById(id);
        usuario.setUsername(username);
        usuario.setEmail(email);
        return usuarioRepository.save(usuario);
    }

    // Validar credenciales de usuario
    public boolean validarCredenciales(
            @NotBlank(message = "El nombre de usuario no puede estar vacío") String username,
            @NotBlank(message = "La contraseña no puede estar vacía") String password) {
        // Implementar lógica de validación de credenciales
        return false; // Placeholder - implementar lógica real
    }



}

