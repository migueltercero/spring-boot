package es.jccm.curso.spring.boot.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import es.jccm.curso.spring.boot.entity.TipoVia;

@Repository
public interface TipoViaRepository extends PagingAndSortingRepository<TipoVia, String> {
	Iterable<TipoVia> findByDisplayContainsIgnoreCase(@Param("display") String display);
}