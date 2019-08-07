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
public class HashTest {

    @Before
    public void setUp() throws Exception {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
    }


    @Test
    public void test_1() {
        final Programmer programmer = new Programmer();
        programmer.setId(2);
        programmer.setName("Chacha");
        programmer.setCompany("AMZ");


        final Response response = given()
                .accept("application/json")
                .contentType("application/json")
                .body(programmer)
                .when()
                .post("/jedis/prog-hash")
                .then()
                .statusCode(200)
                .extract()
                .response();

        System.out.println(response.asString());

    }

    @Test
    public void test_getFromHash() {
        final Response response = given()
                .when()
                .get("/jedis/prog-hash/2")
                .then()
                .extract()
                .response();

        System.out.println(response.asString());
    }


}
