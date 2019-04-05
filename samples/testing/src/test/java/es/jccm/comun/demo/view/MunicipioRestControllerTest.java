package es.jccm.comun.demo.view;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import es.jccm.comun.demo.dao.MunicipioRepository;
import es.jccm.comun.demo.entity.Municipio;


@RunWith(SpringRunner.class)
@WebMvcTest(secure=false) //JndiDataSourceAutoConfiguration
public class MunicipioRestControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
    private MunicipioRepository municipioRepository;
	
	
	@Before
    public void setupMock() throws SQLException {
		//when(entityManager.getMetamodel()).thenReturn(mock(MetamodelImpl.class));
		
		// @formatter off
		Mockito.when(municipioRepository.findAll())
			   .thenReturn(new ArrayList<Municipio>());
        // @formatter on
    }
	
	@Test
	public void testLoadContext() {
		
	}
	
	@Test
	public void test() throws Exception {
		// @formatter off
		this.mvc.perform(get("/api/"))
				.andExpect(status().isOk())
				.andExpect(content().string("Hello World"));
		// @formatter on
	}

}
