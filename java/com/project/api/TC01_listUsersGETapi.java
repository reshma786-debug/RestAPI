package com.project.api;
import static io.restassured.RestAssured.given;
import java.io.FileNotFoundException;
import org.testng.annotations.Test;

public class TC01_listUsersGETapi {

	@Test
	public void listUsersGETAPI() throws FileNotFoundException {

		         given()
		         .header("Accept", "application/json")
		         .header("Content-Type", "appliaction/json")
				 .header("Authorization", "Bearer 54878a8aad0e9863c1f22d40cec9129ed96d83354df2c2d4e38e43271baf3b14") //OAuth Http Method

				 .when().get("https://gorest.co.in/public/v2/users")

				 .then().statusCode(200)
				 .log().status()
				 .log().body();

	}
}
