package projectAPi;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.json.JSONObject;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class TC06_PUTUserapiJSONObject {

	@Test
	public void patchAPI() {
		
		Faker faker = new Faker();
		
		JSONObject requestBody = new JSONObject();
		requestBody.put("name","GOD");
		requestBody.put("email",faker.internet().emailAddress());
	
		         given()
		         .header("Accept", "application/json")
		         .header("Content-Type", "application/json")
				 .header("Authorization", "Bearer 54878a8aad0e9863c1f22d40cec9129ed96d83354df2c2d4e38e43271baf3b14") 

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
