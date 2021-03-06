package es.jccm.curso.spring.boot.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import es.jccm.curso.spring.boot.dto.ProvinciaDto;

@FeignClient(name = "cloud-kubernetes-service")
public interface ServiceClient {
	
	@GetMapping("/name")
    public String name();
	
	@GetMapping("/api/provincia")
    public List<ProvinciaDto> provincias();

}
