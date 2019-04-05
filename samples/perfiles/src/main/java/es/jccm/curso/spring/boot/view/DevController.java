package es.jccm.curso.spring.boot.view;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Profile("dev")
@RestController
public class DevController {
    
	@Value("${spring.application.name}")
	String value;
    
	@GetMapping("/dev")
    public ResponseEntity<String> hello() {
        return new ResponseEntity<String>("Dev active", HttpStatus.OK);
    }
}
