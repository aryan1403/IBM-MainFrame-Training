package com.example;

import com.example.POJO.LoginRequest;
import com.example.POJO.LoginResponse;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class LoginTest extends BaseTest {

    @Test(groups = {"smoke", "login"})
    public void loginSuccessUsingPojo() {
        LoginRequest request = new LoginRequest("test@example.com", "password123");

        LoginResponse response =
            given()
                .contentType("application/json")
                .body(request)
            .when()
                .post("/login")
            .then()
                .statusCode(200)
                .extract()
                .as(LoginResponse.class);

        assertThat(response.getMessage(), equalTo("Login successful"));
        assertThat(response.getEmail(), equalTo("test@example.com"));
        assertThat(response.getPassword(), equalTo("password123"));
    }

    @Test(groups = {"login", "negative"})
    public void loginWithoutPassword() {
        LoginRequest request =
                new LoginRequest("test@example.com", null);

        LoginResponse response =
            given()
                .contentType("application/json")
                .body(request)
            .when()
                .post("/login")
            .then()
                .statusCode(200)
                .extract()
                .as(LoginResponse.class);

        assertThat(response.getPassword(), nullValue());
    }

    @Test(groups = {"login", "negative"})
    public void loginWithoutEmail() {
        LoginRequest request =
                new LoginRequest(null, "password123");

        LoginResponse response =
            given()
                .contentType("application/json")
                .body(request)
            .when()
                .post("/login")
            .then()
                .statusCode(200)
                .extract()
                .as(LoginResponse.class);

        assertThat(response.getEmail(), nullValue());
    }

    @Test(groups = {"negative"})
    public void loginWithGetMethod() {
        given()
        .when()
            .get("/login")
        .then()
            .statusCode(404);
    }
}