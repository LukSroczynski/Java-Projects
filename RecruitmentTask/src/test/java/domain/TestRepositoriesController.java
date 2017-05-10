package domain;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Created by Lukasz S. on 09.05.2017.
 */

public class TestRepositoriesController extends TestApplication {

	@Autowired
	private WebApplicationContext webApplicationContext;
 
	private MockMvc mockMvc;

	@Before
	public void setup() {

		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
				.build();
	}

	@Test
	public void validateRepositoryDetails() throws Exception {

		mockMvc.perform(get("/repositories/lukSroczynski/Blog"))
				.andExpect(status().isOk())
				.andExpect(
						content().contentType("application/json;charset=UTF-8"))
				.andExpect(jsonPath("$.full_name").value("LukSroczynski/Blog"))
				.andExpect(jsonPath("$.description").value("Blog - template"))
				.andExpect(jsonPath("$.clone_url").value("https://github.com/LukSroczynski/Blog.git"))
				.andExpect(jsonPath("$.stargazers_count").value("0"))
				.andExpect(jsonPath("$.created_at").value("2016-11-06"));

	}
}