package es.jccm.curso.spring.boot.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class TipoVia {
    
	@Id
    private String code;

    private String display;

}
