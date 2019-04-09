package es.jccm.curso.spring.boot.view;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.jccm.curso.spring.boot.dto.ProvinciaDto;


@RestController
@RequestMapping("/api/")
public class ProvinciasRestController {


	@RequestMapping("/provincia")
	public ResponseEntity<List<ProvinciaDto>> getAll() {
		List<ProvinciaDto> provincias = new ArrayList<ProvinciaDto>();
		provincias.add(ProvinciaDto.builder().codigo("ab").descripcion("Albacete").build());
		provincias.add(ProvinciaDto.builder().codigo("to").descripcion("Toledo").build());
		
		return new ResponseEntity<>(provincias, HttpStatus.OK);
	}

	

}
