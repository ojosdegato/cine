package cine.cartelera.cine.services;

import cine.cartelera.cine.entities.Actor;
import cine.cartelera.cine.repositories.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ActorServiceImpl implements ActorService {

    private final ActorRepository actorRepository;

    @Autowired
    public ActorServiceImpl(ActorRepository actorRepository) {
        this.actorRepository = actorRepository;
    }

    @Override
    public Actor guardarActor(Actor actor) {
        return actorRepository.save(actor);
    }

    @Override
    public Optional<Actor> buscarActorPorId(Long id) {
        return actorRepository.findById(id);
    }

    @Override
    public List<Actor> obtenerTodosLosActores() {
        return actorRepository.findAll();
    }

    @Override
    public void eliminarActor(Long id) {
        actorRepository.deleteById(id);
    }

    @Override
    public List<Actor> buscarActoresPorNacionalidad(String nacionalidad) {
        return actorRepository.findByNacionalidadIgnoreCase(nacionalidad);
    }

    @Override
    public Actor saveActor(Actor actor) {
        return actorRepository.save(actor);
    }

    @Override
    public Optional<Actor> getActorById(Long id) {
        return actorRepository.findById(id);
    }

    @Override
    public List<Actor> getAllActors() {
        return actorRepository.findAll();
    }

    @Override
    public void deleteActor(Long id) {
        actorRepository.deleteById(id);
    }

    @Override
    public List<Actor> findActorsByNombre(String nombre) {
        return actorRepository.findByNombreContainingIgnoreCase(nombre);
    }

    @Override
    public List<Actor> findActorsByApellido(String apellido) {
        return actorRepository.findByApellidoContainingIgnoreCase(apellido);
    }

    @Override
    public List<Actor> findActorsByNacionalidad(String nacionalidad) {
        return actorRepository.findByNacionalidadIgnoreCase(nacionalidad);
    }
}
