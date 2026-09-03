package projectPojoClass;
import static io.restassured.RestAssured.given;
import java.io.FileNotFoundException;
import org.testng.annotations.Test;

import com.google.gson.Gson;

import io.restassured.RestAssured;
import io.restassured.config.HeaderConfig;
import io.restassured.response.Response;

public class TC04_MultipleHeaders {

	@Test
	public void getAPI() throws FileNotFoundException {

		Response res = 
				given()
				.config(RestAssured.config().headerConfig(
					    HeaderConfig.headerConfig()
					        .mergeHeadersWithName("Authorization")
					))
				.header("Accept", "application/json")
				.header("Content-Type", "application/json")
				.header("Authorization", "Bearer 54878a8aad0e9863c1f22d40cec9129ed96d83354df2c2d4e38e43271baf3b14")
				.header("Authorization", "Bearer ef14fbe1484c31a9807a8d9b4932e1bf8f0eaade412275313cfc363546d38333")

				.when().get("https://gorest.co.in/public/v2/users/8600410")

				.then()
				.statusCode(200)
				.log().all()
				.extract().response();

		String response = res.asString();
		Gson gson = new Gson();
		TestPojo pojo = gson.fromJson(response, TestPojo.class);
		System.out.println("ID: " + pojo.getId());
		System.out.println("Name: " + pojo.getName());
		System.out.println("Active: " + pojo.isActive());
		

	}
}
