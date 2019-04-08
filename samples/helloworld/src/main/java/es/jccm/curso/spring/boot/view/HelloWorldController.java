package es.jccm.curso.spring.boot.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import es.jccm.curso.spring.boot.configuration.UtilConfiguration;

@RestController
public class HelloWorldController {
   
	@Autowired
	UtilConfiguration.Util util;
	
    @GetMapping("/")
    public String hello(Model model) {
        return util.echo("Hello world!!!");
    }
}
