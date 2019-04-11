package es.jccm.curso.spring.boot.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.jccm.curso.spring.boot.client.ServiceClient;
import es.jccm.curso.spring.boot.dto.ProvinciaDto;

@RestController
public class HomeController {

	@Autowired
	@Lazy
	private DiscoveryClient discoveryClient;
	
	@Autowired
	private ServiceClient serviceClient;
	
	@RequestMapping("/services")
	public List<String> services() {
		return this.discoveryClient.getServices();
	}
	
	@RequestMapping("/name")
	public String name() {
		return String.format("service -> %s", serviceClient.name());
	}
	
	@RequestMapping("/")
	public ResponseEntity<List<ProvinciaDto>> home() {
		return new ResponseEntity<>(serviceClient.provincias(), HttpStatus.OK);
	}

}
