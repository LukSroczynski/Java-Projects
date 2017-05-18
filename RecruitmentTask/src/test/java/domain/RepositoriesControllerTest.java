package domain;

import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;

import org.junit.runner.RunWith;
import org.junit.Before;
import org.junit.Test;

import com.jayway.restassured.RestAssured;
import org.hamcrest.Matchers;

import static com.jayway.restassured.RestAssured.when;
import static org.hamcrest.Matchers.lessThan;

/**
 * Created by Lukasz S. on 09.05.2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class RepositoriesControllerTest {

    @Value("${local.server.port}")
    private int port;

    private final String TEST_VALID_URL = "/repositories/lukSroczynski/Blog";

    private final String TEST_INVALID_URL = "2q4r6tbv8h0rt9h75g5d3f1qw";

    private final Long MAX_RESPONSE_TIME = 7000L;

    @Before
    public void setUp() {
        RestAssured.port = port;
    }

    @Test
    public void validateRepositoryDetails() {

        when().
                get(TEST_VALID_URL).
                then().
                statusCode(200).
                body("full_name", Matchers.is("LukSroczynski/Blog")).
                body("description", Matchers.is("Blog - template")).
                body("clone_url", Matchers.is("https://github.com/LukSroczynski/Blog.git")).
                body("stargazers_count", Matchers.is("0")).
                body("created_at", Matchers.is("2016-11-06"));

    }

    @Test
    public void validateResponseTime() {

        when().
                get(TEST_VALID_URL).
                then().
                statusCode(200).
                time(lessThan(MAX_RESPONSE_TIME));

    }

    @Test
    public void validateInvalidUrl() {

        when().
                get(TEST_INVALID_URL).
                then().
                statusCode(404);

    }
}