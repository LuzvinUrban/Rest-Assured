package com.cydeo.utilities;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
public class BookITUtils {

    public static  String getToken(String email, String password) {

String accessToken = given().accept(ContentType.JSON)
        .queryParam("email",email)
        .queryParam("password",password).
        when().get("/sign").then().statusCode(200)
        .extract().jsonPath().getString("accessToken");



        return "Bearer "+accessToken;


    }
}
