package es.jccm.curso.spring.boot.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UtilConfiguration {

	@Bean
	public Util util() {
		return new Util();
	}
	
	public class Util {
		public String echo(String echo) {
			return String.format("echo -> %s", echo);
		}
		
	}
}
