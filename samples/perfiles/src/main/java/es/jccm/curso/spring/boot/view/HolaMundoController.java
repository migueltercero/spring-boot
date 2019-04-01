package es.jccm.curso.spring.boot.view;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Profile("dev")
@RestController
public class HolaMundoController {
    
	@Value("${spring.application.name}")
	String value;
    
	@GetMapping("/")
    public String hello(Model model) {
        return "Hola Mundo!!! " + value;
    }
}
