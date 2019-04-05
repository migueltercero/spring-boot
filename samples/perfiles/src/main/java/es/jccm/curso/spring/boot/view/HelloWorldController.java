package es.jccm.curso.spring.boot.view;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    
	@Value("${spring.application.name}")
	String value;
    
	@GetMapping("/")
    public ResponseEntity<String> hello() {
        return new ResponseEntity<String>("Perfil: " + value, HttpStatus.OK);
    }
}
