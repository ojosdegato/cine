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

	}
}

