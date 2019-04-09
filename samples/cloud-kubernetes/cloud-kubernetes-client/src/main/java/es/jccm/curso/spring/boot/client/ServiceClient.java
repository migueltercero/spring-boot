package es.jccm.curso.spring.boot.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "cloud-kubernetes-service")
public interface ServiceClient {
	
	@GetMapping("/name")
    public String name();

}
