package com.qa.pages;

/*import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
public class userAPI {
    private static final String USERS_ENDPOINT = "/users";

    public Response getUserById(int userId) {
        return given()
                .pathParam("id", userId)
                .when()
                .get(USERS_ENDPOINT + "/{id}");
}
    public Response createUser(String name, String email) {
        return given()
                .contentType("application/json")
                .body("{ \"name\": \"" + name + "\", \"email\": \"" + email + "\" }")
                .when()
                .post(USERS_ENDPOINT);
    }
}*/