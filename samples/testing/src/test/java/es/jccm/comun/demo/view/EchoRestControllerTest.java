package es.jccm.comun.demo.view;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


@RunWith(SpringRunner.class)
@WebMvcTest(value=EchoRestController.class, secure=false)
public class EchoRestControllerTest {
	
	@Autowired
	private MockMvc mvc;
	
	
	@Test
	public void testEcho() throws Exception {
		String echo = "Hello World!!!";
		// @formatter:off
		this.mvc.perform(get("/api/echo/{value}", echo))
					.andExpect(status().isOk())
					.andExpect(content().string(echo))
				.andDo(print());
		// @formatter:on
	}

}
