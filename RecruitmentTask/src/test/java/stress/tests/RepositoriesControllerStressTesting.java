package stress.tests;

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
import domain.Application;

import static com.jayway.restassured.RestAssured.when;

/**
 * Created by Lukasz S. on 09.05.2017.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class RepositoriesControllerStressTesting {

    @Value("${local.server.port}")
    private int port;

    private final String TEST_VALID_URL = "/repositories/lukSroczynski/Blog";

    @Before
    public void setUp() {
        RestAssured.port = port;
    }

    @Test
    public void validateQuotaExceeded() {

        for(int i = 0; i < 100; i++) {
            when().get(TEST_VALID_URL);
        }

        when().
                get(TEST_VALID_URL).
                then().
                body("message", Matchers.is("403 Forbidden"));
    }
}