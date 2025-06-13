package cine.cartelera.cine;

import cine.cartelera.cine.entities.*;
import cine.cartelera.cine.repositories.*;
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
		 ActorRepository actorRepository = context.getBean(ActorRepository.class);
		 PeliculaActorRepository peliculaActorRepository = context.getBean(PeliculaActorRepository.class);
		 ProyeccionRepository proyeccionRepository = context.getBean(ProyeccionRepository.class);
		 SalaRepository salaRepository = context.getBean(SalaRepository.class);
		 TicketRepository ticketRepository = context.getBean(TicketRepository.class);

	}
}

