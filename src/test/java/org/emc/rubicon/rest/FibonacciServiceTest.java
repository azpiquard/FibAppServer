package org.emc.rubicon.rest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.emc.rubicon.rest.entity.FibonacciResult;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

/**
 * Created 3/15/2018 Test Fibonacci Algorithm
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(SampleActuatorApplication.class)
@WebIntegrationTest(randomPort = true)
@DirtiesContext
public class FibonacciServiceTest {
    @Autowired
    private SecurityProperties security;
    String username;
    String password;
    TestRestTemplate template;
    @Value("${local.server.port}")
    private int port;

    @Before
    public void before(){
        username = security.getUser().getName();
        password = security.getUser().getPassword();
        template = new TestRestTemplate(username, password);
    }

    @Test
    public void testNegativeNumber() {
        int num = -1;
        ResponseEntity<FibonacciResult> entity = template.getForEntity( getUrl(num), FibonacciResult.class);
        assertEquals("Failed to verify HTTP status code", HttpStatus.BAD_REQUEST, entity.getStatusCode());

    }

    @Test
    public void testZero() {
        int num = 0;
        ResponseEntity<FibonacciResult> entity = template.getForEntity( getUrl(num), FibonacciResult.class);
        assertEquals("Failed to verify HTTP status code", HttpStatus.BAD_REQUEST, entity.getStatusCode());
    }

    @Test
    public void testOne() {
        String[] expected = {"0"};
        int num = 1;
        ResponseEntity<FibonacciResult> entity = template.getForEntity( getUrl(num), FibonacciResult.class);
        assertEquals("Failed to verify HTTP status code", HttpStatus.OK, entity.getStatusCode());
        FibonacciResult body = entity.getBody();
        assertEquals("Failed to verify number", num, Integer.parseInt(body.getNumber()));
        assertArrayEquals("", expected, body.getArray());
    }

    @Test
    public void testFibonacci() {

        String[] expected = {"0","1","1","2","3","5","8","13","21","34"};
        int num = 10;
        ResponseEntity<FibonacciResult> entity = template.getForEntity( getUrl(num), FibonacciResult.class);
        assertEquals("Failed to verify HTTP status code", HttpStatus.OK, entity.getStatusCode());
        FibonacciResult body = entity.getBody();
        assertEquals("Failed to verify number", num, Integer.parseInt(body.getNumber()));
        assertArrayEquals("", expected, body.getArray());
    }

    private String getUrl(int num) {
        return "http://localhost:" + this.port + "/fibonacci?num=" + num;
    }

}
