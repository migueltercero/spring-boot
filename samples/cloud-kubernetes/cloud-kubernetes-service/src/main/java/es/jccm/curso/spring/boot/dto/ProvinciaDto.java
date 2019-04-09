package es.jccm.curso.spring.boot.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProvinciaDto {

	private String codigo;
	
	private String descripcion;
}
