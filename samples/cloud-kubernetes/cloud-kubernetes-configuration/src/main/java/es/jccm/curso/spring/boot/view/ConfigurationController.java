package es.jccm.curso.spring.boot.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.jccm.curso.spring.boot.configuration.Config;
import es.jccm.curso.spring.boot.configuration.UtilConfiguration;
import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
public class ConfigurationController {

	@Autowired
	private Config config;
	
	@Autowired
	private UtilConfiguration.Util util;

	@RequestMapping("/")
	public String config() {
		log.info(config.getMessage());
		return config.getMessage();
	}
	
	@RequestMapping("/util")
	public String util() {
		log.info(config.getMessage());
		return String.format("message desde util -> %s", util.echo());
	}
}
