package es.jccm.curso.spring.boot.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.jccm.curso.spring.boot.configuration.MyConfig;
import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
public class HelloController {

	@Autowired
	private MyConfig myConfig;

	@RequestMapping("/")
	public String ribbonPing() {
		log.info(myConfig.getMessage());
		return myConfig.getMessage();
	}
	
}
