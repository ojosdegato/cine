Integrando la IA en la Cartelera de Cine: Recomendaciones por Estado de Ánimo y Filtros
Esta sección detalla cómo vamos a incluir la funcionalidad de recomendación de películas basada en el estado de ánimo y filtros de usuario, añadiendo un valor innovador a nuestro proyecto.
1. Visión General y Viabilidad de la Idea
   La idea de integrar la Inteligencia Artificial para ofrecer recomendaciones personalizadas es fantástica y completamente viable. Eleva significativamente el valor de nuestra aplicación, y es una característica muy demandada en plataformas de contenido. Comenzar con la inferencia del estado de ánimo (un desafío interesante) y los filtros explícitos es un punto de partida estratégico y muy atractivo.
2. Enfoque de Desarrollo para la Funcionalidad de IA
   Para la primera versión funcional de esta característica, nos centraremos en un enfoque de "reglas basadas en contenido". Es la forma más rápida y efectiva de proporcionar valor sin la complejidad inicial de un modelo de Machine Learning avanzado.
   2.1. Recopilación de Información para la Recomendación
   Necesitamos datos para recomendar. El usuario nos los dará:
* Estado de Ánimo Directo: El usuario seleccionará su estado de ánimo de una lista predefinida (ej. "Alegre", "Triste", "Emocionado", "Relajado"). Esta es la forma más directa de obtener la preferencia de ánimo.
* Filtros Explícitos: Mantendremos y ampliaremos los filtros de búsqueda tradicionales como género, director, año, o actor.
* (Nota a futuro: En iteraciones posteriores, podríamos considerar el historial de visionado del usuario o incluso análisis de texto libre para refinar las recomendaciones, pero eso sería una fase más compleja).
  2.2. Construcción del Motor de Recomendación (La "IA" Inicial)
  El "cerebro" de esta IA inicial se basará en cómo categorizamos nuestras películas y cómo consultamos esa información.
* Concepto de "Reglas Basadas en Contenido":
  Asignaremos "etiquetas" (o tags) a las películas que las relacionen con estados de ánimo específicos o temáticas. Por ejemplo:
    * Una "Comedia Romántica" podría etiquetarse como "Alegre".
    * Un "Drama" como "Triste" o "Pensativo".
    * Una película de "Acción" como "Emocionado".
* Implementación Técnica:
    * a) Modificación de la Entidad Pelicula.java (Backend - Modelo):
      Ampliaremos nuestra clase Pelicula para incluir campos que almacenen los estados de ánimo (moods) y géneros (genres) asociados a cada película. Esto se hará usando @ElementCollection, que es ideal para colecciones de tipos básicos (como String) en JPA, mapeándolos a tablas separadas para una buena normalización.
      // Fichero: src/main/java/com/carteleradecine/modelo/Pelicula.java
      // (Solo fragmento relevante, omitiendo getters/setters y otros campos para brevedad)

import jakarta.persistence.*;
import java.util.Set;
import java.util.HashSet;

@Entity
public class Pelicula {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String titulo;
private String director; // Añadir más campos de Pelicula si se gestionan

    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "pelicula_moods", joinColumns = @JoinColumn(name = "pelicula_id"))
    @Column(name = "mood")
    private Set<String> moods = new HashSet<>(); // Ej: {"Alegre", "Inspirador"}

    @ElementCollection(targetClass = String.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "pelicula_genres", joinColumns = @JoinColumn(name = "pelicula_id"))
    @Column(name = "genre")
    private Set<String> genres = new HashSet<>(); // Ej: {"Accion", "Comedia"}

    // Constructor vacío, constructor con parámetros, getters y setters
    // ...
}

     * Nota: fetch = FetchType.EAGER significa que los moods y genres se cargarán junto con la película. CollectionTable y Column definen la tabla y la columna para estas colecciones en la base de datos.
* b) Lógica en el Repositorio PeliculaRepository.java (Backend - Persistencia):
  Necesitaremos métodos de consulta en nuestro repositorio para buscar películas basándonos en estos nuevos campos (moods y genres). Spring Data JPA nos permite hacer esto fácilmente con queries derivadas (por el nombre del método) o JPQL para consultas más complejas.
  // Fichero: src/main/java/com/carteleradecine/repositorio/PeliculaRepository.java
  // (Fragmento relevante)

package com.carteleradecine.repositorio;

import com.carteleradecine.modelo.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {
// 1. Buscar películas que contengan un estado de ánimo específico
//    (Ej: findByMoodsContaining("Alegre"))
List<Pelicula> findByMoodsContaining(String mood);

    // 2. Buscar películas que contengan un género específico
    //    (Ej: findByGenresContaining("Comedia"))
    List<Pelicula> findByGenresContaining(String genre);

    // 3. Buscar películas por estado de ánimo Y género (JPQL para colecciones)
    //    Utiliza una query JPQL personalizada para buscar dentro de los Sets.
    @Query("SELECT p FROM Pelicula p JOIN p.moods m JOIN p.genres g WHERE m = :mood AND g = :genre")
    List<Pelicula> findByMoodAndGenre(@Param("mood") String mood, @Param("genre") String genre);

    // Podríamos añadir más métodos si necesitamos combinar otros filtros (director, año, etc.)
    // Ej: List<Pelicula> findByGenresContainingAndDirector(String genre, String director);
}

