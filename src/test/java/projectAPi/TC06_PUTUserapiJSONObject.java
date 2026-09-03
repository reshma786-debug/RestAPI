package projectAPI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.json.JSONObject;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class TC06_PUTUserapiJSONObject {

	@Test
	public void putAPI() {
		
		Faker faker = new Faker();
		
		JSONObject requestBody = new JSONObject();
		requestBody.put("name","GOD");
		requestBody.put("email",faker.internet().emailAddress());
		requestBody.put("gender",faker.demographic().sex());
		requestBody.put("status","active");
	
		         given()
		         .header("Accept", "application/json")
		         .header("Content-Type", "application/json")
				 .header("Authorization", "Bearer ef14fbe1484c31a9807a8d9b4932e1bf8f0eaade412275313cfc363546d38333") 

				 .when()
				 .body(requestBody.toString())
				 .patch("https://gorest.co.in/public/v2/users/8600410")

				 .then()
				 .log().status()
				 .log().body()
		         .statusCode(200)
		         .body("status",equalTo("active"))
		         .body("name", equalTo("GOD"));

	}
}
