package projectAPi;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.json.JSONObject;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class TC03_CreateUserPOSTapiJSONObject {

	@Test
	public void createAPI() {
		
		Faker faker = new Faker();
		
		JSONObject requestBody = new JSONObject();
		requestBody.put("name",faker.name().toString());
		requestBody.put("gender",faker.demographic().sex());
		requestBody.put("email",faker.internet().emailAddress());
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
