package stepdefinitions;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;

public class APISteps {

    int statusCode;

    @Given("user sends GET request to users API")
    public void send_get_request() {
        statusCode = RestAssured
                .given()
                .when()
                .get("https://jsonplaceholder.typicode.com/users")
                .getStatusCode();
    }

    @Then("response status should be 200")
    public void validate_status_code() {
        if (statusCode == 200) {
            System.out.println("API Test Passed");
        } else {
            throw new RuntimeException("API Test Failed");
        }
    }
}