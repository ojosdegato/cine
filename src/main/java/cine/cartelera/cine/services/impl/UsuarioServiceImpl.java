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
        return List.of();
    }

    @Override
    public Optional<Usuario> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Usuario save(Usuario usuario) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<Usuario> findByUsername(String username) {
        return List.of();
    }

    @Override
    public List<Usuario> findByEmail(String email) {
        return List.of();
    }

    @Override
    public List<Usuario> findByIsActive(Boolean isActive) {
        return List.of();
    }

    @Override
    public List<Usuario> findByRole(User_Role role) {
        return List.of();
    }

    @Override
    public Long contarUsuariosActivos() {
        return 0L;
    }

    @Override
    public Usuario actualizarEstadoCuenta(Long id, Boolean isActive) {
        return null;
    }

    @Override
    public Usuario actualizarRolUsuario(Long id, User_Role role) {
        return null;
    }

    @Override
    public Usuario actualizarInformacionUsuario(Long id, String username, String email) {
        return null;
    }

    @Override
    public boolean validarCredenciales(String username, String password) {
        return false;
    }

    @Override
    public List<Usuario> listarTodos() {
        return usuarioRepository.findAll();
    }

    @Override
    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    @Override
    public Usuario guardar(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public void eliminar(Long id) {
        usuarioRepository.deleteById(id);
    }
}