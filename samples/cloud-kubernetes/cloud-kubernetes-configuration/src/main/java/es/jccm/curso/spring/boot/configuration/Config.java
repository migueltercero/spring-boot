package es.jccm.curso.spring.boot.configuration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@ConfigurationProperties(prefix = "jccm")
@Data
public class Config {

	private String message;

	
}