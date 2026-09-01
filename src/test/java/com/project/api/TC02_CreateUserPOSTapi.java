package com.project.api;
import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

public class TC02_CreateUserPOSTapi {

	@Test
	public void createAPI() {
		 
		Map<String,String>requestBody = new HashMap<>();
		requestBody.put("name","reshma123");
		requestBody.put("gender","female");
		requestBody.put("email","r12eshma133@gmail.com");
		requestBody.put("status","active");
	
		         given()
		         .header("Accept", "application/json")
		         .header("Content-Type", "application/json")
				 .header("Authorization", "Bearer 54878a8aad0e9863c1f22d40cec9129ed96d83354df2c2d4e38e43271baf3b14") //OAuth Https Method

				 .when()
				 .body(requestBody)
				 .post("https://gorest.co.in/public/v2/users")

				 .then()
				 .log().status()
				 .log().body()
		         .statusCode(201)
		         .log().headers();
		         
	}
}
