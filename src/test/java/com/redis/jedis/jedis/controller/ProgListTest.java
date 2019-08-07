package com.redis.jedis.jedis.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import java.lang.reflect.Type;
import java.util.List;
import com.redis.jedis.jedis.model.Programmer;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProgListTest {

    @Before
    public void setUp() throws Exception {
        RestAssured.baseURI ="http://localhost";
        RestAssured.port = 8080;
    }

    @Test
    public void test() {

        final Programmer programmer = new Programmer();
        programmer.setId(8);
        programmer.setName("Chacha");
        programmer.setCompany("AMZ");

        final Response response = given()
                .accept("application/json")
                .contentType("application/json")
                .body(programmer)
                .when()
                .post("/jedis/prog-list")
                .then()
                .statusCode(200)
                .extract()
                .response();

        System.out.println(response.asString());
    }

    @Test
    public void test_getProgrammers() {

        final Response response = given()
                .accept("application/json")
                .when()
                .get("/jedis/prog-list")
                .then()
                .statusCode(200)
                .extract()
                .response();

        System.out.println(response.asString());
    }

    @Test
    public void test_count() {

        final Response response = given()
                .accept("application/json")
                .when()
                .get("/jedis/prog-list/count")
                .then()
                .extract()
                .response();

        System.out.println(response.asString());
    }
}
