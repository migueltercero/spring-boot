package es.jccm.curso.spring.boot.view;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class CacheableController {
   
    @GetMapping("/")
    @Cacheable("hello")
    public ResponseEntity<String> hello() {
        log.info("invocando sin cache");
    	return new ResponseEntity<String>("Hola Mundo!!!", HttpStatus.OK);
    }
}
