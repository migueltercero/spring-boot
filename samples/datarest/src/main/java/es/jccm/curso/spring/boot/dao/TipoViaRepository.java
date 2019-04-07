package es.jccm.curso.spring.boot.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import es.jccm.curso.spring.boot.entity.TipoVia;

@RepositoryRestResource(collectionResourceRel = "tipoVia", path = "tipoVia")
public interface TipoViaRepository extends PagingAndSortingRepository<TipoVia, Long> {
	Iterable<TipoVia> findByDisplayContainsIgnoreCase(@Param("display") String display);
}