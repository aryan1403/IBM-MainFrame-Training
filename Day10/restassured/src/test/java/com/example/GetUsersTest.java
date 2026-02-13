package com.example;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetUsersTest extends BaseTest {

    @Test(groups = {"smoke", "regression"})
    public void getDefaultUser() {
        given()
            .header("User-Agent", "Mozilla/5.0")
            .accept("application/json")
        .when()
            .get("/")
        .then()
            .statusCode(200)
            .contentType("application/json")
            .body("data", equalTo("Hello, Guest!"));
    }

    @Test(groups = {"regression"})
    public void getUserWithName() {
        given()
            .queryParam("name", "Aryan")
            .header("User-Agent", "Mozilla/5.0")
        .when()
            .get("/")
        .then()
            .statusCode(200)
            .body("data", equalTo("Hello, Aryan!"));
    }

    @Test(groups = {"regression"})
    public void validateResponseTime() {
        given()
        .when()
            .get("/")
        .then()
            .time(lessThan(2000L));
    }

    @Test(groups = {"negative"})
    public void invalidEndpoint() {
        given()
        .when()
            .get("/invalid")
        .then()
            .statusCode(404);
    }
}
