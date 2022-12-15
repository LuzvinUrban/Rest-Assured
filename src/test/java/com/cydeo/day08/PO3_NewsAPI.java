package com.cydeo.day08;

import com.cydeo.utilities.NewsAPITestBase;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
public class PO3_NewsAPI extends NewsAPITestBase {


    // f83c7864f4024e21a064bf59f5d992b1
    @Test
    public void test1() {
        given().queryParam("q", "bitcoin")
                .queryParam("apiKey", "f83c7864f4024e21a064bf59f5d992b1").
                when().get("/everything").prettyPeek().then().statusCode(200);


    }

    /**
     * TASK 2 —> X-Api-Key in HEADER
     * - Given query param is q=“bitcoin”
     * - And header is X-Api-Key=“yourKey”
     * - When user sent request / everything endpoint - Then status code should be 200
     * - And each articles contains “bitcoin”
     */

    @Test
    public void test2() {

        //f83c7864f4024e21a064bf59f5d992b1
        given().log().uri().queryParam("q", "bitcoin")
                .header("X-Api-Key", "f83c7864f4024e21a064bf59f5d992b1").
                when().get("/everything").prettyPeek().then().statusCode(200);


    }
    /**
     * TASK 3 —> Authorization in HEADER
     * - Given query param is q=“bitcoin”
     * - And header is Authorization=“yourKey”
     * - When user sent request / everything endpoint - Then status code should be 200
     * - And each articles contains “bitcoin”
     */
    @Test
    public void test3() {

        given().log().uri().queryParam("q", "bitcoin")
                .header("Authorization", "f83c7864f4024e21a064bf59f5d992b1").
                when().get("/everything").prettyPeek().then().statusCode(200);
    }

    /**
     * TASK 4 —> Authorization in HEADER
     * - Given query param is country=“us”
     * - And header is Bearer “yourKey”
     * - When user sent request / top-headlines endpoint - Then status code should be 200
     * - And print out all sources names
     */

    @Test
    public void test4() {

        //f83c7864f4024e21a064bf59f5d992b1

        given().log().uri().queryParam("country","us")
                .header("Authorization","Bearer f83c7864f4024e21a064bf59f5d992b1").
                when().get("/top-headlines").prettyPeek().then().statusCode(200);
    }
}