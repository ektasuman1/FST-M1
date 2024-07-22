package activities;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class Activity1 {
    String ROOT_URI = "https://petstore.swagger.io/v2/pet";

    @Test(priority = 1)
    public void postData() {
        String reqBody = "{\"id\": 77232,\"name\": \"Riley\",\"status\": \"alive\"}";

        Response response =
                given().contentType(ContentType.JSON) // Set headers
                        .body(reqBody).when().post(ROOT_URI); // Send POST request

        // Print response of POST requestp
        String body = response.getBody().asPrettyString();
        System.out.println(body);

        //Assertion
        response.then().body("id", equalTo(77232));
        response.then().body("name", equalTo("Riley"));
        response.then().body("status", equalTo("alive"));
    }

    @Test(priority = 2)
    public void getData(){
        Response response =
                given().contentType(ContentType.JSON) // Set headers
                        .when().pathParam("petId", "77232") // Set path parameter
                        .get(ROOT_URI + "/{petId}");
        //Assertion
        response.then().body("id", equalTo(77232));
        response.then().body("name", equalTo("Riley"));
        response.then().body("status", equalTo("alive"));
    }

    @Test(priority = 3)
    public void deleteData(){
        Response response =
                given().contentType(ContentType.JSON) // Set headers
                        .when().pathParam("petId", "77232") // Set path parameter
                        .delete(ROOT_URI + "/{petId}"); // Send DELETE request
        //Assertion
        response.then().body("code", equalTo(200));
        response.then().body("message", equalTo("77232"));
    }
}
