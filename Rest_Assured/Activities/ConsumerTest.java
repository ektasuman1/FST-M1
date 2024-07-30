package pactproject;

import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit5.PactConsumerTestExt;
import au.com.dius.pact.consumer.junit5.PactTestFor;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;



import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(PactConsumerTestExt.class)
public class ConsumerTest {

    Map<String,String> headers = new HashMap<>();

    @Pact(consumer="UserConsumer",provider="UserProvider")
    public RequestResponsePact createPact(PactDslWithProvider builder){
        headers.put("Content-Type","application-json");

        //Set req/res
        DslPart requestResponseBody= new PactDslJsonBody()
                .numberType("id",100)
                .stringType("firstname","abc")
                .stringType("lastname","s")
                .stringType("email","abc@gmail.com");

        //create Contract
        return builder.given("POST Request")
                .uponReceiving("Request to create a user")
                .method("post")
                .path("/api/users")
                .headers(headers)
                .body(requestResponseBody)
                .willRespondWith()
                .status(201)
                .body(requestResponseBody)
                .toPact();
    }

    @Test
    @PactTestFor(providerName = "UserProvider",port = "8282")
    public void consumerTest(){
        Map<String,Object> reqBody = new HashMap<>();
        reqBody.put("id",100);
        reqBody.put("firstname","abc");
        reqBody.put("lastname","s");
        reqBody.put("email","abc@gmail.com");

        given().baseUri("http://localhost:8282/api/users")
                .headers(headers)
                .body(reqBody)
                .log().all()
                .when().post()
                .then().statusCode(201)
                .body("email", equalTo("abc@gmail.com")).log().all();
    }
}
