package es.jccm.curso.spring.boot.view;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class HelloController {
     
    @Value("${foo}")
    private String name;
 
    @GetMapping("/")
    public String whoami() {
        return String.format("foo -> %s", name);
    }
}