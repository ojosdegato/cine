package cine.cartelera.cine.repositories;

import cine.cartelera.cine.entities.Reserva;
import cine.cartelera.cine.enums.Estado_Reserva;
import cine.cartelera.cine.enums.Tipo_Entrada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    List<Reserva> findByUsuarioId(Long usuarioid);

    List<Reserva> findByProyeccion_Id(Long id);

    List<Reserva> findByProyeccion_Sala_Id(Long salaId);

    List<Reserva> findByProyeccion_Pelicula_Id(Long peliculaId);

    List<Reserva> findByEstadoReserva(Estado_Reserva estado);

    List<Reserva> findByNumeroAsiento(String numeroAsiento);

    // Buscar reservas por la fecha de la proyección
    @Query("SELECT r FROM Reserva r WHERE r.proyeccion.fechaHora BETWEEN :fechaInicio AND :fechaFin")
    List<Reserva> findByFechaProyeccionBetween(@Param("fechaInicio") LocalDateTime fechaInicio, @Param("fechaFin") LocalDateTime fechaFin);

    // Buscar reservas por la fecha de la reserva
    @Query("SELECT r FROM Reserva r WHERE r.fechaReserva BETWEEN :fechaInicio AND :fechaFin")
    List<Reserva> findByFechaReservaBetween(@Param("fechaInicio") LocalDateTime fechaInicio, @Param("fechaFin") LocalDateTime fechaFin);

    // Buscar reservas por precio y tipo de entrada (usando los nombres correctos y el enum)
    List<Reserva> findByPrecioEntradaAndTipoEntrada(BigDecimal precioEntrada, Tipo_Entrada tipoEntrada);

    @Query("SELECT COUNT(r) FROM Reserva r WHERE r.usuario.id = :usuarioId")
    Long countEntradasReservadasPorUsuario(@Param("usuarioId") Long usuarioId);

    @Query("SELECT COUNT(r) FROM Reserva r WHERE r.usuario.id = :usuarioId AND r.metodoPago = :metodoPago")
    Long countEntradasPorMetodoPago(@Param("usuarioId") Long usuarioId, @Param("metodoPago") String metodoPago);

    // Contar cuántas entradas hay por tipo usando el enum
    @Query("SELECT COUNT(r) FROM Reserva r WHERE r.usuario.id = :usuarioId AND r.tipoEntrada = :tipoEntrada")
    Long countEntradasPorTipo(@Param("usuarioId") Long usuarioId, @Param("tipoEntrada") Tipo_Entrada tipoEntrada);

}






