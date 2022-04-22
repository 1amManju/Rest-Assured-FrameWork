package ResponseValidation;

import org.junit.Assert;
import org.testng.annotations.Test;

import CommonLibraries.JavaUtils;
import ProjectLibraries.ProjectLibrary;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class StaticResponseValidationTest 
{
	@Test
	public void staticResonse()
	{
		JavaUtils jLib = new JavaUtils();
		ProjectLibrary pLib = new ProjectLibrary("Manju", "Amdocs_"+jLib.getRandomNo(), "Selected", 12);
		
		String expData = "Amdocs";
		baseURI = "http://localhost";
		port = 8084;
		
		Response resp = given()
							.body(pLib)
							.contentType(ContentType.JSON)
			
		.when()
			.post("/addProject");
		
		//Validtion
		String actData=resp.jsonPath().get("projectName");
		Assert.assertTrue(actData.contains(expData));
		
		resp.then().log().all();
		
	}

}
