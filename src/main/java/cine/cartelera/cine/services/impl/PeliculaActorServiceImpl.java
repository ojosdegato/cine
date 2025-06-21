package cine.cartelera.cine.services.impl; // Paquete para la implementación del servicio

import cine.cartelera.cine.entities.PeliculaActor;
import cine.cartelera.cine.entities.PeliculaActorId;
import cine.cartelera.cine.repositories.PeliculaActorRepository; // Importa tu repositorio de PeliculaActor
import cine.cartelera.cine.services.PeliculaActorService; // Importa la interfaz del servicio
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service // Anotación que marca esta clase como un componente de servicio de Spring
public class PeliculaActorServiceImpl implements PeliculaActorService {

    private final PeliculaActorRepository peliculaActorRepository;

    @Autowired // Inyección de dependencia del PeliculaActorRepository
    public PeliculaActorServiceImpl(PeliculaActorRepository peliculaActorRepository) {
        this.peliculaActorRepository = peliculaActorRepository;
    }

    @Override
    public PeliculaActor savePeliculaActor(PeliculaActor peliculaActor) {
        // Al guardar, JPA se encargará de gestionar la clave compuesta.
        // Asegúrate de que el 'id' dentro de peliculaActor esté correctamente inicializado
        // antes de llamar a este método (ej: new PeliculaActorId(pelicula.getId(), actor.getId()))
        return peliculaActorRepository.save(peliculaActor);
    }

    @Override
    public Optional<PeliculaActor> getPeliculaActorById(PeliculaActorId id) {
        return peliculaActorRepository.findById(id);
    }

    @Override
    public List<PeliculaActor> getAllPeliculaActores() {
        return peliculaActorRepository.findAll();
    }

    @Override
    public void deletePeliculaActor(PeliculaActorId id) {
        peliculaActorRepository.deleteById(id);
    }

    @Override
    public List<PeliculaActor> findByPeliculaId(Long peliculaId) {
        // Este método en el repositorio se apoyará en la relación definida en la entidad PeliculaActor
        return peliculaActorRepository.findByPelicula_Id(peliculaId);
        // O si no se mapea automáticamente, se usaría un método de consulta @Query:
        // @Query("SELECT pa FROM PeliculaActor pa WHERE pa.pelicula.id = :peliculaId")
        // List<PeliculaActor> findByPeliculaId(@Param("peliculaId") Long peliculaId);
    }

    @Override
    public List<PeliculaActor> findByActorId(Long actorId) {
        // Similar a findByPeliculaId, se apoya en la relación
        return peliculaActorRepository.findByActor_Id(actorId);
        // O con @Query:
        // @Query("SELECT pa FROM PeliculaActor pa WHERE pa.actor.id = :actorId")
        // List<PeliculaActor> findByActorId(@Param("actorId") Long actorId);
    }

    @Override
    public List<PeliculaActor> findByRol(String rol) {
        return peliculaActorRepository.findByRol(rol);
    }

    @Override
    public Optional<PeliculaActor> findByPeliculaIdAndActorId(Long idPelicula, Long idActor) {
        return peliculaActorRepository.findById_IdPeliculaAndId_IdActor(idPelicula, idActor);
    }
}