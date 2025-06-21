package cine.cartelera.cine.services;

import cine.cartelera.cine.entities.Usuario;
import cine.cartelera.cine.enums.User_Role;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    private final ReservaRepository reservaRepository;

    List<Usuario> findAll();

    Optional<Usuario> findById(@NotNull(message = "El ID del usuario no puede ser nulo") Long id);

    Usuario save(@Valid Usuario usuario);

    void deleteById(@NotNull(message = "El ID del usuario no puede ser nulo") Long id);

    List<Usuario> findByUsername(@NotBlank(message = "El nombre de usuario no puede estar vacío") String username);

    List<Usuario> findByEmail(@NotBlank(message = "El email no puede estar vacío") String email);

    List<Usuario> findByIsActive(@NotNull(message = "El estado activo no puede ser nulo") Boolean isActive);

    List<Usuario> findByRole(@NotNull(message = "El rol no puede ser nulo") User_Role role);

    Long contarUsuariosActivos();

    Usuario actualizarEstadoCuenta(@NotNull(message = "El ID del usuario no puede ser nulo") Long id,
                                   @NotNull(message = "El estado activo no puede ser nulo") Boolean isActive);

    Usuario actualizarRolUsuario(@NotNull(message = "El ID del usuario no puede ser nulo") Long id,
                                 @NotNull(message = "El rol no puede ser nulo") User_Role role);

    Usuario actualizarInformacionUsuario(@NotNull(message = "El ID del usuario no puede ser nulo") Long id,
                                         @NotBlank(message = "El nombre de usuario no puede estar vacío") String username,
                                         @NotBlank(message = "El email no puede estar vacío") String email);

    boolean validarCredenciales(@NotBlank(message = "El nombre de usuario no puede estar vacío") String username,
                                @NotBlank(message = "La contraseña no puede estar vacía") String password);

    List<Usuario> listarTodos();

    Optional<Usuario> buscarPorId(Long id);

    Usuario guardar(Usuario usuario);

    void eliminar(Long id);
}

