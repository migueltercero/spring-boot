package es.jccm.curso.spring.boot.view;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import es.jccm.curso.spring.boot.dao.TipoViaRepository;
import es.jccm.curso.spring.boot.entity.TipoVia;

@RunWith(SpringRunner.class)
@WebMvcTest(value = TipoViaRestController.class)
public class TipoViaRestControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private TipoViaRepository repository;

	@Before
	public void setupMock() throws SQLException {
		List<TipoVia> TipoVias = new ArrayList<TipoVia>();

		// @formatter:off
		TipoVias.add(TipoVia.builder()
								.code(1L)
								.display("Calle")
							  	.created(new Date())
							  	.build());
		
		TipoVias.add(TipoVia.builder()
								.code(2L)
								.display("Avenida")				
								.created(new Date())
			  					.build());
		
		
		Mockito.when(repository.findAll())
			   .thenReturn(TipoVias);
        // @formatter:on
	}

	@Test
	public void testFindAll() throws Exception {
		// @formatter:off
		this.mvc.perform(get("/api/tipovia"))
					.andExpect(status().isOk())
					.andExpect(header().string("Content-Type", "application/json;charset=UTF-8"))
					.andExpect(jsonPath("$[0].code", is(1)))
					.andExpect(jsonPath("$[0].display", is("Calle")))
					.andExpect(jsonPath("$[0].created", notNullValue()))
					.andExpect(jsonPath("$[1].code", is(2)))
					.andExpect(jsonPath("$[1].display", is("Avenida")))
					.andExpect(jsonPath("$[1].created", notNullValue()))		
				.andDo(print());
		// @formatter:on
	}

}
