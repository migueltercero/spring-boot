package es.jccm.curso.spring.boot.dao;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import es.jccm.curso.spring.boot.entity.TipoVia;

@RunWith(SpringRunner.class)
@DataJpaTest
public class TipoViaRepositoryTest {

	@Autowired
	private TipoViaRepository repository;

	@Test
	public void testFindAll() {
		Iterable<TipoVia> tipoVias = repository.findAll();

		assertThat(tipoVias).hasSize(42);
	}

	@Test
	public void testFindById() {
		Optional<TipoVia> tipoVia = repository.findById(1L);

		assertThat(tipoVia.get()).isNotNull();
		assertThat(tipoVia.get().getDisplay()).isEqualTo("Alameda");
	}

	@Test
	public void testFindByDisplayContainsIgnoreCase() {
		Iterable<TipoVia> tipoVias = repository.findByDisplayContainsIgnoreCase("ca");

		assertThat(tipoVias).hasSize(8);
	}

}
