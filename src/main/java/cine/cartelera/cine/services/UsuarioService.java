package cine.cartelera.cine.services;

import cine.cartelera.cine.entities.Usuario;
import cine.cartelera.cine.repositories.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> finById(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }

    // Método para buscar un usuario por su nombre de usuario
    public Usuario findByUsername(String username) {
        List<Usuario> usuarios = usuarioRepository.findByUsername(username);
        // Si no se encuentra ningún usuario, retornar null
        return usuarios.isEmpty() ? null : usuarios.get(0);
    }

    // Método para buscar un usuario por su email
    public Usuario findByEmail(String email) {
        List<Usuario> usuarios = usuarioRepository.findByEmail(email);
        // Si no se encuentra ningún usuario, retornar null
        return usuarios.isEmpty() ? null : usuarios.get(0);
    }

    // Método para buscar usuarios por estado de cuenta (activo/inactivo)
    public List<Usuario> findByActivo(boolean activo) {
        // Retorna una lista de usuarios filtrados por su estado activo
        return usuarioRepository.findByActivo(activo);
    }

    // Método para buscar usuarios por rol
    public List<Usuario> findByRol(String rol) {
        // Retorna una lista de usuarios filtrados por su rol
        return usuarioRepository.findByRol(rol);
    }

    // Método para contar usuarios activos
    public Long contarUsuariosActivos() {
        // Utiliza una consulta personalizada para contar los usuarios activos
        return usuarioRepository.contarUsuariosActivos();
    }











}
