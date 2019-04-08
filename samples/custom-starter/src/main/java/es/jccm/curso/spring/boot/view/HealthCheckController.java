package es.jccm.curso.spring.boot.view;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path="/test")
public class HealthCheckController {

	@GetMapping("/test.jsp")
	public String healthCheck(Model model) throws Exception {
    	return "serviciooperativo";
    }

}