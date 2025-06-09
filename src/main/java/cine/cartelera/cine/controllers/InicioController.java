package cine.cartelera.cine.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioController {


    @GetMapping({"/"}) // http://localhost:8081/index
    public String inicio() {
        return "/index"; // nombre archivo html (index.html)
    }


}
