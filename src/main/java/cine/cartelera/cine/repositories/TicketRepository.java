package cine.cartelera.cine.repositories;

import cine.cartelera.cine.entities.Proyeccion;
import cine.cartelera.cine.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

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
    @Query("select p from Ticket t where t.AsientosOcupados between :minAsientosOcupados and :maxAsientosOcupados")
    List<Ticket> findByAsientosOcupadosBetween(int minAsientosOcupados, int maxAsientosOcupados);

    // Buscar tickets con aforo y asientos ocupados específicos
    List<Ticket> findByAforoDeLaSalaAndAsientosOcupados(int aforoDeLaSala, int asientosOcupados);

    // Contar tickets según el aforo de la sala
    long countByAforoDeLaSala(int aforoDeLaSala);

    // Contar tickets según los asientos ocupados
    long countByAsientosOcupados(int asientosOcupados);

    // Busca tickets asociados a una proyección por Id
    List<Ticket> findByProyeccionId(Long proyeccionId);



}
