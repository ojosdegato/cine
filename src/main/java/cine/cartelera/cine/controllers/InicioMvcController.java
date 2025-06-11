package cine.cartelera.cine.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioMvcController {

    // Ruta para acceder a la página de inicio
    @GetMapping("/inicio/start")
    public String mostrarInicio() {
        return "inicio/start"; // Esto va a buscar templates/inicio/start.html
    }
}
