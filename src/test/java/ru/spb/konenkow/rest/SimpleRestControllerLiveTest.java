package ru.spb.konenkow.rest;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import static junit.framework.TestCase.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfig.class}, loader = AnnotationConfigContextLoader.class)
public class SimpleRestControllerLiveTest {
    private static final String URL_PREFIX = "http://localhost:8080";

    private String cookie;

    private RequestSpecification givenAuth() {
        if (cookie == null) {
            cookie = RestAssured.given().contentType("application/x-www-form-urlencoded").formParam("password", "user").formParam("username", "user").post(URL_PREFIX + "/login").getCookie("JSESSIONID");
        }
        return RestAssured.given().cookie("JSESSIONID", cookie);
    }

    @Test
    public void whenTry_thenOK() {
        final Response response = givenAuth().get(URL_PREFIX + "/rest/hello?name=world");
        assertEquals(200, response.statusCode());
    }


}