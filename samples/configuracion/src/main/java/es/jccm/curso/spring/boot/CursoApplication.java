package es.jccm.curso.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import es.jccm.curso.spring.boot.configuration.Configuration;

@SpringBootApplication
@EnableConfigurationProperties(Configuration.class)
public class CursoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CursoApplication.class, args);
	}

}
