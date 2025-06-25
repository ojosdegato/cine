package cine.cartelera.cine.controllers;

import cine.cartelera.cine.entities.Pelicula;
import cine.cartelera.cine.services.BuscarServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BuscarController {

    @Autowired
    private BuscarServices buscarServices;

    @GetMapping("/peliculas/buscar")
    public String buscarPorGenero(@RequestParam(required = false) String genero, Model model) {
        List<Pelicula> peliculas = buscarServices.buscarPorGenero(genero);
        model.addAttribute("peliculas", peliculas);
        model.addAttribute("generoBuscado", genero);
        return "peliculas/buscar";
    }
}
