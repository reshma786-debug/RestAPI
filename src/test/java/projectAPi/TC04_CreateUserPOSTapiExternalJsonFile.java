package projectAPi;
import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.annotations.Test;

public class TC04_CreateUserPOSTapiExternalJsonFile {

	@Test
	public void createAPI() throws FileNotFoundException {
		 
		File file = new File("C:\\Users\\Reshma\\eclipse-workspace\\RestAPIAutomation\\src\\main\\resources\\JsonFile");
	    FileReader read = new FileReader(file);
	    JSONTokener tokener = new JSONTokener(read);
	    JSONObject requestBody = new JSONObject(tokener);
	    
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
		         .statusCode(201);
		         

	}
}
