package cine.cartelera.cine.repositories;

import cine.cartelera.cine.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Buscar por nombre de usuario
    List<Usuario> findByUsername(String username);

    // Buscar por email
    List<Usuario> findByEmail(String email);

    // Buscar por estado de cuenta (activo/inactivo)
    List<Usuario> findByActivo(boolean activo);

    // Buscar por rol de usuario
    List<Usuario> findByRol(String rol);

    // Contar por usuarios activos
    @Query("SELECT COUNT(u) FROM Usuario u WHERE u.isActive = true")
    Long contarUsuariosActivos();








}

