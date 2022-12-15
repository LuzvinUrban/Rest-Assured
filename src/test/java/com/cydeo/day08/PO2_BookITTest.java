package com.cydeo.day08;

import com.cydeo.utilities.BookITUtils;
import com.cydeo.utilities.BookitTestBase;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
public class PO2_BookITTest extends BookitTestBase {
    String email = "lfinnisz@yolasite.com";
    String password = "lissiefinnis";
    String accessToken = BookITUtils.getToken(email, password);

    @DisplayName("GET /api/campuses ")
    @Test
    public void test1() {
        System.out.println(accessToken);
        given().accept(ContentType.JSON)
                .header("Authorization", accessToken).
                when().get("/api/campuses").prettyPeek()
                .then().statusCode(200);

    }
    /**Create  new util class and it will generate token based on your email and password
     * BookITUtils.getToken(String username, String password)
     */
    @DisplayName("GET /api/users/me")
    @Test
    public void test() {
        System.out.println(accessToken);
        given().accept(ContentType.JSON)
                .header("Authorization", accessToken).
                when().get("/api/users/me").prettyPeek().
                then().statusCode(200);

    }

    @DisplayName("GET /api/users/me ")
    @Test
    public void test2() {


















    }
}