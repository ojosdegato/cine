package cine.cartelera.cine.repositories;

import cine.cartelera.cine.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    // Buscar tickets por aforo de la sala
    List<Ticket> findByAforoDeLaSala(int aforoDeLaSala);

    // Buscar tickets con aforo mayor a un valor específico
    List<Ticket> findByAforoDeLaSalaGreaterThan(int aforoDeLaSala);

    // Buscar tickets con aforo menor o igual a un valor específico
    List<Ticket> findByAforoDeLaSalaLessThanEqual(int aforoDeLaSala);

    // Buscar tickets por asientos ocupados
    List<Ticket> findByAsientosOcupados(int asientosOcupados);

    // Buscar tickets con asientos ocupados dentro de un rango
    List<Ticket> findByAsientosOcupadosBetween(int minAsientos, int maxAsientos);

    // Buscar tickets con aforo y asientos ocupados específicos
    List<Ticket> findByAforoDeLaSalaAndAsientosOcupados(int aforoDeLaSala, int asientosOcupados);

    // Contar tickets según el aforo de la sala
    long countByAforoDeLaSala(int aforoDeLaSala);

    // Contar tickets según los asientos ocupados
    long countByAsientosOcupados(int asientosOcupados);
}
