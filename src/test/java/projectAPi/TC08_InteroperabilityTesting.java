package projectAPI;
import static io.restassured.RestAssured.given;
import java.io.FileNotFoundException;
import org.testng.annotations.Test;

public class TC08_InteroperabilityTesting {

	@Test
	public void listUsersGETAPI() throws FileNotFoundException {

		         given()
		         .header("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/152.0.0.0 Safari/537.36")// Interoperability/Compatability testing
		         .header("Accept", "application/json")
		         .header("Content-Type", "appliaction/json")
				 .header("Authorization", "Bearer ef14fbe1484c31a9807a8d9b4932e1bf8f0eaade412275313cfc363546d38333") 

				 .when().get("https://gorest.co.in/public/v2/users")

				 .then().statusCode(200)
				 .log().status()
				 .log().body();

	}
}
