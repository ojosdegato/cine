package cine.cartelera.cine.services;


import cine.cartelera.cine.entities.Pelicula;
import cine.cartelera.cine.repositories.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscarServices {

    @Autowired
    private PeliculaRepository peliculaRepository;

    public List<Pelicula> buscarPorGenero(String genero) {
        if (genero == null || genero.isEmpty()) {
            return peliculaRepository.findAll();
        }
        return peliculaRepository.findByGeneroIgnoreCase(genero);
    }
}
