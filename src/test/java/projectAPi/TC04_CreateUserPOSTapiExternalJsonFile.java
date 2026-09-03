package projectAPI;
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
	    JSONTokener tokener = new JSONTokener(read); //is used to read/parse JSON data, especially when you have JSON in the form of a String, file, or input stream {data from a source, byte by byte}
	    JSONObject requestBody = new JSONObject(tokener); //is a Java object used to represent JSON data as key-value pairs
	    
		         given()
		         .header("Accept", "application/json")
		         .header("Content-Type", "application/json")
				 .header("Authorization", "Bearer ef14fbe1484c31a9807a8d9b4932e1bf8f0eaade412275313cfc363546d38333") 
				 .body(requestBody.toString())
				 
				 .when()
				 .post("https://gorest.co.in/public/v2/users")

				 .then()
				 .log().status()
				 .log().body()
		         .statusCode(201);
		         
	}
}