* c) Nuevo Controlador RecomendacionController.java (Backend - API REST):
  Este nuevo controlador será el punto de entrada para las peticiones de recomendaciones desde el frontend. Recibirá los parámetros del usuario y usará el PeliculaRepository para obtener las películas que coincidan con los criterios.
  // Fichero: src/main/java/com/carteleradecine/controlador/RecomendacionController.java
  // (Ejemplo simplificado)

package com.carteleradecine.controlador;

import com.carteleradecine.modelo.Pelicula;
import com.carteleradecine.repositorio.PeliculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Set; // Para manejar múltiples géneros/moods si es necesario

@RestController
@RequestMapping("/api/recomendaciones") // Endpoint base: /api/recomendaciones
@CrossOrigin(origins = {"http://localhost:8000", "http://127.0.0.1:5500"}) // Permite peticiones desde el frontend
public class RecomendacionController {

    @Autowired
    private PeliculaRepository peliculaRepository;

    @GetMapping // Maneja GET a /api/recomendaciones
    public List<Pelicula> getRecommendations(
        @RequestParam(required = false) String mood,   // Parámetro "mood" (opcional)
        @RequestParam(required = false) String genre) { // Parámetro "genre" (opcional)

        // Lógica simple para llamar al repositorio según los parámetros recibidos
        if (mood != null && genre != null) {
            return peliculaRepository.findByMoodAndGenre(mood, genre);
        } else if (mood != null) {
            return peliculaRepository.findByMoodsContaining(mood);
        } else if (genre != null) {
            return peliculaRepository.findByGenresContaining(genre);
        } else {
            // Si no se especifica nada, podríamos devolver las películas más populares,
            // una lista por defecto, o simplemente todas las películas.
            return peliculaRepository.findAll();
        }
    }
    // Aquí se podrían añadir más métodos para filtros más complejos o combinaciones
}

     * Nota: findByMoodAndGenre en el repositorio asume un mood y genre singular. Si la búsqueda es por múltiples moods o géneros seleccionados por el usuario, la lógica en el controlador y la query en el repositorio serían un poco más complejas (ej. pasando Set<String> y usando @Query con IN).
2.3. Interfaz de Usuario (Frontend HTML/JS con Bootstrap)
* Nuevo HTML (recomendaciones.html): Crearemos una nueva página HTML dedicada a las recomendaciones. Esta página contendrá:
    * Un formulario donde el usuario pueda:
        * Seleccionar su estado de ánimo (usando un <select> con opciones como "Alegre", "Triste", "Emocionado", o botones con iconos de Font Awesome).
        * Aplicar filtros adicionales (ej. géneros, décadas), usando input o select de HTML.
    * Un área donde se mostrarán las películas recomendadas.
* Estilo y Responsividad: Todo el diseño de recomendaciones.html (formularios, botones, la visualización de los resultados) se construirá utilizando las clases de Bootstrap CSS. Esto asegurará una apariencia profesional y que funcione bien en cualquier dispositivo (móvil, tablet, escritorio).
* Comunicación con el Backend: El JavaScript en recomendaciones.html utilizará la función fetch para enviar los filtros seleccionados por el usuario al endpoint /api/recomendaciones del Backend. Cuando reciba la lista de películas, el JavaScript las mostrará dinámicamente en la página.
3. Puntos Obligatorios del Proyecto (Actualizados)
   Esta nueva funcionalidad se integrará respetando los puntos clave de nuestro proyecto:
* Entidades (@Entity): Actor, Pelicula (con los nuevos campos moods y genres), PeliculaActor.
* Asociaciones: ManyToOne y/o OneToMany (ej. en PeliculaActor para el reparto).
* Repositorios: JpaRepository con consultas personalizadas (derivadas o JPQL) para la lógica de búsqueda de recomendaciones.
* Controladores MVC: Directos a repositorios, sin capa de servicios intermedia para simplificar. Incluiremos el nuevo RecomendacionController.
* HTMLs:
    * Páginas de detalle, listado y formulario para cada entidad (Actor, Pelicula, PeliculaActor) con operaciones CRUD.
    * Nueva página recomendaciones.html para la IA.
    * Página de error personalizada y página de inicio personalizada.
* Estilos: Bootstrap CSS y Font Awesome para todos los HTMLs.
* Base de Datos: H2 (en memoria para desarrollo).
* Control de Versiones: Todo el código en la rama main de nuestro repositorio Git/GitHub.
4. Tecnologías y Herramientas del Proyecto (Recap)
* Backend: Java 24, Spring Boot.
* Frontend: HTML, Bootstrap CSS, JavaScript (fetch). (Thymeleaf es opcional si se requiere renderizado del lado del servidor adicional al JS con fetch).
* Base de Datos: H2 (o MySQL si decidimos persistir los datos de forma más robusta).
* IDE de Desarrollo: IntelliJ IDEA.
* Control de Versiones: Git y GitHub.
* Gestión del Proyecto: Reuniones diarias/semanales.
* Integración Continua/Despliegue Continuo (CI/CD): GitHub Actions.
* Documentación y Presentación:
    * Google Slides para la presentación final del proyecto.
    * El archivo SOFT_&_ARCH_DESIGN_CINEMA_PROJECT.md (que contiene este diseño detallado) será la base para el contenido de la presentación y la documentación técnica de referencia.
* Modelado: Se generará un Diagrama UML de clases para visualizar la estructura del proyecto.
  Este enfoque nos permite añadir una funcionalidad de IA muy atractiva de forma incremental, empezando por lo más simple y escalando a futuro.