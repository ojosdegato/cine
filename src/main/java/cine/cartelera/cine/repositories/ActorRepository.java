package cine.cartelera.cine.repositories;

import cine.cartelera.cine.entities.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // Opcional, pero buena práctica para claridad
public interface ActorRepository extends JpaRepository<Actor, Long> {
    List<Actor> findByNombreContainingIgnoreCase(String nombre);

    List<Actor> findByApellidoContainingIgnoreCase(String apellido);

    List<Actor> findByNacionalidadIgnoreCase(String nacionalidad);

    // JpaRepository<TipoDeEntidad, TipoDeId>
    // Spring Data JPA provee automáticamente métodos como:
    // save(), findById(), findAll(), deleteById(), etc.

    // Puedes añadir métodos de consulta personalizados, por ejemplo:
    // List<Actor> findByFechaNacimientoBefore(LocalDate fecha);
}