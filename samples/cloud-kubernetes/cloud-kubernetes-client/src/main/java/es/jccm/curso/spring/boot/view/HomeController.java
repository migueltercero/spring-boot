package es.jccm.curso.spring.boot.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import es.jccm.curso.spring.boot.client.NameClient;
import es.jccm.curso.spring.boot.client.ProvinciaClient;
import es.jccm.curso.spring.boot.dto.ProvinciaDto;

@RestController
public class NameController {

	@Autowired
	@Lazy
	private DiscoveryClient discoveryClient;
	
	
	@LoadBalanced
	private RestTemplate restTemplate;
	
	@Autowired
	private NameClient nameClient;
	
	@Autowired
	private ProvinciaClient provinciaClient;
	
	@RequestMapping("/services")
	public List<String> services() {
		return this.discoveryClient.getServices();
	}
	
	@RequestMapping("/name")
	public String name() {
		return String.format("service -> %s", nameClient.name());
	}
	
	@RequestMapping("/")
	public ResponseEntity<List<ProvinciaDto>> home() {
		return new ResponseEntity<>(provinciaClient.provincias(), HttpStatus.OK);
	}

}
