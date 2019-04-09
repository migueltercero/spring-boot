package es.jccm.curso.spring.boot.view;

import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class HelloController {
   
    @GetMapping("/")
    public ResponseEntity<String> hello(@RequestParam("id") @NotNull String id) {
        log.info("invocando hello");
    	return new ResponseEntity<String>("Hola Mundo!!!", HttpStatus.OK);
    }
}
