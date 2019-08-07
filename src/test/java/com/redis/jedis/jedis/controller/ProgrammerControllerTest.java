package com.redis.jedis.jedis.controller;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import com.redis.jedis.jedis.model.Programmer;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProgrammerControllerTest {

    @Before
    public void setUp() throws Exception {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
    }

    @Test
    public void a() {
        final Programmer programmer = new Programmer();
        programmer.setId(2);
        programmer.setName("Atul");
        programmer.setCompany("paypal");
        final Response response = given()
                .accept("application/json")
                .contentType("application/json")
                .body(programmer)
                .when()
                .post("/jedis")
                .then()
                .statusCode(200)
                .extract().response();


    }

    @Test
    public void b() {
        final Programmer programmer = new Programmer();
        programmer.setId(2);
        programmer.setName("Atul");
        programmer.setCompany("paypal");
        final Response response = given()
                .accept("application/json")
                .when()
                .get("/jedis/2")
                .then()
                .statusCode(200)
                .extract().response();

        System.out.println(response.asString());


    }


}