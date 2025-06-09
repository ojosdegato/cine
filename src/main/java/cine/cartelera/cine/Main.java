package cine.cartelera.cine;

import cine.cartelera.cine.entities.Pelicula;
import cine.cartelera.cine.repositories.PeliculaRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class Main {

	public static void main(String[] args) {

		// Iniciar el contexto de Spring
		ApplicationContext context = SpringApplication.run(CineApplication.class, args);

		// Obtener el repositorio desde el contexto
		PeliculaRepository peliculaRepository = context.getBean(PeliculaRepository.class);

		// Crear películas de prueba
		Pelicula pelicula1 = new Pelicula("El señor de los anillos", "Aventura", 120, 12,
				"Aventura y ficción", "https://youtube.com/ver_trailer1");

		Pelicula pelicula2 = new Pelicula("Troya", "Historia", 130, 16,
				"Aventura histórica con batallas épicas", "https://youtube.com/ver_trailer2");

		Pelicula pelicula3 = new Pelicula("Gladiator", "Acción", 150, 18,
				"Un general romano busca venganza", "https://youtube.com/ver_trailer3");

		// Insertar las películas en la base de datos
		peliculaRepository.saveAll(List.of(pelicula1, pelicula2, pelicula3));

		System.out.println("🎬 Películas insertadas correctamente en la base de datos H2.");
	}

}
