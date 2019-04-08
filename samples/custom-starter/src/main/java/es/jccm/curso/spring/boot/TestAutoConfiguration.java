package es.jccm.curso.spring.boot;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import es.jccm.curso.spring.boot.view.HealthCheckController;

@Configuration
@ComponentScan(basePackageClasses = HealthCheckController.class)
public class TestAutoConfiguration {

	
}