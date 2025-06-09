package cine.cartelera.cine.controllers;

import cine.cartelera.cine.entities.PeliculaActor;
import cine.cartelera.cine.entities.PeliculaActorId;
import cine.cartelera.cine.entities.Actor; // Necesario para la entidad Actor
import cine.cartelera.cine.entities.Pelicula; // Necesario para la entidad Pelicula
import cine.cartelera.cine.repositories.PeliculaActorRepository;
import cine.cartelera.cine.repositories.ActorRepository; // Para buscar el actor
import cine.cartelera.cine.repositories.PeliculaRepository; // Para buscar la película (asumiendo que existe)
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pelicula-actor")
@CrossOrigin(origins = {"http://localhost:8000", "http://127.0.0.1:5500"}) // Ajusta si es necesario
public class PeliculaActorController {

    @Autowired
    private PeliculaActorRepository peliculaActorRepository;

    @Autowired
    private ActorRepository actorRepository; // Para buscar el actor por ID

    @Autowired
    private PeliculaRepository peliculaRepository; // Para buscar la película por ID (asegúrate de crear esta interfaz)

    // GET /api/pelicula-actor
    @GetMapping
    public List<PeliculaActor> getAllPeliculaActorRelations() {
        return peliculaActorRepository.findAll();
    }

    // GET /api/pelicula-actor/{idPelicula}/{idActor}
    @GetMapping("/{idPelicula}/{idActor}")
    public ResponseEntity<PeliculaActor> getPeliculaActorById(@PathVariable Long idPelicula, @PathVariable Long idActor) {
        PeliculaActorId id = new PeliculaActorId(idPelicula, idActor);
        Optional<PeliculaActor> peliculaActor = peliculaActorRepository.findById(id);
        return peliculaActor.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST /api/pelicula-actor
    // El frontend enviará idPelicula, idActor y rol. Necesitamos buscar las entidades completas.
    @PostMapping
    public ResponseEntity<PeliculaActor> createPeliculaActor(@RequestBody PeliculaActorRequest request) {
        Optional<Pelicula> peliculaOptional = peliculaRepository.findById(request.getPeliculaId());
        Optional<Actor> actorOptional = actorRepository.findById(request.getActorId());

        if (peliculaOptional.isEmpty() || actorOptional.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Película o Actor no encontrados
        }

        Pelicula pelicula = peliculaOptional.get();
        Actor actor = actorOptional.get();

        PeliculaActor peliculaActor = new PeliculaActor(pelicula, actor, request.getRol());
        PeliculaActor savedPeliculaActor = peliculaActorRepository.save(peliculaActor);
        return new ResponseEntity<>(savedPeliculaActor, HttpStatus.CREATED);
    }

    // DELETE /api/pelicula-actor/{idPelicula}/{idActor}
    @DeleteMapping("/{idPelicula}/{idActor}")
    public ResponseEntity<Void> deletePeliculaActor(@PathVariable Long idPelicula, @PathVariable Long idActor) {
        PeliculaActorId id = new PeliculaActorId(idPelicula, idActor);
        if (peliculaActorRepository.existsById(id)) {
            peliculaActorRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Clase auxiliar para recibir los datos del frontend en el POST
    // Esto es útil porque el frontend envía IDs, no objetos Pelicula o Actor completos
    public static class PeliculaActorRequest {
        private Long peliculaId;
        private Long actorId;
        private PeliculaActor.UserRole rol;

        // Getters y Setters
        public Long getPeliculaId() { return peliculaId; }
        public void setPeliculaId(Long peliculaId) { this.peliculaId = peliculaId; }
        public Long getActorId() { return actorId; }
        public void setActorId(Long actorId) { this.actorId = actorId; }
        public PeliculaActor.UserRole getRol() { return rol; }
        public void setRol(PeliculaActor.UserRole rol) { this.rol = rol; }
    }
}

// NOTA: Para que este controlador funcione, necesitas tener una entidad Pelicula y su respectivo PeliculaRepository.
// Si aún no los tienes, aquí hay un ejemplo básico para Pelicula.java y PeliculaRepository.java
/*
// Pelicula.java (Ejemplo básico)
package com.tuproyecto.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
public class Pelicula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String director;

    public Pelicula() {}
    public Pelicula(String titulo, String director) {
        this.titulo = titulo;
        this.director = director;
    }
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getDirector() { return director; }
    public void setDirector(String director) { this.director = director; }
}

// PeliculaRepository.java (Ejemplo básico)
package com.tuproyecto.repositorio;

import com.tuproyecto.modelo.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {
}
*/