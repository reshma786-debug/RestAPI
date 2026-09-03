package projectAPI;
import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import io.restassured.module.jsv.JsonSchemaValidator;

public class TC02_CreateUserPOSTapiHashMap {

	@Test
	public void createAPI() {
		 
		Faker faker = new Faker();
		
		Map<String,String>requestBody = new HashMap<>();
		requestBody.put("name",faker.name().toString());
		requestBody.put("gender",faker.demographic().sex());
		requestBody.put("email",faker.internet().emailAddress());
		requestBody.put("status","active");
	
		         given()
		         .header("Accept", "application/json")
		         .header("Content-Type", "application/json")
				 .header("Authorization", "Bearer ef14fbe1484c31a9807a8d9b4932e1bf8f0eaade412275313cfc363546d38333")  

				 .when()
				 .body(requestBody)
				 .post("https://gorest.co.in/public/v2/users")

				 .then()
				 .log().status()
				 .log().body()
		         .statusCode(201)
		         .assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath("./JsonSchemaFormatFile.json"))
		         .log().headers();
		         
	}
}
