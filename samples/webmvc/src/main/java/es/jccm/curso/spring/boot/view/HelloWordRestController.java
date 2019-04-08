package es.jccm.curso.spring.boot.view;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class HelloWordRestController {
   
    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return new ResponseEntity<String>("Hola rest", HttpStatus.OK);
    }
    
    @GetMapping("/object")
    public ResponseEntity<List<MyObject>> object() {
    	List<MyObject> objects = new ArrayList();
    	MyObject object1 = new MyObject();
    	object1.setId(1);
    	object1.setDescription("object 1");
    	
    	MyObject object2 = new MyObject();
    	object2.setId(2);
    	object2.setDescription("object 2");
    	
    	objects.add(object1);
    	objects.add(object2);
    	
        return new ResponseEntity<>(objects, HttpStatus.OK);
    }
    
    
    class MyObject {
    	int id;
    	String description;
		
    	public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		} 	
    }
}
