package cine.cartelera.cine.repositories;

import cine.cartelera.cine.entities.Usuario;
import cine.cartelera.cine.enums.User_Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    List<Usuario> findByUsername(String username);

    List<Usuario> findByEmail(String email);

    // Buscar por estado de cuenta (activo/inactivo)
    List<Usuario> findByIsActive(Boolean isActive);

    // Buscar por rol de usuario
    List<Usuario> findByRole(User_Role role);

    @Query("SELECT COUNT(u) FROM Usuario u WHERE u.isActive = true")
    Long countByIsActiveTrue();

}

