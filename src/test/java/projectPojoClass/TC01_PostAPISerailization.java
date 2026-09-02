package projectPojoClass;
import static io.restassured.RestAssured.given;

import java.io.FileNotFoundException;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;
import com.google.gson.Gson;

import io.restassured.response.Response;

public class TC01_PostAPISerailization {

	@Test
	public void postAPI() throws FileNotFoundException {
		
		Faker faker = new Faker();
		
		String name = faker.name().fullName().toString();
		String gender= faker.demographic().sex();
		System.out.println(gender);
		String email= faker.internet().emailAddress();
		String status= "active";
		
		Gson gson = new Gson();
		TestClassPojo pojo = new TestClassPojo(name,gender,email,status);
		
		String payload = gson.toJson(pojo);

		Response res = given().header("Accept", "application/json")
				.header("Content-Type", "application/json")
				.header("Authorization", "Bearer 54878a8aad0e9863c1f22d40cec9129ed96d83354df2c2d4e38e43271baf3b14")
				//API Authentication Methods  - bearer

				.when()
				.body(payload)
				.post("https://gorest.co.in/public/v2/users")

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
