package projectAPi;
import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;

public class TC05_DeleteUserApi {
 
	@Test
	public void deleteAPI()
	{
		given()
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.header("Authorization", "Bearer 54878a8aad0e9863c1f22d40cec9129ed96d83354df2c2d4e38e43271baf3b14") //OAuth Https Method
		
		.when()
		.delete("https://gorest.co.in/public/v2/users/8599803")
		 
	    .then()
		.statusCode(204);
		
	}
}
