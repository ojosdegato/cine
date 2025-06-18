package cine.cartelera.cine.services;

import cine.cartelera.cine.entities.Proyeccion;
import cine.cartelera.cine.repositories.ProyeccionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProyeccionService {

    private final ProyeccionRepository proyeccionRepository;

    public List<Proyeccion> findAll() { return proyeccionRepository.findAll(); }

    public Optional<Proyeccion> findById(Long id) { return proyeccionRepository.findById(id); }

    public Proyeccion save(Proyeccion proyeccion) {
        return proyeccionRepository.save(proyeccion);
    }

    public void deleteById(Long id) {
        proyeccionRepository.deleteById(id);
    }



//    // Método para buscar un proyeccion por su nombre de proyeccion
//    public Proyeccion findByUsername(String username) {
//        List<Proyeccion> proyeccions = proyeccionRepository.findByproyeccionname(username);
//        // Si no se encuentra ningún proyeccion, retornar null
//        return proyeccions.isEmpty() ? null : proyeccions.get(0);
//    }
//
//    // Método para buscar un proyeccion por su email
//    public Proyeccion findByEmail(String email) {
//        List<Proyeccion> proyeccions = proyeccionRepository.findByEmail(email);
//        // Si no se encuentra ningún proyeccion, retornar null
//        return proyeccions.isEmpty() ? null : proyeccions.get(0);
//    }
//
//    // Método para buscar proyeccions por estado de cuenta (activo/inactivo)
//    public List<Proyeccion> findByActivo(boolean activo) {
//        // Retorna una lista de proyeccions filtrados por su estado activo
//        return proyeccionRepository.findByActivo(activo);
//    }
//
//    // Método para buscar proyeccions por rol
//    public List<Proyeccion> findByRol(String rol) {
//        // Retorna una lista de proyeccions filtrados por su rol
//        return proyeccionRepository.findByRol(rol);
//    }
//
//    // Método para contar proyeccions activos
//    public Long contarProyeccionesActivas() {
//        // Utiliza una consulta personalizada para contar los proyeccions activos
//        return proyeccionRepository.contarProyeccionesActivas;
//    }

}
