package es.jccm.curso.spring.boot.view;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
   
    @GetMapping("/")
    public String hello(Model model) {
        return "Hola Mundo!!";
    }
}
