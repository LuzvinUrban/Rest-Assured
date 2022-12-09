package com.cydeo.day02;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PO1_SpartanGetRequests {


    String url="http://54.82.190.245:8000";


    /**
     * Given accept content type  is applicable/json
     * When user sends GET request api/spartans endpoint
     * Them status code should be 200
     * And Content type should be application/json
     *
     */
@DisplayName("Get All Spartans")
    @Test
    public void getAllSpartans() {

        Response response = RestAssured
                .given()
                .accept(ContentType.JSON)
                .when()
                .get(url + "/api/spartans");

        //print response
       // response.prettyPrint();


        //how to get status code

        int actualStatusCode = response.statusCode();
        Assertions.assertEquals(200, actualStatusCode);


        //how can we get ContentType
        String actualContentType = response.contentType();
        Assertions.assertEquals("application/json", actualContentType);


        //how to get header info
        String connection = response.header("Connection");
        System.out.println("connection = " + connection);


        //get content type with header
        System.out.println("resonse.header(\"Content-Type\")= " + response.header("Content-Type"));

// can we get connection() same as contentType() instead of using header?
        //A--> Rest Assured created couple of method for common usage
        //statusCode() contentType() methods are specifically created by them, so there is connection  method

        //get date header
        System.out.println("response.header(\"Date\")= " + response.header("Date"));


        //how can we verify date is exist?
        boolean isDateExist = response.headers().hasHeaderWithName("Date");

        Assertions.assertTrue(isDateExist);
        //Assertions.assertTrue(date);
    }

    /*
     * Given accept  content type is application/json
     * When user sends GET request /api/spartans/3 endpoint
     * Then status code should be 200
     * And Content type should be application/json
     * And response body needs to contains Fidole
     */


   @DisplayName ("Get Single Spartans")
   @Test
    public void getSpartans() {

       Response response = RestAssured
               .given()
               .accept(ContentType.JSON)
               .when()
               .get(url + "/api/spartans");

       //Verify Status Code
       Assertions.assertEquals(200, response.statusCode());

       response.prettyPrint();

       //Verify contentType is application json
       Assertions.assertEquals(ContentType.JSON.toString(), response.contentType());
       Assertions.assertEquals("application/json", response.contentType());
       Assertions.assertEquals("application/json", response.header("Content-Type"));
       Assertions.assertEquals(ContentType.JSON.toString(), "application/json", response.header("Content-Type"));
       //ContentType.JSON.toString()--> it makes enum to String to be able to use in assertions


       //Verify body Contains Fidole
       Assertions.assertTrue(response.body().asString().contains("Fidole"));

/*
it i snot good way to make assertion. In this we are just converting response to String ny the help pf String contains we are just looking into Response. In real we need to verify name Fidole, That's why we need access name key to get value of it which Fidole
 */
       //What if we have typo while we are getting header
       System.out.println("response.header(\"KeepAlive\" = " + response.header("KeepAlive"));

   }

    /*
         Given no headers provided
         When Users send GET request to /api/hello
         Then response status code should be 200
         And Content type header should be "text/plain;charset=UTF-8"
         And header should contain Date
         And Content-Length should be 17
         And body should be "Hello from Sparta"
     */
    @DisplayName("Hello Spartans")
    @Test
    public void helloSpartans (){
        Response response= RestAssured.when().get(url + "/api/hello");
RestAssured.given().get(url + "/api/hello");

        int statusCode = response.getStatusCode();
        Assertions.assertEquals(statusCode,200);

        String actualContentType = response.contentType();
        Assertions.assertEquals(actualContentType,"text/plain;charset=UTF-8");


        String header = response.getHeader("Content-Length");
        String body = response.getBody().asString();

        Assertions.assertTrue(response.headers().hasHeaderWithName("Date"));
        Assertions.assertEquals(header,"17");
       Assertions.assertEquals(body,"Hello from Sparta");

        }
    }

