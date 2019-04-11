package es.jccm.curso.spring.boot.configuration;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@ConfigurationProperties(prefix="jccm")
@Data
public class Configuration {
	List<Provincia> provincias;

	Map<String, Municipio> municipios;
	
	
	
}
