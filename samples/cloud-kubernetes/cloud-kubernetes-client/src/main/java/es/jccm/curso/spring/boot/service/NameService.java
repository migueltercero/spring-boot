package es.jccm.curso.spring.boot.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NameService {

	private final RestTemplate restTemplate;

	public NameService(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@HystrixCommand(fallbackMethod = "getFallbackName", commandProperties = {
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000") })
	public String getName(int delay) {
		return this.restTemplate.getForObject(
				String.format("https://cloud-kubernetes-server/name?delay=%d", delay), String.class);
	}

	@SuppressWarnings("unused")
	private String getFallbackName(int delay) {
		return "Fallback";
	}

}
