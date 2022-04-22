package ResponseValidation;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.port;
import static io.restassured.RestAssured.when;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class StaticResponseValidationGetTest 
{
	@Test
	public void staticResonse()
	{
		
		String expData = "SDET30";
		baseURI = "http://localhost";
		port = 8084;
		
		
			
		Response resp = when()
			.get("/projects");
		
		//Validation
		String actData=resp.jsonPath().get("[0].projectName");
		Assert.assertTrue(actData.contains(expData));
		
		resp.then().log().all();
		
	}

}
