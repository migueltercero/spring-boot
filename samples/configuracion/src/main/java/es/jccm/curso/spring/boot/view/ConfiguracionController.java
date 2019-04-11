package es.jccm.curso.spring.boot.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import es.jccm.curso.spring.boot.configuration.Configuration;
import es.jccm.curso.spring.boot.configuration.Municipio;
import es.jccm.curso.spring.boot.configuration.Provincia;

@RestController
public class ConfiguracionController {
    @Value("${spring.application.name}")
    private String value;
	
	@Autowired
    private Environment env;
	
	@GetMapping("/value")
    public String value(Model model) {
        return "Hola Mundo "+ value;
    }
	
	@GetMapping("/environment")
    public String environment(Model model) {
        return "Hola Mundo "+ env.getProperty("spring.application.name");
    }
	
	@Autowired 
	private Configuration configuration;
	
	@GetMapping("/provincias")
    public String configuration(Model model) {
        String response = "Provincias:";
		for (Provincia provincia : configuration.getProvincias()) {
        	response += String.format("%s: %s", provincia.getId(), provincia.getDescripcion());
        }
		return response;
    }
	
	@GetMapping("/municipio/toledo")
    public String configuration() {
		Municipio municipio = configuration.getMunicipios().get("toledo");
        return String.format("%s: %s", municipio.getCodigo(), municipio.getDescripcion());

    }
}
