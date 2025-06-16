package cine.cartelera.cine.repositories;

import cine.cartelera.cine.entities.Reserva;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    // Buscar reservas por ID de usuario
    List<Reserva> findByUsuarioId(Long usuarioid);

    // Buscar reservas por ID de proyección
    List<Reserva> findByProyeccion_Id(Long id);

    // Buscar reservas por ID de sala
    List<Reserva> findByProyeccion_Sala_Id(Long salaId);

    // Buscar reservas por ID de película
    List<Reserva> findByProyeccion_Pelicula_Id(Long peliculaId);

    // Buscar reservas por el estado de la reserva
    List<Reserva> findByEstadoReserva(String estadoReserva);

    // Buscar reservas por el número del asiento
    List<Reserva> findByNumeroAsiento(String numeroAsiento);

    // Buscar reservas por la fecha de la proyección
    @Query("SELECT r FROM Reserva r WHERE r.proyeccion.fechaHora BETWEEN :fechaInicio AND :fechaFin")
    List<Reserva> findByFechaProyeccionBetween(@Param("fechaInicio") String fechaInicio, @Param("fechaFin") String fechaFin);

    // Buscar reservas por la fecha de la reserva
    @Query("SELECT r FROM Reserva r WHERE r.fechaReserva BETWEEN :fechaInicio AND :fechaFin")
    List<Reserva> findByFechaReservaBetween(@Param("fechaInicio") String fechaInicio, @Param("fechaFin") String fechaFin);


    // Buscar reservas por precio, dependendo si la entrada es normal o del día del espectador
    @Query("SELECT r FROM Reserva r WHERE r.precio = :precio AND r.tipoEntrada = :tipoEntrada")
    List<Reserva> findByPrecioAndTipoEntrada(@Param("precio") BigDecimal precio, @Param("tipoEntrada") String tipoEntrada);

    // Contar la cantidad de entrasdas reservadas por usuario
    @Query("SELECT COUNT(r) FROM Reserva r WHERE r.usuario.id = :usuarioId")
    Long countEntradasReservadasPorUsuario(@Param("usuarioId") Long usuarioId);

    // Contar cuantas entradas se han reservado por método de pago, dependiendo si es tarjeta o efectivo
    @Query("SELECT COUNT(r) FROM Reserva r WHERE r.usuario.id = :usuarioId AND r.metodoPago = :metodoPago")
    Long countEntradasPorMetodoPago(@Param("usuarioId") Long usuarioId, @Param("metodoPago") String metodoPago);

    // Contar cuantas entradas normales y cuantas entradas del día del espectador hay reservadas
    @Query("SELECT SUM(CASE WHEN r.tipoEntrada = 'NORMAL' THEN 1 ELSE 0 END), " +
           "SUM(CASE WHEN r.tipoEntrada = 'DIA_ESPECTADOR' THEN 1 ELSE 0 END) " +
           "FROM Reserva r WHERE r.usuario.id = :usuarioId")
    List<BigDecimal> countEntradasPorTipo(@Param("usuarioId") Long usuarioId);

}






