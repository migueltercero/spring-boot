package es.jccm.curso.spring.boot.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.jccm.curso.spring.boot.dao.TipoViaRepository;
import es.jccm.curso.spring.boot.entity.TipoVia;

@RestController
@RequestMapping("/api/")
public class TipoViaRestController {
	
	@Autowired
	private TipoViaRepository repository;
	
    @GetMapping("/tipovia")
    public ResponseEntity<Iterable<TipoVia>> all() {
        return new ResponseEntity<Iterable<TipoVia>>(repository.findAll(), HttpStatus.OK);
    }
    
    @GetMapping("/tipovia/findByDisplay")
    public ResponseEntity<Iterable<TipoVia>> findByDisplay(@RequestParam("display") String display) {
        return new ResponseEntity<Iterable<TipoVia>>(repository.findByDisplayContainsIgnoreCase(display), HttpStatus.OK);
    }
}
