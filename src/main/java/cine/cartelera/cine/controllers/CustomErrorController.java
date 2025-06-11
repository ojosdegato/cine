package cine.cartelera.cine.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {

    @RequestMapping("/error")
    public String handleError() {
        // Esta es la vista de error personalizada
        return "error/error"; // Esta vista se encuentra en /templates/error/error.html
    }


    public String getErrorPath() {
        return "/error";
    }
}
