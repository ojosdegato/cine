package cine.cartelera.cine.controllers;

import cine.cartelera.cine.entities.Pelicula;
import cine.cartelera.cine.repositories.PeliculaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/peliculas")
public class PeliculaController {

    private final PeliculaRepository peliculaRepository;

    public PeliculaController(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }

    // Obtener todas las películas
    @GetMapping
    public List<Pelicula> listarPeliculas() {
        return peliculaRepository.findAll();
    }

    // Obtener una película por ID
    @GetMapping("/{id}")
    public ResponseEntity<Pelicula> obtenerPelicula(@PathVariable Long id) {
        Optional<Pelicula> pelicula = peliculaRepository.findById(id);
        return pelicula.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear una nueva película
    @PostMapping
    public Pelicula crearPelicula(@RequestBody Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }

    // Actualizar una película existente
    @PutMapping("/{id}")
    public ResponseEntity<Pelicula> actualizarPelicula(@PathVariable Long id, @RequestBody Pelicula datosActualizados) {
        return peliculaRepository.findById(id)
                .map(peliculaExistente -> {
                    peliculaExistente.setTitulo(datosActualizados.getTitulo());
                    peliculaExistente.setGenero(datosActualizados.getGenero());
                    peliculaExistente.setDuracion(datosActualizados.getDuracion());
                    peliculaExistente.setClasificacionEdad(datosActualizados.getClasificacionEdad());
                    peliculaExistente.setSinopsis(datosActualizados.getSinopsis());
                    peliculaExistente.setTrailer(datosActualizados.getTrailer());
                    Pelicula actualizada = peliculaRepository.save(peliculaExistente);
                    return ResponseEntity.ok(actualizada);
                }).orElse(ResponseEntity.notFound().build());
    }

    // Eliminar una película
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPelicula(@PathVariable Long id) {
        if (peliculaRepository.existsById(id)) {
            peliculaRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}