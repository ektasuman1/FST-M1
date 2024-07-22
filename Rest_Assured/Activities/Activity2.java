package activities;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class Activity2 {
    String baseURI="https://petstore.swagger.io/v2/user";

    @Test(priority = 1)
    public void addNewData() throws IOException {
        FileInputStream inputJson = new FileInputStream("src/main/resources/input.json");
        String reqBody = new String(inputJson.readAllBytes());

        Response response =
                given().contentType(ContentType.JSON) // Set headers
                        .body(reqBody).when().post(baseURI); // Send POST request

        // Print response of POST request
        String body = response.getBody().asPrettyString();
        System.out.println(body);


        //Assertion
        response.then().body("message", equalTo("1120"));
        response.then().body("code", equalTo(200));
    }

    @Test(priority = 2)
    public void getnewData(){
        Response response =
                given().contentType(ContentType.JSON) // Set headers
                        .when().pathParam("username", "alex") // Set path parameter
                        .get(baseURI + "/{username}");
        //Assertion
        response.then().body("id", equalTo(1120));
        response.then().body("username", equalTo("alex"));
        response.then().body("firstName", equalTo("Alex"));
        response.then().body("lastName", equalTo("Case"));
        response.then().body("email", equalTo("alex@mail.com"));
        response.then().body("password", equalTo("password123"));
        response.then().body("phone", equalTo("123456789"));


    }

    @Test(priority = 3)
    public void deletenewData(){
        Response response =
                given().contentType(ContentType.JSON) // Set headers
                        .when().pathParam("username", "alex") // Set path parameter
                        .delete(baseURI + "/{username}");
        //Assertion
        response.then().body("message", equalTo("alex"));
        response.then().body("code", equalTo(200));


    }
}
