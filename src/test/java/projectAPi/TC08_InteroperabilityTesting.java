package projectAPi;
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
				 .header("Authorization", "Bearer 54878a8aad0e9863c1f22d40cec9129ed96d83354df2c2d4e38e43271baf3b14") 

				 .when().get("https://gorest.co.in/public/v2/users")

				 .then().statusCode(200)
				 .log().status()
				 .log().body();

	}
}
