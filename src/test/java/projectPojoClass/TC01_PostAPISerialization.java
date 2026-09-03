package projectPojoClass;
import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.google.gson.Gson;

import io.restassured.response.Response;

public class TC01_PostAPISerialization {

	@Test
	public void postAPI() throws FileNotFoundException {
		
		Faker faker = new Faker(); //to generate the random test data
		
		String name = faker.name().fullName().toString();
		String gender= faker.demographic().sex().toLowerCase();
		String email= faker.internet().emailAddress();
		String status= "active";
		
		Gson gson = new Gson(); //you are creating an object of the Gson class, convert between Java objects and JSON.
		TestClassPojo pojo = new TestClassPojo(name,gender,email,status); //Plain Old Java Object //used to store data //convert Java objects ↔ JSON
		
		String payload = gson.toJson(pojo);

		Response res = 
				given()
				.baseUri("https://gorest.co.in/public/v2") //common/root URL of your API - URI - Uniform Resource Identifier
				.header("Accept", "application/json")      // I want the server to send the response in JSON format.
				.header("Content-Type", "application/json") //The data I am sending to the server is in JSON format.
				.header("Authorization", "Bearer 54878a8aad0e9863c1f22d40cec9129ed96d83354df2c2d4e38e43271baf3b14") //API Authentication Methods  - bearer
				.body(payload)
				
				.when()
				.post("/users") // http method // endpoint

				.then()
				.statusCode(201)
				.log().all()
				.extract().response();

		JSONObject obj = new JSONObject(res.asString());
		
		System.out.println(obj.get("gender"));
		Assert.assertEquals(obj.get("name"), name);
		Assert.assertEquals(obj.get("email"), email);
		Assert.assertEquals(obj.get("status"), status);
		Assert.assertEquals(obj.get("gender"), gender);
		

	}
}
