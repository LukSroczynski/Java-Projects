package domain;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import io.restassured.RestAssured;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.beans.factory.annotation.Autowired;

import org.junit.Before;
import org.junit.Test;

/**
 * Created by Lukasz S. on 09.05.2017.
 */

public class TestRepositoriesController extends TestApplication {

	@Autowired
	private WebApplicationContext webApplicationContext;
 
	private MockMvc mockMvc;

	private MockRestServiceServer mockRestServiceServer;

	private final String test_url = "/repositories/lukSroczynski/Blog";

	@Before
	public void setup() {

//		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
//				.build();
	}

	@Test
	public void validateRepositoryDetails()  {

		try {

			MvcResult mvcResult = mockMvc.perform(get(test_url))
					.andExpect(status().isOk())
					.andExpect(
							content().contentType("application/json;charset=UTF-8"))
					.andExpect(jsonPath("$.full_name").value("LukSroczynski/Blog"))
					.andExpect(jsonPath("$.description").value("Blog - template"))
					.andExpect(jsonPath("$.clone_url").value("https://github.com/LukSroczynski/Blog.git"))
					.andExpect(jsonPath("$.stargazers_count").value("0"))
					.andExpect(jsonPath("$.created_at").value("2016-11-06"))
					.andReturn();

			int response = mvcResult.getResponse().getStatus();

			System.out.println(response);

		} catch (HttpClientErrorException e) {
			System.out.println("Hello");
		} catch (Exception e) {
			e.getMessage();
		}
	}

	@Test
	public void validateResponseTime() throws Exception {

		long timeInMs = RestAssured.get(test_url).time();

	}
}