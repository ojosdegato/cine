package cine.cartelera.cine.controllers;

import cine.cartelera.cine.entities.Actor;
import cine.cartelera.cine.repositories.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController // Indica que esta clase es un controlador REST
@RequestMapping("/api/actores") // Define la ruta base para todos los endpoints de este controlador
@CrossOrigin(origins = {"http://localhost:8000", "http://127.0.0.1:5500"}) // Permite solicitudes desde tu frontend (ajusta si es necesario)
public class ActorController {

    @Autowired // Inyecta la dependencia del repositorio
    private ActorRepository actorRepository;

    // GET /api/actores
    @GetMapping
    public List<Actor> getAllActores() {
        return actorRepository.findAll();
    }

    // GET /api/actores/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Actor> getActorById(@PathVariable Long id) {
        Optional<Actor> actor = actorRepository.findById(id);
        return actor.map(ResponseEntity::ok) // Si el actor existe, devuelve 200 OK
                .orElseGet(() -> ResponseEntity.notFound().build()); // Si no, devuelve 404 Not Found
    }

    // POST /api/actores
    @PostMapping
    public ResponseEntity<Actor> createActor(@RequestBody Actor actor) {
        Actor savedActor = actorRepository.save(actor);
        return new ResponseEntity<>(savedActor, HttpStatus.CREATED); // Devuelve 201 Created
    }

    // PUT /api/actores/{id}
    @PutMapping("/{id}")
    public ResponseEntity<Actor> updateActor(@PathVariable Long id, @RequestBody Actor actorDetails) {
        Optional<Actor> actorOptional = actorRepository.findById(id);
        if (actorOptional.isPresent()) {
            Actor actor = actorOptional.get();
            actor.setNombre(actorDetails.getNombre());
            actor.setApellido(actorDetails.getApellido());
            actor.setFechaNacimiento(actorDetails.getFechaNacimiento());
            Actor updatedActor = actorRepository.save(actor);
            return ResponseEntity.ok(updatedActor);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE /api/actores/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteActor(@PathVariable Long id) {
        if (actorRepository.existsById(id)) {
            actorRepository.deleteById(id);
            return ResponseEntity.noContent().build(); // Devuelve 204 No Content
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}