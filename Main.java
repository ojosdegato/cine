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
		ApplicationContext context = SpringApplication.run(Main.class, args);

		// Obtener el repositorio desde el contexto
		PeliculaRepository peliculaRepository = context.getBean(PeliculaRepository.class);

		// Crear películas de prueba
		Pelicula pelicula1 = new Pelicula("El señor de los anillos", "Aventura", 120, 12,
				"Aventura y ficción", "https://youtube.com/ver_trailer1");

		Pelicula pelicula2 = new Pelicula("Troya", "Historia", 130, 16,
				"Aventura histórica con batallas épicas", "https://youtube.com/ver_trailer2");

		Pelicula pelicula3 = new Pelicula("Gladiator", "Acción", 150, 18,
				"Un general romano busca venganza", "https://youtube.com/ver_trailer3");

		Pelicula pelicula4 = new Pelicula("Piratas del Caribe", "Aventura", 145, 12,
				"Un pirata busca el tesoro perdido", "https://youtube.com/ver_trailer4");

		Pelicula pelicula5 = new Pelicula("Inception", "Ciencia Ficción", 148, 16,
				"Un ladrón experto en robar secretos viaja en el sueño", "https://youtube.com/ver_trailer5");

		Pelicula pelicula6 = new Pelicula("The Matrix", "Ciencia Ficción", 136, 18,
				"Un hacker descubre la verdad detrás de la realidad virtual", "https://youtube.com/ver_trailer6");

		Pelicula pelicula7 = new Pelicula("The Dark Knight", "Acción", 152, 16,
				"Batman enfrenta al Joker, el villano más peligroso", "https://youtube.com/ver_trailer7");

		Pelicula pelicula8 = new Pelicula("Forrest Gump", "Drama", 142, 12,
				"La vida de un hombre con una inteligencia limitada, pero una gran suerte", "https://youtube.com/ver_trailer8");

		Pelicula pelicula9 = new Pelicula("The Lion King", "Animación", 88, 0,
				"Un joven león aprende a enfrentar su destino", "https://youtube.com/ver_trailer9");

		Pelicula pelicula10 = new Pelicula("Avengers: Endgame", "Acción", 181, 12,
				"Los héroes más poderosos del mundo luchan para salvar al universo", "https://youtube.com/ver_trailer10");

// Insertar las películas en la base de datos
		peliculaRepository.saveAll(List.of(pelicula1, pelicula2, pelicula3, pelicula4, pelicula5,
				pelicula6, pelicula7, pelicula8, pelicula9, pelicula10));


		System.out.println("🎬 Películas insertadas correctamente en la base de datos H2.");
	}

}
