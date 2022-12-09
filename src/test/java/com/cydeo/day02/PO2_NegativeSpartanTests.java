package com.cydeo.day02;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PO2_NegativeSpartanTests {

    @BeforeAll
    public static void init(){

        RestAssured.baseURI="http://54.82.190.245:8000";

    }

    /*
     * Given accept  content type is application/json
     * When user sends GET request /api/spartans endpoint
     * Then status code should be 200
     */
    @DisplayName("GET All Spartans")
    @Test
    public void getAllSpartans() {

        Response response = RestAssured
                .given()
                .accept(ContentType.JSON)
                .when()
                .get("/api/spartans");

        // how to get status code
        int actualStatusCode = response.statusCode();

        Assertions.assertEquals(200, actualStatusCode);
    }
   /*
        Given Accept type application/xml
        When user send GET request to /api/spartans/10 end point
        Then status code must be 406
        And response Content Type must be application/xml;charset=UTF-8;
    */




@Test
public void test2(){

        Response response = RestAssured
        .given()
        .accept(ContentType.XML)
        .when()
        .get("/api/spartans/10");
        response.prettyPrint();

        Assertions.assertEquals(406,response.getStatusCode());
        Assertions.assertEquals("application/xml;charset=UTF-8",response.getContentType());

        }
        }









