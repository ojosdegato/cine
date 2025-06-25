package cine.cartelera.cine.services.impl;

import cine.cartelera.cine.entities.Usuario;
import cine.cartelera.cine.enums.User_Role;
import cine.cartelera.cine.repositories.ReservaRepository;
import cine.cartelera.cine.repositories.UsuarioRepository;
import cine.cartelera.cine.services.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Validated
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final ReservaRepository reservaRepository;

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }

    @Override
    public List<Usuario> findByUsername(String username) {
        return usuarioRepository.findByUsername(username);
    }

    @Override
    public List<Usuario> findByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    @Override
    public List<Usuario> findByIsActive(Boolean isActive) {
        return usuarioRepository.findByIsActive(isActive);
    }

    @Override
    public List<Usuario> findByRole(User_Role role) {
        return usuarioRepository.findByRole(role);
    }

    @Override
    public Long contarUsuariosActivos() {
        return usuarioRepository.countByIsActiveTrue();
    }

    @Override
    public Usuario actualizarEstadoCuenta(Long id, Boolean isActive) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            usuario.setIsActive(isActive);
            return usuarioRepository.save(usuario);
        }
        return null;
    }

    @Override
    public Usuario actualizarRolUsuario(Long id, User_Role role) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            usuario.setRole(role);
            return usuarioRepository.save(usuario);
        }
        return null;
    }

    @Override
    public Usuario actualizarInformacionUsuario(Long id, String username, String email) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findById(id);
        if (usuarioOpt.isPresent()) {
            Usuario usuario = usuarioOpt.get();
            usuario.setUsername(username);
            usuario.setEmail(email);
            return usuarioRepository.save(usuario);
        }
        return null;
    }

    @Override
    public boolean validarCredenciales(String username, String password) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByUsername(username)
                .stream().findFirst();
        return usuarioOpt.isPresent() && usuarioOpt.get().getPassword().equals(password);
    }

}