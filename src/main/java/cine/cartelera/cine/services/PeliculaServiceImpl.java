package cine.cartelera.cine.services;

import cine.cartelera.cine.entities.Pelicula;
import cine.cartelera.cine.repositories.PeliculaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeliculaServiceImpl implements PeliculaService {

    private final PeliculaRepository peliculaRepository;

    public PeliculaServiceImpl(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }

    @Override
    public List<Pelicula> listarTodas() {
        return peliculaRepository.findAll();
    }

    @Override
    public Optional<Pelicula> buscarPorId(Long id) {
        return peliculaRepository.findById(id);
    }

    @Override
    public Pelicula guardar(Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }

    @Override
    public void eliminar(Long id) {
        peliculaRepository.deleteById(id);
    }
}