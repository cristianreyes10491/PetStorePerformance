package com.qa.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;



public class APIClient {

	public final static int RESPONSE_CODE_200 = 200;
	public final static int RESPONSE_CODE_201 = 201;
	public final static int RESPONSE_CODE_400 = 400;
	public final static int RESPONSE_CODE_401 = 401;
	private static final String BASE_URL = "http://localhost:8080";

	public Response getPetById(int petId) {
		return given()
				.baseUri(BASE_URL)
				.pathParam("id", petId)
				.when()
				.get("/pet/{petId}");
	}

	public Response createPet(String name, String status) {
		return given()
				.baseUri(BASE_URL)
				.contentType("application/json")
				.body("{ \"name\": \"" + name + "\", \"email\": \"" + status + "\" }")
				.when()
				.post("/users");
	}

	// Other methods
}


