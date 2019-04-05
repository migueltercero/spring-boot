package es.jccm.comun.demo.view;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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

import es.jccm.comun.demo.dao.TipoViaRepository;
import es.jccm.comun.demo.entity.TipoVia;


@RunWith(SpringRunner.class)
@WebMvcTest(value=HomeController.class, secure=false) //JndiDataSourceAutoConfiguration
public class HomeControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
    private TipoViaRepository tipoViaRepository;
	
	
	@Before
    public void setupMock() throws SQLException {
		//when(entityManager.getMetamodel()).thenReturn(mock(MetamodelImpl.class));
		
		// @formatter off
		Mockito.when(tipoViaRepository.findAll())
			   .thenReturn(new ArrayList<TipoVia>());
        // @formatter on
    }
	
	@Test
	public void testLoadContext() {
		
	}
	
	@Test
	public void test() throws Exception {
		// @formatter off
		this.mvc.perform(get("/"))
					.andExpect(status().isOk())
					.andExpect(forwardedUrl("/home"))
				.andDo(print());
		// @formatter on
		//this.mvc.perform(get("/home"))
		//		.andExpect(status().isOk())
		//		.andExpect(content().string("aaa")); 
	}

}
