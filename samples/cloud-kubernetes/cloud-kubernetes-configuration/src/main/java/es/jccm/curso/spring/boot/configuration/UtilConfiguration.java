package es.jccm.curso.spring.boot.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Configuration
@Slf4j
public class UtilConfiguration {

	@Autowired
	private Config config;
	
	@Bean
	@RefreshScope
	public Util util() {
		log.info(String.format("recreando bean: message -> %s", config.getMessage()));
		return new Util(config.getMessage());
	}
	
	@Data
	@AllArgsConstructor
	public class Util {
		private String message;
		
		public String echo() {
			return message;
		}
		
	}
}
