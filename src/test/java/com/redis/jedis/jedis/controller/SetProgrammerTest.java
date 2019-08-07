package com.redis.jedis.jedis.controller;

import static io.restassured.RestAssured.given;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import com.redis.jedis.jedis.model.Programmer;
import io.restassured.RestAssured;
import io.restassured.response.Response;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SetProgrammerTest {

    @Before
    public void setUp() throws Exception {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
    }

    @Test
    public void test_1() {

        List<Programmer> programmers = new ArrayList<>();

        final Programmer programmer = new Programmer();
        programmer.setId(8);
        programmer.setName("Chacha");
        programmer.setCompany("AMZ");

        final Programmer programme2 = new Programmer();
        programmer.setId(3);
        programmer.setName("OChahch");
        programmer.setCompany("Zinx");

        programmers.add(programmer);
        programmers.add(programme2);


        final Response response = given()
                .accept("application/json")
                .contentType("application/json")
                .body(programmers)
                .when()
                .post("/jedis/prog-set")
                .then()
                .statusCode(200)
                .extract()
                .response();

        System.out.println(response.asString());

    }

    @Test
    public void test_GetSEt() {

        final Response response = given()
                .accept("application/json")
                .when()
                .get("/jedis/prog-set")
                .then()
                .statusCode(200)
                .extract()
                .response();

        System.out.println(response.asString());
    }

    @Test
    public void test_isMember() {

        final Programmer programmer = new Programmer();
        programmer.setId(8);
        programmer.setName("Chacha");
        programmer.setCompany("AMZ");

        final Response response = given()
                .contentType("application/json")
                .when()
                .body(programmer)
                .post("/jedis/prog-set/ism")
                .then()
                .statusCode(200)
                .extract()
                .response();
        System.out.println(response.asString());
    }
}
