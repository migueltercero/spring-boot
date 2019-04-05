package es.jccm.curso.spring.boot.view;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import es.jccm.comun.demo.dao.DocumentRepository;
import es.jccm.comun.demo.dto.DocumentDto;
import es.jccm.comun.demo.entity.Document;
import net.rakugakibox.spring.boot.orika.OrikaAutoConfiguration;

@RunWith(SpringRunner.class)
@WebMvcTest(value = DocumentRestController.class, secure = false)
@ImportAutoConfiguration(OrikaAutoConfiguration.class)
public class DocumentRestControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private DocumentRepository<Document> documentRepository;

	@Before
	public void setupMock() throws SQLException {
		List<Document> documents = new ArrayList<Document>();

		// @formatter:off
		documents.add(Document.builder()
								.id(1L)
								.name("documento 1")
							  	.created(new Date())
							  	.build());
		
		documents.add(Document.builder()
								.id(2L)
								.name("documento 2")				
								.created(new Date())
			  					.build());
		
		
		Mockito.when(documentRepository.findAll())
			   .thenReturn(documents);
        // @formatter:on
	}

	@Test
	public void testFindAll() throws Exception {
		// @formatter:off
		this.mvc.perform(get("/api/document"))
					.andExpect(status().isOk())
					.andExpect(header().string("Content-Type", "application/json;charset=UTF-8"))
					.andExpect(jsonPath("$[0].id", is(1)))
					.andExpect(jsonPath("$[0].name", is("documento 1")))
					.andExpect(jsonPath("$[0].created", notNullValue()))
					.andExpect(jsonPath("$[1].id", is(2)))
					.andExpect(jsonPath("$[1].name", is("documento 2")))
					.andExpect(jsonPath("$[1].created", notNullValue()))		
				.andDo(print());
		// @formatter:on
	}

}
