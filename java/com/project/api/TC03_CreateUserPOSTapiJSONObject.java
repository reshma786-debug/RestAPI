package com.project.api;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import org.json.JSONObject;
import org.testng.annotations.Test;

public class TC03_CreateUserPOSTapiJSONObject {

	@Test
	public void createAPI() {
		 
		JSONObject requestBody = new JSONObject();
		requestBody.put("name","reshma12");
		requestBody.put("gender","female");
		requestBody.put("email","reshma2w312@gmail.com");
		requestBody.put("status","active");
	
		         given()
		         .header("Accept", "application/json")
		         .header("Content-Type", "application/json")
				 .header("Authorization", "Bearer 54878a8aad0e9863c1f22d40cec9129ed96d83354df2c2d4e38e43271baf3b14") //OAuth Https Method

				 .when()
				 .body(requestBody.toString())
				 .post("https://gorest.co.in/public/v2/users")

				 .then()
				 .log().status()
				 .log().body()
		         .statusCode(201)
		         .body("status",equalTo("active"));

	}
}
