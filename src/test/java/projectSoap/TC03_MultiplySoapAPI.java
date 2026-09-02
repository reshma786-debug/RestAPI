package projectSoap;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.testng.annotations.Test;
import org.apache.commons.io.IOUtils;

public class TC03_MultiplySoapAPI {
	
	//http://www.dneonline.com/calculator.asmx
	//http://www.dneonline.com/calculator.asmx?op=Multiply
	
	@Test
	public void mutliplySoapAPI() throws IOException
	{
		
		File file = new File("C:\\Users\\Reshma\\eclipse-workspace\\RestAPIAutomation\\src\\main\\resources\\multiplySoapApi.xml");
		FileInputStream input = new FileInputStream(file);
		String requestBody = IOUtils.toString(input,"UTF-8");
		
		given()
		.header("Content-Type","text/xml; charset=utf-8")		
		.header("SOAPAction", "http://tempuri.org/Multiply")
		
		.when()
		.body(requestBody)
		.post("http://www.dneonline.com/calculator.asmx")
		
		.then()
		.log().body()
		.statusCode(200);
	}

}
