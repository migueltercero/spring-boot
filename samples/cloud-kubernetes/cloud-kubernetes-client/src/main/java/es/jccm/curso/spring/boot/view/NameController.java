package es.jccm.curso.spring.boot.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import es.jccm.curso.spring.boot.client.ServiceClient;

@RestController
public class NameController {

	@Autowired
	@Lazy
	private DiscoveryClient discoveryClient;
	
	
	@LoadBalanced
	private RestTemplate restTemplate;
	
	@Autowired
	private ServiceClient client;
	
	@RequestMapping("/services")
	public List<String> services() {
		return this.discoveryClient.getServices();
	}
	
	@RequestMapping("/name")
	public String name() {
		return client.name();
	}
	
	

}
