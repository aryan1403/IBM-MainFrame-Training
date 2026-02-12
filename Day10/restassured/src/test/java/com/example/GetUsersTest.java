package com.example;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class GetUsersTest extends BaseTest {

    @Test
    public void getUsers() {
        given()
            .header("User-Agent", "Mozilla/5.0")
            .accept("application/json")
        .when()
            .get("/")
        .then()
            .statusCode(200)
            .body("data", equalTo("Hello, Guest!")); //data: Hello Guest!
    }
}
