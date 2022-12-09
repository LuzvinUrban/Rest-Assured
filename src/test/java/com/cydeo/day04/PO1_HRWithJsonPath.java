package com.cydeo.day04;

import com.cydeo.utilities.HrTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PO1_HRWithJsonPath extends HrTestBase {

    /**
     * Given accept type is application/json
     * and query param limit is 200
     * When user send request/employees
     * then user should be....
     */

    @DisplayName("Get all /employees?limit=200--> JSONPATH")
    @Test
    public void test1() {


        Response response = given().accept(ContentType.JSON)
                .and()// it increases readability
                .queryParam("limit", 200).
                when().get("/employees");

        response.prettyPrint();


        //Status code
        assertEquals(200, response.statusCode());
        assertEquals(HttpStatus.SC_OK, response.statusCode());


        JsonPath jsonPath = response.jsonPath();
        //get all emails from response
        List<String> allEmails = jsonPath.getList("items.email");
        System.out.println("allEmails = " + allEmails);
        System.out.println("allEmails = " + allEmails.size());


        //get all emails who is working as IT PROG
        System.out.println("==================");
        List<String> emailsIT = jsonPath.getList("items.findAll{it.job_id=='IT_PROG'}.email");
        System.out.println("emailsIT = " + emailsIT);
        System.out.println("emailsIT = " + emailsIT.size());


        //get me all employees first name whose salary is more han 10000
        List<String> allEmployeesSalaryMoreThan10 = jsonPath.getList("items.findAll{it.salary>=10000}.first_name");
        System.out.println("allEmployeesSalaryMoreThan10 = " + allEmployeesSalaryMoreThan10);


        System.out.println("====================");
        // get me all information from response  who has max salary
        System.out.println("jsonPath.getString(\"items.max{it.salary}\") = " + jsonPath.getString("items.max{it.salary}"));


        System.out.println("====================");
        // get me firstname from response  who has max salary
        System.out.println("jsonPath.getString(\"items.max{it.salary}.first_name\") = " + jsonPath.getString("items.max{it.salary}.first_name"));


        // get me firstname from response  who has min salary
        System.out.println("====================");
        System.out.println("jsonPath.getString(\"items.min{it.salary}.first_name\") = " + jsonPath.getString("items.min{it.salary}.first_name"));

    }}