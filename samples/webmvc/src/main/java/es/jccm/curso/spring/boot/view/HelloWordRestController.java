package es.jccm.curso.spring.boot.view;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWordRestController {
   
    @GetMapping("/rest")
    public ResponseEntity<String> hello() {
        return new ResponseEntity<String>("Hola rest", HttpStatus.OK);
    }
}
