package projectAPI;
import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;

public class TC07_DeleteUserApi {
 
	@Test
	public void deleteAPI()
	{
		given()
		.header("Accept","application/json")
		.header("Content-Type","application/json")
		.header("Authorization", "Bearer ef14fbe1484c31a9807a8d9b4932e1bf8f0eaade412275313cfc363546d38333") 
		
		.when()
		.delete("https://gorest.co.in/public/v2/users/8599803")
		 
	    .then()
		.statusCode(204);
		
	}
}
