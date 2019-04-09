package es.jccm.curso.spring.boot.view;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import es.jccm.curso.spring.boot.service.NameService;

@RestController
public class HelloController {

	private final NameService nameService;

	public HelloController(NameService nameService) {
		this.nameService = nameService;
	}

	@RequestMapping("/hello")
	public String getGreeting(
			@RequestParam(value = "delay", defaultValue = "0") int delay) {
		return String.format("Hello from %s!", this.nameService.getName(delay));
	}

}
