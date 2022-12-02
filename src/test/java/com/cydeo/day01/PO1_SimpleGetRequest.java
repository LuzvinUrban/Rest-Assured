package com.cydeo.day01;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PO1_SimpleGetRequest {

    String url="http://54.82.190.245:8000/api/spartans";


    /**
     * When users end request to /api/spartans endpoint
     * Then user should be able to see status code is 200
     * And Print out response body into screen
     */

    @Test
    public void simpleGetRequest() {

//send request to url and get response as Response interface
        Response response = RestAssured.get(url);

//both same no difference
        System.out.println("response.getStatusCode() = " + response.getStatusCode());
        System.out.println("response.StatusCode() = " + response.getStatusCode());


        // it gives all status line
        System.out.println("response.statusLine() = " + response.statusLine());


        int actualStatusCode = response.statusCode();

        Assertions.assertEquals(200, actualStatusCode);

        //how to print screen?
        response.prettyPrint();


        //print body
        // System.out.println(response.body().asString());
    }

        @Test
                public void simpleGetRequest2(){

            Response response = RestAssured.get(url);

            //verify status code 200

        }
    }

