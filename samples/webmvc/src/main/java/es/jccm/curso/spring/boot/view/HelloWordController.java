package es.jccm.curso.spring.boot.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWordController {
   
    @GetMapping("/mvc")
    public String hello(Model model) {
        return "home";
    }
    
    @GetMapping("/webjars")
    public String webjars(Model model) {
        return "webjars";
    }
}
