package com.example;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "http://host.docker.internal:8080";
        RestAssured.useRelaxedHTTPSValidation();
    }
}
